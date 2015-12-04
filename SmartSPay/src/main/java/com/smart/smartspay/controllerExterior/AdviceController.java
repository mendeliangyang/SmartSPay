/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controllerExterior;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Advice;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.repository.AdviceRepository;
import com.smart.smartspay.util.ResponseFormationJson;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
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
@RequestMapping("/Advice")
public class AdviceController {
    
    @Resource
    AdviceRepository adviceRepository;
    
    @RequestMapping(value = "/putAdvice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String putAdvice(@RequestBody String param) throws Exception {
        
        String paramKey_content = "content";
        String paramKey_userId = "userId";
        
        Map<String, Object> paramMap = new HashMap<String, Object>();
        
        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        
        Advice advice = new Advice();
        Userdetail userdetail = new Userdetail();
        userdetail.setUserId(UtileSmart.getStringFromMap(paramMap, paramKey_userId));
        advice.setContent(UtileSmart.getStringFromMap(paramMap, paramKey_content));
        advice.setUserId(userdetail);
        advice.setPutDate(new Date());
        advice.setAdviceId(UtileSmart.getUUID());
        adviceRepository.save(advice);
        
        return ResponseFormationJson.FormationResponseSucess(advice);
        
    }
}
