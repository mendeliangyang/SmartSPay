/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import java.io.File;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class SmartLog4j {

    private static Logger log4jErrLog = null;
    private static Logger log4jNormalLog = null;
    private static Logger log4jDeployLog = null;
    private static Logger log4jWSErrLog = null;

    public static void initializeLog4j() throws Exception {
        //读取配置文件
        System.setProperty("log4jdir", String.format("%s", DeployConfigInfo.getDeployLogPath()));
        org.apache.log4j.PropertyConfigurator.configure(String.format("%s%s%s%s", DeployConfigInfo.getDelplyRootPath(), "WEB-INF",File.separator,"log4j.properties"));

        log4jErrLog = Logger.getLogger("errorLog");
        log4jNormalLog = Logger.getLogger("normalLog");
        log4jDeployLog = Logger.getLogger("deployLog");
        log4jWSErrLog = Logger.getLogger("errorLog");

    }
    
    
    
    
    
    public static void LogInfo(String logMsg) {
        SmartLog4j.NormalLog(logMsg);
    }

    /**
     * 错误日志记录
     *
     * @param logMsg 错误信息
     */
    public static void ErrorLogInfo(String logMsg) {
        SmartLog4j.ErrorLog(logMsg);
    }

    /**
     * 错误日志记录
     *
     * @param strExecute string参数
     * @param exception 异常信息
     */
    public static void ErrorLogInfo(String strExecute, Exception exception) {
        StringBuffer sbLog = new StringBuffer();
        sbLog.append("strParam:").append(strExecute);
        if (exception != null) {
            StackTraceElement[] trace = exception.getStackTrace();
            for (StackTraceElement tempTrace : trace) {
                sbLog.append("\r\n").append(tempTrace);
            }
        }
        SmartLog4j.ErrorLog(sbLog.toString());
        sbLog.delete(0, sbLog.length());
        sbLog = null;
    }

    /**
     * websocket 错误日志
     *
     * @param logMsg
     */
    public static void wsErrorLogInfo(String logMsg) {
        SmartLog4j.WSErrorLog(logMsg);
    }

    /**
     * websocket 错误日志
     *
     * @param logMsg
     * @param exception
     */
    public static void wsErrorLogInfo(String logMsg, Exception exception) {
        StringBuffer sbLog = new StringBuffer();
        sbLog.append("errorMessage:").append(logMsg);
        if (exception != null) {
            StackTraceElement[] trace = exception.getStackTrace();
            for (StackTraceElement tempTrace : trace) {
                sbLog.append("\r\n").append(tempTrace);
            }
        }
        wsErrorLogInfo(sbLog.toString());
        sbLog.delete(0, sbLog.length());
        sbLog = null;
    }

    private static void SetUpLogInfo(String logMsg) {
        SmartLog4j.DeployLog(logMsg);
    }

    private static void WSErrorLog(String logMsg) {
        log4jWSErrLog.error(logMsg);
    }

    private static void ErrorLog(String logMsg) {
        log4jErrLog.error(logMsg);
    }

    private static void NormalLog(String logMsg) {
        log4jNormalLog.info(logMsg);
    }

    private static void DeployLog(String logMsg) {
        log4jDeployLog.info(logMsg);
    }
}
