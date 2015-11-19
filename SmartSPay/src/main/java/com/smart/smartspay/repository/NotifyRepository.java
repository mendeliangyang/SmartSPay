/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Notify;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 *
 * @author Administrator
 */
public interface NotifyRepository extends PagingAndSortingRepository<Notify, String> {

    Notify findBynotifyId(String notifyId);

    Page<Notify> findByputDateBefore(Date putDate, Pageable pageable);

    Page<Notify> findAll(Pageable pageable);
}
