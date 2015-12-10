/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util.alipay.util;

import com.smart.smartspay.util.alipay.config.AlipayConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author Administrator
 */
public class AlipayDealProxy {

    private void actAlipay(String actNo, String actName, String actMoney, String actDescribe) {
        //防钓鱼时间戳
        String anti_phishing_key = "";
        //若要使用请调用类文件submit中的query_timestamp函数
        //客户端的IP地址
        String exter_invoke_ip = "";
        //把请求参数打包成数组
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        //支付类型 默认1
        sParaTemp.put("payment_type", "1");
        //服务器异步通知页面路径
        sParaTemp.put("notify_url", "http://220.231.153.66:8007/SmartSPay/pages/notfiyAlipay.jsp");
        //页面跳转同步通知页面路径
        sParaTemp.put("return_url", "http://220.231.153.66:8007/SmartSPay/pages/returnAlipay.jsp");
        //商户订单号
        sParaTemp.put("out_trade_no", actNo);
        //订单名称
        sParaTemp.put("subject", actName);
        //付款金额
        sParaTemp.put("total_fee", actMoney);
        //订单描述
        sParaTemp.put("body", actDescribe);
        //商品展示地址
        sParaTemp.put("show_url", "http://220.231.153.66:8007/SmartSPay/pages/ActDescribe.html");
        sParaTemp.put("anti_phishing_key", anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);

        //建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
        Map<String, String> paramMap = AlipaySubmit.buildRequestPara(sParaTemp);
        getMethodAlipay(paramMap);
    }

    private void getMethodAlipay(Map<String, String> paramMap) {
        HttpClient httpClient = new HttpClient();

        PostMethod postMethod = new PostMethod(AlipaySubmit.ALIPAY_GATEWAY_CHARSET);
        for (String keySet : paramMap.keySet()) {
            postMethod.addParameter(keySet, paramMap.get(keySet));
        }
        try {
            httpClient.executeMethod(postMethod);
            postMethod.getStatusCode();
            String resp = postMethod.getResponseBodyAsString();
            System.out.println(resp);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
