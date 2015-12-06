/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controllerDeal;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Ledger;
import com.smart.smartspay.entity.Myaccount;
import com.smart.smartspay.util.ResponseFormationJson;
import java.util.Date;
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
@RequestMapping("/Deal")
public class UtilController {

    /**
     * put privateAccount and put Account to ledger
     * @param param
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/putMyAccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String  putMyAccount(@RequestBody String param) throws Exception {
        //
        String paramKey_accountNum = "accountNum";
        String paramKey_accountIssue = "accountIssue";
        String paramKey_masterRealName = "masterRealName";
        String paramKey_masterVerifyPhone="masterVerifyPhone";
        
        //item ,accountIssue
        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        
        Date operationDate = new Date();
        //build private account
        Myaccount myaccount = new Myaccount();
        myaccount.setAccountId(UtileSmart.getUUID());
        myaccount.setPutTime(operationDate);
        myaccount.setUserId(param);
        //todo invoke other method verfiy accountNum correct
        myaccount.setAccountNum(UtileSmart.getStringFromMap(paramMap, paramKey_accountNum));
        String masterRealName = UtileSmart.tryGetStringFromMap(paramMap, paramKey_masterRealName);
        if (masterRealName!=null&&!masterRealName.isEmpty()) {
            myaccount.setMasterRealName(masterRealName);
        }
        String masterVerifyPhone = UtileSmart.tryGetStringFromMap(paramMap, paramKey_masterVerifyPhone);
        if (masterVerifyPhone!=null&&!masterVerifyPhone.isEmpty()) {
            myaccount.setMasterVerifyPhone(masterVerifyPhone);
        }
        
        //build ledger
        Ledger ledger = new Ledger();
        
        
        
        
        
        return ResponseFormationJson.FormationResponseSucess();

    }

}
