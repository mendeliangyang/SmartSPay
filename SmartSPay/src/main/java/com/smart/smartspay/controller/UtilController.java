/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartscommon.util.gsonsmart.SmartExclusionStrategy;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.util.ResponseFormationJson;
import java.util.HashMap;
import java.util.Map;
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
@RequestMapping("/Util")
public class UtilController {

    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getRegisterVerifyCode(@RequestBody String param) throws Exception {

        String paramKey_verfiyPhone = "verifyPhone";

        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        //todo invoke message platform.
        
        return ResponseFormationJson.FormationResponseSucess();

    }

}
