/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Accountissue;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface AccountIssueRepository extends PagingAndSortingRepository<Accountissue, String> {

    @Override
    List<Accountissue> findAll();

    Accountissue findByIssueDescribe(String issueDescribe);
}
