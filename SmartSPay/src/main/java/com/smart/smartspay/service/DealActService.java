/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartspay.repository.AccountIssueRepository;
import com.smart.smartspay.repository.DealTypeRepository;
import com.smart.smartspay.repository.LedgerLogRepository;
import com.smart.smartspay.repository.LedgerRepository;
import com.smart.smartspay.repository.MyaccountRepository;
import com.smart.smartspay.repository.MyaccountStoryRepository;
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
    LedgerLogRepository ledgerLogRepository;
    
    @Resource
    LedgerRepository ledgerRepository;
    
    @Transactional
    public void putPrivateAccount() {
        
    }
}
