/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Accountissue;
import com.smart.smartspay.entity.Myaccountstory;
import com.smart.smartspay.entity.Ledger;
import com.smart.smartspay.entity.Ledgerstory;
import com.smart.smartspay.entity.Myaccount;
import com.smart.smartspay.exception.AccountInfoFailException;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.exception.NotFoundItemLedgerException;
import com.smart.smartspay.repository.AccountIssueRepository;
import com.smart.smartspay.repository.DealTypeRepository;
import com.smart.smartspay.repository.LedgerStoryRepository;
import com.smart.smartspay.repository.LedgerRepository;
import com.smart.smartspay.repository.MyaccountRepository;
import com.smart.smartspay.repository.MyaccountStoryRepository;
import com.smart.smartspay.util.ResponseResultCode;
import java.util.Date;
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
