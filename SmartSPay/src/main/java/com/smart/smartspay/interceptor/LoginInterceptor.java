/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest hsr, javax.servlet.http.HttpServletResponse hsr1, Object o) throws Exception {
        //hsr.getInputStream();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        ReviveRSParamModel paramModel = mapper.readValue(hsr.getInputStream(), ReviveRSParamModel.class);

        System.out.println(hsr.getParameterMap().toString());
        
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest hsr, javax.servlet.http.HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("post");
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest hsr, javax.servlet.http.HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("after");
    }

}
