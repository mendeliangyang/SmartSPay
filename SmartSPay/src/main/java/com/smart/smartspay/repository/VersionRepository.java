/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Version;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface VersionRepository  extends PagingAndSortingRepository<Version, String> {
    //@Query("select v from Version v order by putDate desc limit 1 ")
    Version findTopByOrderByPutDateDesc();
}
