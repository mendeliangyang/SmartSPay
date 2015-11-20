/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Note;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface NoteRepository extends PagingAndSortingRepository<Note, String> {

    Note findOne(String notifyId);

    Page<Note> findByPutDateBefore(Date putDate, Pageable pageable);

    Page<Note> findAll(Pageable pageable);

}
