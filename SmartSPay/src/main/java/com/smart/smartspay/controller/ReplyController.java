/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Reply;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.repository.ReplyRepository;
import com.smart.smartspay.service.FileDepotService;
import com.smart.smartspay.util.ResponseFormationJson;
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
@RequestMapping("/Reply")
public class ReplyController {
    
    @Resource
    ReplyRepository replyRespository;
    
    @Resource
    FileDepotService fileDepotService;
    
    @RequestMapping(value = "/getNoteReply", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String freshNotify(@RequestBody String param) throws Exception {
        String paramKey_masterId = "masterId";
        String paramKey_pageIndex = "pageIndex";
        String paramKey_pageSize = "pageSize";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        
        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        
        Page<Reply> replys = replyRespository.findByMasterId(UtileSmart.getStringFromMap(paramMap, paramKey_masterId), new PageRequest(UtileSmart.getIntFromMap(paramMap, paramKey_pageIndex), UtileSmart.getIntFromMap(paramMap, paramKey_pageSize), Sort.Direction.DESC, "PutDate"));
        
        fileDepotService.getFilesByOwn(replys);
        
        for (Reply reply : replys) {
            reply.getUserId().setFileDetail(fileDepotService.getFilesByOwnId(reply.getUserId().getFileOwnId()));
        }
        return ResponseFormationJson.FormationResponseSucess(replys);
    }
    
    @RequestMapping(value = "/putReply", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String putReply(@RequestBody String param) throws Exception {
        String paramKey_userId = "userId";
        String paramKey_masterId = "masterId";
        String paramKey_replyType = "replyType";
        String paramKey_linkReplyId = "linkReplyId";
        String paramKey_replyContent = "content";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        
        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        Reply reply = new Reply();
        reply.setConntext(UtileSmart.getStringFromMap(paramMap, paramKey_replyContent));
        reply.setLinkReplyId(UtileSmart.tryGetStringFromMap(paramMap, paramKey_linkReplyId));
        reply.setMasterId(UtileSmart.getStringFromMap(paramMap, paramKey_masterId));
        reply.setPutDate(new Date());
        reply.setReplyType(UtileSmart.getIntFromMap(paramMap, paramKey_replyType));
        
        Userdetail userdetail = new Userdetail();
        userdetail.setUserId(UtileSmart.getStringFromMap(paramMap, paramKey_userId));
        reply.setUserId(userdetail);
        replyRespository.save(reply);
        return ResponseFormationJson.FormationResponseSucess(reply);
    }
}
