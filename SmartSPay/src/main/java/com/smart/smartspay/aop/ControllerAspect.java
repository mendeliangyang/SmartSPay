/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.aop;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.exception.SmartBaseException;
import com.smart.smartspay.sign.SignCommon;
import com.smart.smartspay.util.CommonParamKey;
import com.smart.smartspay.util.ResponseResultCode;
import com.smart.smartspay.util.SmartLog4j;
import java.util.HashMap;
import java.util.Map;
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
    public Object aroundLogImpl(ProceedingJoinPoint joinPoint) throws Throwable {
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

    @Around(value = "execution(* com.smart.smartspay.controllerDeal.*.*(..))")
    public Object aroundVerifyTokenImpl(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = null;
        StringBuffer argsBuffer = new StringBuffer();

        try {
            args = joinPoint.getArgs();

            for (int i = 0; i < args.length; i++) {
                argsBuffer.append(String.format("param-%d : %s", i, args[i].toString()));
            }

            SmartLog4j.LogInfo(String.format("method : %s  ,params : %s", joinPoint.getSignature().toLongString(), argsBuffer.toString()));

            //put token information to proceed
//            verfiyArgs = new Object[args.length];
//            System.arraycopy(args, 0, verfiyArgs, 0, 1);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            AnalyzeParam.AnalyzeParamToMap(args[0].toString(), paramMap);
            args[1] = paramMap;
            args[2] = SignCommon.verifySign(UtileSmart.getStringFromMap(paramMap, CommonParamKey.ParamKey_token), true);
            Object resultObject = joinPoint.proceed(args);
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
