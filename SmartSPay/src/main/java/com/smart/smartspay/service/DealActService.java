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
import com.smart.smartspay.entity.Dealrule;
import com.smart.smartspay.entity.Item;
import com.smart.smartspay.entity.Itemdealrecord;
import com.smart.smartspay.entity.Itemdealrecordstream;
import com.smart.smartspay.entity.Myaccountstory;
import com.smart.smartspay.entity.Ledger;
import com.smart.smartspay.entity.Ledgerdealrecordstream;
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
import com.smart.smartspay.repository.ItemRepository;
import com.smart.smartspay.repository.LedgerStoryRepository;
import com.smart.smartspay.repository.LedgerRepository;
import com.smart.smartspay.repository.MyaccountRepository;
import com.smart.smartspay.repository.MyaccountStoryRepository;
import com.smart.smartspay.util.DealUtil;
import com.smart.smartspay.util.ResponseResultCode;
import java.util.ArrayList;
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
    @Resource
    ItemRepository itemRepository;

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
        // 根据 from to dealType（充值交易01） 获取交易渠道
        Actchannel actChannel = actChannelRepository.findByAccountToIssueAndAccountFromIssueAndDealType(toLedger.getAccountIssue(), fromLedger.getAccountIssue(), "01");
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

        //根据交易渠道获取  交易接口定义 
        List<Dealinterface> dealInterface_list = dealInterfaceRepository.findByDealinterfacePK_DealRuleNo(actChannel.getDealRuleNo());
        if (dealInterface_list == null || dealInterface_list.isEmpty()) {
            throw new CustomErrorCodeException(ResponseResultCode.ErrorUndefinedDealInterface, "undefined dealInterface");
        }
        //invoke pay interface 
        // from account issue 01 alipay ,
        if (actChannel.getAccountFromIssue().equals("01")) {
            //invoke alipay 

            //if result error ,record and repose error;
            //if result success, record and contiune;
            
        }
        //generate act no
        String actNo = DealUtil.generateActNo();
        Date currentDate = new Date();
        //交易记录 
        Acton acton = buildActOn(actNo, userId, fromLedger.getLedgerId(), toLedger.getLedgerId(), totalMoney, currentDate, 1, accountBind == null ? null : accountBind.getAccountBindId());
        Actonrecord actonRecord = buildActOnRecord(acton);

        //账目, 分户账 记录
        List<Itemdealrecordstream> list_ItemDealRecordStream = new ArrayList<Itemdealrecordstream>();
        List<Ledgerdealrecordstream> list_ItemLedgerDealRecordStream = new ArrayList<Ledgerdealrecordstream>();
        buildItemDealRecord(list_ItemDealRecordStream, list_ItemLedgerDealRecordStream, actChannel.getDealRuleNo(), totalMoney, currentDate, actNo, userId, toLedger, fromLedger);
        if (list_ItemDealRecordStream.isEmpty()) {
            throw new CustomErrorCodeException(ResponseResultCode.ErrorBuildItemDealStreamEmpty, "build item deal record stream empty.");
        }
        if (list_ItemDealRecordStream.isEmpty()) {
            throw new CustomErrorCodeException(ResponseResultCode.ErrorBuildLedgerDealStreamEmpty, "build ledger deal record stream empty.");
        }

        //TODO save to db . deal success.
    }

//    private List<Ledgerdealrecordstream> buildLedgerDealRecordStream() {
//        
//    }
    private void buildItemDealRecord(List<Itemdealrecordstream> list_itemDealRecordStream, List<Ledgerdealrecordstream> list_ItemLedgerDealRecordStream, String dealRuleNo, String balance, Date dealDate, String dealId, String userId, Ledger toLedger, Ledger fromLedger) throws CustomErrorCodeException {
        List<Dealrule> list_dealRule = dealRuleRepository.findByDealrulePK_DealRuleNo(dealRuleNo);
        if (list_dealRule == null || list_dealRule.isEmpty()) {
            throw new CustomErrorCodeException(ResponseResultCode.ErrorUndefinedDealRule, "undefined DealRule.");
        }
        Itemdealrecordstream itemDealRecordStream = null;
        Item item = null;
//        Ledger ledger = null;
        Ledgerdealrecordstream ledgerDealRecordStream = null;
        String calcBalance = null;
//        List<Itemdealrecordstream> list_itemDealRecordStream = new ArrayList<Itemdealrecordstream>();
//        List<Ledgerdealrecordstream> list_ItemLedgerDealRecordStream = new ArrayList<Ledgerdealrecordstream>();

        for (Dealrule dealRule : list_dealRule) {
            item = itemRepository.findOne(dealRule.getItemIId());
            if (item == null) {
                throw new CustomErrorCodeException(ResponseResultCode.ErrorUndefinedItem, "undefined item");
            }
            calcBalance = UtileSmart.multiply(balance, dealRule.getScale());

            itemDealRecordStream = new Itemdealrecordstream();
            itemDealRecordStream.setDealDealTime(dealDate);
            itemDealRecordStream.setDealId(dealId);
            itemDealRecordStream.setCreditORDebit(item.getCreditORDebit());
            itemDealRecordStream.setItemId(item.getItemId());
            itemDealRecordStream.setBalance(calcBalance);
            list_itemDealRecordStream.add(itemDealRecordStream);

            if (item.getItemId().equals(fromLedger.getItemId()) || item.getItemId().equals(toLedger.getItemId())) {
                ledgerDealRecordStream = new Ledgerdealrecordstream();
                ledgerDealRecordStream.setAccountBalance(calcBalance);
                ledgerDealRecordStream.setDealDateTime(dealDate);
                ledgerDealRecordStream.setItemId(item.getItemId());
                ledgerDealRecordStream.setUserId(userId);
                ledgerDealRecordStream.setDealId(dealId);
                ledgerDealRecordStream.setLedgerId(item.getItemId().equals(fromLedger.getItemId()) ? fromLedger.getLedgerId() : toLedger.getLedgerId());
                ledgerDealRecordStream.setUserAccountNum(item.getItemId().equals(fromLedger.getItemId()) ? fromLedger.getAccountNum() : toLedger.getAccountNum());
                list_ItemLedgerDealRecordStream.add(ledgerDealRecordStream);
            }

        }
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
        ledger.setAccountNum(myaccount.getAccountNum());
        ledger.setAccountIssue(myaccount.getAccountIssue());
        ledger.setUserId(myaccount.getUserId());
        ledger.setItemId(myaccount.getItemId());
        ledger.setLedgerId(myaccount.getAccountId());
        ledger.setLedgerStatus(1);
        ledger.setOperationDateTime(myaccount.getOperationTime());

        Ledgerstory ledgerStory = new Ledgerstory();
        ledgerStory.setAccountBalance(ledger.getAccountBalance());
        ledgerStory.setDealSeq(ledger.getDealSeq());
        ledgerStory.setPutLedgerDateTime(ledger.getPutLedgerDateTime());
        ledgerStory.setAccountNum(ledger.getAccountNum());
        ledgerStory.setAccountIssue(ledger.getAccountIssue());
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
        ledgerStory.setAccountIssue(ledger.getAccountIssue());
        ledgerStory.setAccountNum(ledger.getAccountNum());
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
