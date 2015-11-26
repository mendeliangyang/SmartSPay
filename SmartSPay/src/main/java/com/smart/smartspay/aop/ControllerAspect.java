/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.aop;

import com.smart.smartspay.util.SmartLog4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import net.sf.json.JSONObject;

/**
 *
 * @author Administrator
 */
@Aspect
public class ControllerAspect {

    @Around(value = "execution(* com.smart.smartspay.controller.*.*(..))")
    public Object aroundImpl(ProceedingJoinPoint joinPoint) throws Throwable {

//         Object[] args = joinPoint.getArgs();
//            System.out.println(args.toString() + joinPoint.toString());
//            //log
//            Object resultObject = joinPoint.proceed(joinPoint.getArgs());
//
//            return resultObject;
        Object[] args = null;
        StringBuffer argsBuffer = new StringBuffer();
        try {
            //  log
            args = joinPoint.getArgs();

            for (int i = 0; i < args.length; i++) {
                argsBuffer.append(String.format("param%d : %s", i, args[i].toString()));
            }
            SmartLog4j.LogInfo(String.format("method : %s  ,params : %s", joinPoint.getSignature().toLongString(), argsBuffer.toString()));
            //log
            Object resultObject = joinPoint.proceed(joinPoint.getArgs());

            return resultObject;
        } catch (Exception e) {
            SmartLog4j.ErrorLogInfo(String.format("method : %s  ,params : %s", joinPoint.getSignature().toLongString(), argsBuffer.toString()), e);
            JSONObject jsonobject = new JSONObject();
            jsonobject.accumulate("retCode", "9999");
            jsonobject.accumulate("retMsg", e.getLocalizedMessage());
            return jsonobject.toString();
//            throw e;
        } finally {
            //log

//        SmartLog4j.LogInfo(param);
        }

    }
}
