/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Actchannel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface ActChannelRepository extends PagingAndSortingRepository<Actchannel, String> {

    Actchannel findByAccountToIssueAndAccountFromIssueAndDealType(String accountToIssue, String accountFromIssue, String dealType);
}
