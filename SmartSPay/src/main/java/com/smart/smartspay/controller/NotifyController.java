/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.CommonAnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Notify;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.repository.NotifyRepository;
import com.smart.smartspay.util.DateJsonValueProcessor;
import com.smart.smartspay.util.ResponseFormationJson;
import com.smart.smartspay.util.ResponseResultCode;
import com.smart.smartspay.util.SmartLog4j;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JsonConfig;
import com.google.gson.Gson;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/Notify")
public class NotifyController {

    @Resource
    private NotifyRepository notifyRepository;

    @RequestMapping(value = "/getNotify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getNotify(@RequestBody String param) throws Exception {
        String paramKey_notifyId = "notifyId";
        String paramKey_pageIndex = "pageIndex";
        String paramKey_pageSize = "pageSize";
        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        String firstNotifyId = UtileSmart.getStringFromMap(paramMap, paramKey_notifyId);

        Notify notify = notifyRepository.findOne(firstNotifyId);
        if (notify == null) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorNotFound, String.format("notifyId:'%s' don't exist", firstNotifyId), null);
        }
        Pageable pageable = new PageRequest(UtileSmart.getIntFromMap(paramMap, paramKey_pageIndex), UtileSmart.getIntFromMap(paramMap, paramKey_pageSize), Direction.DESC, "PutDate");

        Page<Notify> notifys = notifyRepository.findByPutDateBefore(notify.getPutDate(), pageable);

//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
//        JSONObject jsonObject = JSONObject.fromObject(notifys, jsonConfig);
        return ResponseFormationJson.FormationResponseSucess(notifys);
    }

    @RequestMapping(value = "/freshNotify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String freshNotify(@RequestBody String param) throws Exception {
        String paramKey_pageSize = "pageSize";
        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        Pageable pageable = new PageRequest(0, UtileSmart.getIntFromMap(paramMap, paramKey_pageSize), Direction.DESC, "PutDate");

        Page<Notify> notifys = notifyRepository.findAll(pageable);

//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
//        JSONObject jsonObject = JSONObject.fromObject(notifys, jsonConfig);
        return ResponseFormationJson.FormationResponseSucess(notifys);
    }
}
