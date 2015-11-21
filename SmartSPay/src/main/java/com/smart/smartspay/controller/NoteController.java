/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Filedepot;
import com.smart.smartspay.entity.Note;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.repository.NoteRepository;
import com.smart.smartspay.service.FileDepotService;
import com.smart.smartspay.service.NoteService;
import com.smart.smartspay.util.ResponseFormationJson;
import com.smart.smartspay.util.ResponseResultCode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/Note")
public class NoteController {

    @Resource
    private NoteRepository noteRepository;

    @Resource
    private FileDepotService fileDepotService;

    @Resource

    NoteService noteService;

    @RequestMapping(value = "/getNote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getNotify(@RequestBody String param) throws Exception {
        String paramKey_noteId = "noteId";
        String paramKey_pageIndex = "pageIndex";
        String paramKey_pageSize = "pageSize";
        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        String firstNoteId = UtileSmart.getStringFromMap(paramMap, paramKey_noteId);

        Note note = noteRepository.findOne(firstNoteId);

        if (note == null) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorNotFound, String.format("noteId:'%s' don't exist", firstNoteId), null);
        }

        Pageable pageable = new PageRequest(UtileSmart.getIntFromMap(paramMap, paramKey_pageIndex), UtileSmart.getIntFromMap(paramMap, paramKey_pageSize), Sort.Direction.DESC, "PutDate");

        Page<Note> notes = noteRepository.findByPutDateBefore(note.getPutDate(), pageable);

        fileDepotService.getFilesByOwn(notes);

        return ResponseFormationJson.FormationResponseSucess(notes.getTotalElements(), notes.getContent());
    }

    @RequestMapping(value = "/putNote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String putNotify(@RequestBody String param) throws Exception {

        String paramKey_title = "title";
        String paramKey_content = "content";
        String paramKey_putUserId = "putUserId";
        String paramKey_communityId = "communityId";

        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        Note note = new Note();
        note.setTitle(UtileSmart.getStringFromMap(paramMap, paramKey_title));
        note.setContent(UtileSmart.getStringFromMap(paramMap, paramKey_content));
        note.setLaudCount(0);
        note.setReadCount(0);
        note.setPutDate(new Date());
        note.setCommunityId(UtileSmart.getStringFromMap(paramMap, paramKey_communityId));
        Userdetail user = new Userdetail();
        user.setUserId(UtileSmart.getStringFromMap(paramMap, paramKey_putUserId));
        note.setPutUserId(user);
        noteRepository.save(note);

        return ResponseFormationJson.FormationResponseSucess(note);
    }

    @RequestMapping(value = "/freshNote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String freshNote(@RequestBody String param) throws Exception {
        String paramKey_pageSize = "pageSize";
        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        Pageable pageable = new PageRequest(0, UtileSmart.getIntFromMap(paramMap, paramKey_pageSize), Sort.Direction.DESC, "PutDate");

        Page<Note> notes = noteRepository.findAll(pageable);

        fileDepotService.getFilesByOwn(notes);

        return ResponseFormationJson.FormationResponseSucess(notes.getTotalElements(), notes.getContent());
    }

    @RequestMapping(value = "/readNote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String readNote(@RequestBody String param) throws Exception {
        String paramKey_noteId = "noteId";
        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        noteService.readNote(UtileSmart.getStringFromMap(paramMap, paramKey_noteId));

        return ResponseFormationJson.FormationResponseSucess();
    }

    @RequestMapping(value = "/laudNote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String laudNote(@RequestBody String param) throws Exception {
        String paramKey_noteId = "noteId";
        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        noteService.laudNote(UtileSmart.getStringFromMap(paramMap, paramKey_noteId));

        return ResponseFormationJson.FormationResponseSucess();
    }
}
