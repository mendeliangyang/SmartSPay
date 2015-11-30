/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Notelaud;
import com.smart.smartspay.entity.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface NoteLaudRepository extends PagingAndSortingRepository<Notelaud, String> {

    Long countByNoteIdAndUserId(Note noteId,String userId);
    Notelaud findByNoteIdAndUserId(Note noteId, String userId);
}
