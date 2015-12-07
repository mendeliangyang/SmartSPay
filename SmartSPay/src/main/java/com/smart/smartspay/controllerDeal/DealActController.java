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
import com.smart.smartspay.repository.MyaccountRepository;
import com.smart.smartspay.service.DealActService;
import com.smart.smartspay.sign.SignCommon;
import com.smart.smartspay.sign.SignInformationModel;
import com.smart.smartspay.util.ResponseFormationJson;
import java.util.Date;
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
@RequestMapping("/DealAct")
public class DealActController {

    @Resource
    DealActService dealActService;

    @Resource
    MyaccountRepository myaccountRepository;

    @RequestMapping(value = "/putMyAccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String putMyAccount(@RequestBody String param, Map<String, Object> paramMap, SignInformationModel signModel) throws Exception {

        String paramKey_accountNum = "accountNum";
        String paramKey_accountIssue = "accountIssue";
        String paramKey_masterRealName = "masterRealName";
        String paramKey_masterVerifyPhone = "masterVerifyPhone";

        Date operationDate = new Date();
        //build private account
        Myaccount myaccount = new Myaccount();
        myaccount.setAccountId(UtileSmart.getUUID());
        myaccount.setPutTime(operationDate);
        myaccount.setUserId(signModel.getUserId());
        //todo invoke other method verfiy accountNum correct
        myaccount.setAccountNum(UtileSmart.getStringFromMap(paramMap, paramKey_accountNum));
        myaccount.setAccountIssue(UtileSmart.getStringFromMap(paramMap, paramKey_accountIssue));
        myaccount.setValidStatus(1);
        myaccount.setOperationTime(operationDate);
        String masterRealName = UtileSmart.tryGetStringFromMap(paramMap, paramKey_masterRealName);
        if (masterRealName != null && !masterRealName.isEmpty()) {
            myaccount.setMasterRealName(masterRealName);
        }
        String masterVerifyPhone = UtileSmart.tryGetStringFromMap(paramMap, paramKey_masterVerifyPhone);
        if (masterVerifyPhone != null && !masterVerifyPhone.isEmpty()) {
            myaccount.setMasterVerifyPhone(masterVerifyPhone);
        }
        dealActService.putPrivateAccount(myaccount);

        return ResponseFormationJson.FormationResponseSucess(myaccount);

    }

    @RequestMapping(value = "/getMyAccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getMyAccount(@RequestBody String param, Map<String, Object> paramMap, SignInformationModel signModel) throws Exception {
        String userId = signModel.getUserId();
        List<Myaccount> myaccounts = myaccountRepository.findByUserId(userId);
        return ResponseFormationJson.FormationResponseSucess(myaccounts);

    }

    @RequestMapping(value = "/invalidMyAccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String invalidMyAccount(@RequestBody String param, Map<String, Object> paramMap, SignInformationModel signModel) throws Exception {
        String paramKey_accountId = "accountId";
        dealActService.invalidPrivateAccount(UtileSmart.getStringFromMap(paramMap, paramKey_accountId));
        return ResponseFormationJson.FormationResponseSucess();
    }

}
