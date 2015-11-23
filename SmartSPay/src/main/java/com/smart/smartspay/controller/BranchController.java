/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Branch;
import com.smart.smartspay.repository.BranchRepository;
import com.smart.smartspay.util.ResponseFormationJson;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/Branch")
public class BranchController {

    @Resource
    BranchRepository branchRepository;

    @RequestMapping(value = "/getBranchByBranchUp", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getBranchByBranchUp(@RequestBody String param) throws Exception {
        String paramKey_branchUpId = "branchUpId";

        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        List<Branch> branchs = branchRepository.findByBranchUpId(UtileSmart.getStringFromMap(paramMap, paramKey_branchUpId));

        return ResponseFormationJson.FormationResponseSucess(branchs);
    }

    @RequestMapping(value = "/getBranchByNameContain", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getBranch(@RequestBody String param) throws Exception {
        String paramKey_branchName = "branchName";

        Map<String, Object> paramMap = null;

        paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        List<Branch> branchs = branchRepository.findByBranchNameContaining(UtileSmart.getStringFromMap(paramMap, paramKey_branchName));

        return ResponseFormationJson.FormationResponseSucess(branchs);
    }

}
