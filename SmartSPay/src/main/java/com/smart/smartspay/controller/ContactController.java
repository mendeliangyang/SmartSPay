/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartscommon.util.gsonsmart.SmartExclusionStrategy;
import com.smart.smartspay.entity.Branch;
import com.smart.smartspay.entity.Contact;
import com.smart.smartspay.repository.ContactRepository;
import com.smart.smartspay.util.CommonParamKey;
import com.smart.smartspay.util.ResponseFormationJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/Contact")
public class ContactController {

    @Resource
    ContactRepository contactRepository;

    @RequestMapping(value = "/getContactByBranch", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getContactByBranch(@RequestBody String param) throws Exception {
        String paramKey_branchUpId = "branchId";
        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        Branch branch = new Branch();
        branch.setBranchId(UtileSmart.getStringFromMap(paramMap, paramKey_branchUpId));

        Page<Contact> contacts = contactRepository.findByBranchId(branch, new PageRequest(UtileSmart.getIntFromMap(paramMap, CommonParamKey.ParamKey_PageIndex), UtileSmart.getIntFromMap(paramMap, CommonParamKey.ParamKey_PageSize)));

        Map<Class<?>, String[]> exclude = new HashMap<Class<?>, String[]>();
        exclude.put(Branch.class, new String[]{"branchId"});
        return ResponseFormationJson.FormationResponseSucess(contacts, new SmartExclusionStrategy(exclude));
    }

    @RequestMapping(value = "/getContactByNameContain", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getContactByNameContain(@RequestBody String param) throws Exception {
        String paramKey_contactName = "contactName";

        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        Page<Contact> contacts = contactRepository.findByContactNameContaining(UtileSmart.getStringFromMap(paramMap, paramKey_contactName), new PageRequest(UtileSmart.getIntFromMap(paramMap, CommonParamKey.ParamKey_PageIndex), UtileSmart.getIntFromMap(paramMap, CommonParamKey.ParamKey_PageSize)));

        Map<Class<?>, String[]> exclude = new HashMap<Class<?>, String[]>();
        exclude.put(Branch.class, new String[]{"branchId"});
        return ResponseFormationJson.FormationResponseSucess(contacts, new SmartExclusionStrategy(exclude));
    }

}
