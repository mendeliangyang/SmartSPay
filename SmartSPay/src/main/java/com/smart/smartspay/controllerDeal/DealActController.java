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
import com.smart.smartspay.util.alipay.config.AlipayConfig;
import com.smart.smartspay.util.alipay.util.AlipaySubmit;
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
        
        myaccount = myaccountRepository.findOne(myaccount.getAccountId());
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

    @RequestMapping(value = "/actAccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String actAccount(@RequestBody String param, Map<String, Object> paramMap, SignInformationModel signModel) throws Exception {
        String paramKey_toAccountId = "toAccountId";
        String paramKey_fromAccountId = "fromAccountId";
        String paramKey_total = "total";

        //调用不同的接口实现充值
        //dealActService.invalidPrivateAccount(UtileSmart.getStringFromMap(paramMap, paramKey_accountId));
        return ResponseFormationJson.FormationResponseSucess();
    }

    /**
     * generate act no
     */
    private void generateActNo() {
        UtileSmart.getCurrentDate("yyyyMMddHHmmss");
    }

    private void actAlipay(String actNo, String actName, Double actMoney, String actDescribe) {
        //支付类型
        String payment_type = "1";
        //必填，不能修改
        //服务器异步通知页面路径
        String notify_url = "http://商户网关地址/create_direct_pay_by_user-JAVA-UTF-8/notify_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

        //页面跳转同步通知页面路径
        String return_url = "http://商户网关地址/create_direct_pay_by_user-JAVA-UTF-8/return_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

        //商户订单号
        String out_trade_no = actNo;
		//商户网站订单系统中唯一订单号，必填

        //订单名称
        String subject = actName;
		//必填

        //付款金额
        String total_fee = actMoney.toString();
		//必填

        //订单描述
        String body = actDescribe;
        //商品展示地址
        String show_url = "http://show_product/actDescribe.html";
		//需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

        //防钓鱼时间戳
        String anti_phishing_key = "";
		//若要使用请调用类文件submit中的query_timestamp函数

        //客户端的IP地址
        String exter_invoke_ip = "";
        //非局域网的外网IP地址，如：221.0.0.1

        //把请求参数打包成数组
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp.put("payment_type", payment_type);
        sParaTemp.put("notify_url", notify_url);
        sParaTemp.put("return_url", return_url);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", total_fee);
        sParaTemp.put("body", body);
        sParaTemp.put("show_url", show_url);
        sParaTemp.put("anti_phishing_key", anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);

        //建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");

//                out.println(sHtmlText);
    }

}
