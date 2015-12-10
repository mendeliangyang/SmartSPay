/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Accountbind;
import com.smart.smartspay.entity.Accountissue;
import com.smart.smartspay.entity.Actchannel;
import com.smart.smartspay.entity.Acton;
import com.smart.smartspay.entity.Actonrecord;
import com.smart.smartspay.entity.Dealinterface;
import com.smart.smartspay.entity.Myaccountstory;
import com.smart.smartspay.entity.Ledger;
import com.smart.smartspay.entity.Ledgerstory;
import com.smart.smartspay.entity.Myaccount;
import com.smart.smartspay.exception.AccountInfoFailException;
import com.smart.smartspay.exception.CustomErrorCodeException;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.exception.NotFoundItemLedgerException;
import com.smart.smartspay.repository.AccountBindRepository;
import com.smart.smartspay.repository.AccountIssueRepository;
import com.smart.smartspay.repository.ActChannelRepository;
import com.smart.smartspay.repository.DealInterfaceRepository;
import com.smart.smartspay.repository.DealRuleRepository;
import com.smart.smartspay.repository.DealTypeRepository;
import com.smart.smartspay.repository.LedgerStoryRepository;
import com.smart.smartspay.repository.LedgerRepository;
import com.smart.smartspay.repository.MyaccountRepository;
import com.smart.smartspay.repository.MyaccountStoryRepository;
import com.smart.smartspay.util.DealUtil;
import com.smart.smartspay.util.ResponseResultCode;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class DealActService {

    @Resource
    AccountIssueRepository accountIssueRepository;

    @Resource
    DealTypeRepository dealTypeRepository;

    @Resource
    MyaccountRepository myaccountRepository;

    @Resource
    MyaccountStoryRepository myaccountStoryRepository;

    @Resource
    LedgerStoryRepository ledgerStoryRepository;

    @Resource
    LedgerRepository ledgerRepository;

    @Resource
    ActChannelRepository actChannelRepository;

    @Resource
    DealInterfaceRepository dealInterfaceRepository;

    @Resource
    DealRuleRepository dealRuleRepository;
    @Resource
    AccountBindRepository accountBindRepository;

    @Transactional
    public void ActAccount(String toAccountId, String fromAccountId, String totalMoney, String userId) throws NotFoundException, CustomErrorCodeException {
        //查找对应的交易编号渠道
        Ledger toLedger = ledgerRepository.findOne(toAccountId);
        if (toLedger == null) {
            throw new NotFoundException(String.format("ToAccountNotFound:'%s'", toAccountId));
        }
        Ledger fromLedger = ledgerRepository.findOne(fromAccountId);
        if (fromLedger == null) {
            throw new NotFoundException(String.format("FromAccountNotFound:'%s'", fromAccountId));
        }
        // 获取交易渠道
        Actchannel actChannel = actChannelRepository.findByAccountToIssueAndAccountFromIssue(toLedger.getUserAccountIssue(), fromLedger.getUserAccountIssue());
        if (actChannel == null) {
            throw new CustomErrorCodeException(ResponseResultCode.ErrorUndefinedActChannel, "Undefined actChannel.");
        }
        Accountbind accountBind = null;
        //需要绑定验证绑定关系
        if (actChannel.getBindMust() == 2) {
            //验证绑定
            accountBind = verifyAccountBind(fromLedger.getLedgerId(), toLedger.getLedgerId());
            if (accountBind == null) {
                throw new CustomErrorCodeException(ResponseResultCode.ErrorDealAccountUnBind, "deal accoun UnBind");
            }
        }

        //根据交易渠道获取 交易规则 和交易接口定义
        List<Dealinterface> dealInterface_list = dealInterfaceRepository.findByDealinterfacePK_DealRuleNo(actChannel.getDealRuleNo());
        if (dealInterface_list == null || dealInterface_list.isEmpty()) {
            throw new CustomErrorCodeException(ResponseResultCode.ErrorUndefinedDealInterface, "undefined dealInterface");
        }
        //invoke pay interface 
        if (actChannel.getAccountToIssue().equals("01") && actChannel.getDealType().equals("01")) {
            //invoke alipay 

            //if result error ,record and repose error;
            //if result success, record and contiune;
        }
        //generate act no

        Date currentDate = new Date();
        //写交易记录 
        Acton acton = buildActOn(DealUtil.generateActNo(), userId, fromLedger.getLedgerId(), toLedger.getLedgerId(), totalMoney, currentDate, 1, accountBind == null ? null : accountBind.getAccountBindId());
        Actonrecord actonRecord = buildActOnRecord(acton);
    }

    private Acton buildActOn(String actNo, String userId, String fromAccount, String toAccount, String money, Date operationDate, int actOnStatus, String accountBind) {
        Acton acton = new Acton();
        acton.setActOnId(actNo);
        acton.setUserId(userId);
        acton.setFromAccountId(fromAccount);
        acton.setToAccountId(toAccount);
        acton.setActOnDateTime(operationDate);
        acton.setMoney(money);
        acton.setOperationTime(operationDate);
        acton.setActOnStatus(actOnStatus);
        acton.setAccountBindId(accountBind);
        return acton;

    }

    private Actonrecord buildActOnRecord(Acton acton) {
        Actonrecord actonRecord = new Actonrecord();
        actonRecord.setActOnId(acton.getActOnId());
        actonRecord.setUserId(acton.getUserId());
        actonRecord.setFromAccountId(acton.getFromAccountId());
        actonRecord.setToAccountId(acton.getToAccountId());
        actonRecord.setActOnDateTime(acton.getActOnDateTime());
        actonRecord.setMoney(acton.getMoney());
        actonRecord.setOperationTime(acton.getOperationTime());
        actonRecord.setActOnStatus(acton.getActOnStatus());
        actonRecord.setAccountBindId(acton.getAccountBindId());
        return actonRecord;

    }

    private Accountbind verifyAccountBind(String fromAccount, String toAccount) {
        return accountBindRepository.findByFromAccountIdAndToAccountId(fromAccount, toAccount);
    }

    @Transactional
    public void putPrivateAccount(Myaccount myaccount) throws NotFoundItemLedgerException, NotFoundException {
        Myaccountstory myaccountStory = new Myaccountstory();
        myaccountStory.setAccountId(myaccount.getAccountId());
        myaccountStory.setAccountIssue(myaccount.getAccountIssue());
        myaccountStory.setAccountNum(myaccount.getAccountNum());
        myaccountStory.setItemId(myaccount.getItemId());
        myaccountStory.setMasterRealName(myaccount.getMasterRealName());
        myaccountStory.setMasterVerifyPhone(myaccount.getMasterVerifyPhone());
        myaccountStory.setOperationTime(myaccount.getOperationTime());
        myaccountStory.setPutTime(myaccount.getPutTime());
        myaccountStory.setUserId(myaccount.getUserId());
        myaccountStory.setValidStatus(myaccount.getValidStatus());

        //build ledger
        Ledger ledger = new Ledger();
        ledger.setAccountBalance(0);
        ledger.setDealSeq(0);
        ledger.setPutLedgerDateTime(myaccount.getPutTime());
        ledger.setUserAccountNum(myaccount.getAccountNum());
        ledger.setUserAccountIssue(myaccount.getAccountIssue());
        ledger.setUserId(myaccount.getUserId());
        ledger.setItemId(myaccount.getItemId());
        ledger.setLedgerId(myaccount.getAccountId());
        ledger.setLedgerStatus(1);
        ledger.setOperationDateTime(myaccount.getOperationTime());

        Ledgerstory ledgerStory = new Ledgerstory();
        ledgerStory.setAccountBalance(ledger.getAccountBalance());
        ledgerStory.setDealSeq(ledger.getDealSeq());
        ledgerStory.setPutLedgerDateTime(ledger.getPutLedgerDateTime());
        ledgerStory.setUserAccountNum(ledger.getUserAccountNum());
        ledgerStory.setUserAccountIssue(ledger.getUserAccountIssue());
        ledgerStory.setUserId(ledger.getUserId());
        ledgerStory.setItemId(ledger.getItemId());
        ledgerStory.setLedgerId(ledger.getLedgerId());
        ledgerStory.setLedgerStatus(ledger.getLedgerStatus());
        ledgerStory.setOperationDateTime(ledger.getOperationDateTime());

        Accountissue accountIssue = accountIssueRepository.findOne(myaccount.getAccountIssue());
        if (accountIssue == null) {
            throw new NotFoundException(ResponseResultCode.ErrorNotFound, String.format("accountIssue :'%s' not find.", myaccount.getAccountIssue()));
        }
        if (accountIssue.getItemIdPrivate() == null || accountIssue.getItemIdPrivate().isEmpty()) {
            throw new NotFoundItemLedgerException(ResponseResultCode.ErrorAccountIssueLackItem, String.format("accountIssue :'%s' lack item.", myaccount.getAccountIssue()));
        }
        //set item
        ledger.setItemId(accountIssue.getItemIdPrivate());
        ledgerStory.setItemId(ledger.getItemId());
        myaccount.setItemId(accountIssue.getItemIdPrivate());
        myaccountStory.setItemId(myaccount.getItemId());

        myaccountRepository.save(myaccount);
        ledgerRepository.save(ledger);
        myaccountStoryRepository.save(myaccountStory);
        ledgerStoryRepository.save(ledgerStory);

    }

    @Transactional
    public void invalidPrivateAccount(String myaccountId) throws AccountInfoFailException {
        //find myaccount,and ledger
        //todo 检查充值为滴卡的数据
        Myaccount myaccount = myaccountRepository.findOne(myaccountId);
        Ledger ledger = ledgerRepository.findOne(myaccountId);
        if (myaccount == null || ledger == null) {
            throw new AccountInfoFailException(ResponseResultCode.ErrorNotFound, "account information failed, please contact admin.");
        }
        Myaccountstory myaccountStory = new Myaccountstory();
        myaccountStory.setAccountId(myaccount.getAccountId());
        myaccountStory.setAccountIssue(myaccount.getAccountIssue());
        myaccountStory.setAccountNum(myaccount.getAccountNum());
        myaccountStory.setOperationTime(new Date());
        myaccountStory.setItemId(myaccount.getItemId());
        myaccountStory.setMasterRealName(myaccount.getMasterRealName());
        myaccountStory.setMasterVerifyPhone(myaccount.getMasterVerifyPhone());
        myaccountStory.setUserId(myaccount.getUserId());
        myaccountStory.setPutTime(myaccount.getPutTime());
        myaccountStory.setValidStatus(2);
        myaccountStory.setOperationTime(new Date());

        Ledgerstory ledgerStory = new Ledgerstory();
        ledgerStory.setAccountBalance(ledger.getAccountBalance());
        ledgerStory.setDealSeq(ledger.getDealSeq());
        ledgerStory.setItemId(ledger.getItemId());
        ledgerStory.setPutLedgerDateTime(ledger.getPutLedgerDateTime());
        ledgerStory.setUserAccountIssue(ledger.getUserAccountIssue());
        ledgerStory.setUserAccountNum(ledger.getUserAccountNum());
        ledgerStory.setUserId(ledger.getUserId());
        ledgerStory.setLedgerId(ledger.getLedgerId());
        ledgerStory.setLedgerStatus(2);
        ledgerStory.setOperationDateTime(myaccount.getOperationTime());

        ledgerStoryRepository.save(ledgerStory);
        myaccountStoryRepository.save(myaccountStory);
        ledgerRepository.delete(ledger);
        myaccountRepository.delete(myaccount.getAccountId());
    }

}
