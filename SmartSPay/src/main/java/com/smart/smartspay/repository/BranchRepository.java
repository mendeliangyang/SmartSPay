/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Branch;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface BranchRepository extends PagingAndSortingRepository<Branch, String> {

    List<Branch> findByBranchUpId(String branchUpId);
    
    List<Branch> findByBranchNameContaining(String branchName);
}
