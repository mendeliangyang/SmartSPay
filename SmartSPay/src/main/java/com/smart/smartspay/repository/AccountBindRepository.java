/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Accountbind;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface AccountBindRepository extends PagingAndSortingRepository<Accountbind, String> {

    Accountbind findByFromAccountIdAndToAccountId(String fromAccountId, String toAccountId);

}
