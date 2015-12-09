/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controllerExterior;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Accountissue;
import com.smart.smartspay.entity.Advice;
import com.smart.smartspay.entity.Bankissue;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.repository.AccountIssueRepository;
import com.smart.smartspay.repository.BankIssueRepository;
import com.smart.smartspay.util.ResponseFormationJson;
import com.smart.smartspay.util.ResponseResultCode;
import com.smart.smartspay.util.bank.BankCardBin;
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
@RequestMapping("/DealBasis")
public class DealBasisContorller {

    @Resource
    AccountIssueRepository accountIssueRepository;

    @Resource
    BankIssueRepository bankIssueRepository;

    @RequestMapping(value = "/getAccountIssue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAccountIssue(@RequestBody String param) throws Exception {
        List<Accountissue> accountIssues = accountIssueRepository.findAll();

        return ResponseFormationJson.FormationResponseSucess(accountIssues);

    }

    @RequestMapping(value = "/checkAccountIssue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String checkAccountIssue(@RequestBody String param) throws Exception {
        String paramKey_accountNum = "accountNum";

        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        String accountNum = UtileSmart.getStringFromMap(paramMap, paramKey_accountNum);

        int checkResult = BankCardBin.checkBankCard(accountNum);

        if (checkResult == 1) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorAccountLength, "accountNum length.");
        } else if (checkResult == 2) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorAccountLength, "accountNum pattern.");
        }
        Bankissue bankIssue = bankIssueRepository.findOne(accountNum.substring(0, 6));

        if (bankIssue == null || bankIssue.getBankBin() == null) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorAccountIssueUnSupport, "account issue unsupport.bankIssue not found.");
        }
        Accountissue accountIssue = accountIssueRepository.findByBankIssueNum(bankIssue.getBankIssueNum());
        if (accountIssue == null) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorAccountIssueUnSupport, "account issue unsupport. accountIssue not found.");
        }
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("accountIssue", accountIssue);
        results.put("bankIssue", bankIssue);
        return ResponseFormationJson.FormationResponseSucess(results);

    }

}
