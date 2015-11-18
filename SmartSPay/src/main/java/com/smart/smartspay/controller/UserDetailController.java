/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartspay.entity.UserDetailEntity;
import com.smart.smartspay.repository.UserDetailRepository;
import com.smart.smartspay.util.SmartLog4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/UserDeatilController")
public class UserDetailController {

//    @Autowired
    @Resource
    private UserDetailRepository userDetailRepository;
    
    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test(@RequestBody String param) throws Exception {
        //analyzeParamJackson.transferReviveRSParamModel(param, OperateTypeEnum.update);
        SmartLog4j.LogInfo(param);
        UserDetailEntity userEntity = new UserDetailEntity();
        userEntity.setUserName("abcd");
        userDetailRepository.save(userEntity);
        return "tead阿达t";
    }
}
