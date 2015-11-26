/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Branch;
import com.smart.smartspay.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, String> {

    Page<Contact> findByBranchId(Branch branchId, Pageable pageable);

    Page<Contact> findByContactNameContaining(String contactName, Pageable pageable);
}
