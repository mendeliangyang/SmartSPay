/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Dealrule;
import com.smart.smartspay.entity.DealrulePK;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface DealRuleRepository extends PagingAndSortingRepository<Dealrule, DealrulePK> {

    List<Dealrule> findByDealrulePK_DealRuleNo(String dealRuleNo);
}
