/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartspay.entity.Note;
import com.smart.smartspay.repository.NoteRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class NoteService {

    @Resource
    NoteRepository noteReository;

    @Transactional
    public void readNote(String noteId) {
        Note note = noteReository.findOne(noteId);
        int readCount = note.getReadCount();
        note.setReadCount(++readCount);
        noteReository.save(note);
    }

    @Transactional
    public void laudNote(String noteId) {
        Note note = noteReository.findOne(noteId);
        int readCount = note.getLaudCount();
        note.setLaudCount(++readCount);
        noteReository.save(note);
    }
}
