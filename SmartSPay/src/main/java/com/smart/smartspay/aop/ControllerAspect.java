/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.aop;

import com.smart.smartspay.exception.SmartBaseException;
import com.smart.smartspay.util.ResponseResultCode;
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
        Object[] args = null;
        StringBuffer argsBuffer = new StringBuffer();
        try {
            args = joinPoint.getArgs();

            for (int i = 0; i < args.length; i++) {
                argsBuffer.append(String.format("param-%d : %s", i, args[i].toString()));
            }

            SmartLog4j.LogInfo(String.format("method : %s  ,params : %s", joinPoint.getSignature().toLongString(), argsBuffer.toString()));
            Object resultObject = joinPoint.proceed(joinPoint.getArgs());
            return resultObject;
        } catch (Exception e) {
            SmartLog4j.ErrorLogInfo(String.format("method : %s  ,params : %s", joinPoint.getSignature().toLongString(), argsBuffer.toString()), e);
            JSONObject jsonobject = new JSONObject();
            SmartBaseException sbe = null;
            if (e instanceof SmartBaseException) {
                sbe = (SmartBaseException) e;
            }
            jsonobject.accumulate("retCode", sbe == null ? ResponseResultCode.Error.toString() : sbe.getResultCode().toString());
            jsonobject.accumulate("retMsg", e.getLocalizedMessage());
            return jsonobject.toString();
        }
    }
}
