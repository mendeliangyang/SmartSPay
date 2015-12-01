/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controllerExterior;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartspay.entity.Version;
import com.smart.smartspay.repository.VersionRepository;
import com.smart.smartspay.util.ResponseFormationJson;
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
@RequestMapping("/Version")
public class VersionController {
    
    @Resource
    VersionRepository versionRepository;

    @RequestMapping(value = "/getVersion", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getVersion(@RequestBody String param) throws Exception {

        Version version= versionRepository.findTopByOrderByPutDateDesc();
        
        return ResponseFormationJson.FormationResponseSucess(version);

    }
}
