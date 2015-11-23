/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartspay.entity.Note;
import com.smart.smartspay.entity.Notelaud;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.exception.RepeatOperateException;
import com.smart.smartspay.repository.NoteLaudRepository;
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

    @Resource
    NoteLaudRepository noteLaudRepository;

    @Transactional
    public void readNote(String noteId) {
        Note note = noteReository.findOne(noteId);
        int readCount = note.getReadCount();
        note.setReadCount(++readCount);
        noteReository.save(note);
    }

    @Transactional
    public void laudNote(String noteId, String userId) throws NotFoundException, RepeatOperateException {
        Note note = noteReository.findOne(noteId);
        if (note == null) {
            throw new NotFoundException("note not found.id:" + noteId);
        }
        Long laund = noteLaudRepository.countByNoteIdAndUserId(note, userId);
        if (laund != 0) {
            throw new RepeatOperateException(String.format("the user repeat laud. '%s' ", userId));
        }

        int readCount = note.getLaudCount();
        note.setLaudCount(++readCount);
        noteReository.save(note);
        Notelaud notelaud = new Notelaud();
        notelaud.setNoteId(note);
        notelaud.setUserId(userId);
        noteLaudRepository.save(notelaud);

    }
}
