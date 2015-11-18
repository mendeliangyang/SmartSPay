/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import java.io.File;

/**
 *
 * @author Administrator
 */
public class DeployConfigInfo {

    public DeployConfigInfo() {
    }

    private static String deployRootPath;

    public static String getDelplyRootPath() {
        if (deployRootPath == null || deployRootPath.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            String DeployRootPath = DeployConfigInfo.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            DeployRootPath = DeployRootPath.substring(1, DeployRootPath.indexOf("WEB-INF"));
            deployRootPath = sb.append(File.separator).append(DeployRootPath).toString();
            sb.delete(0, sb.length());
            deployLogPath = sb.append(deployRootPath).append("Log").toString();
            sb.delete(0, sb.length());
        }
        return deployRootPath;
    }

    private static String deployLogPath = null;

    public static String getDeployLogPath() throws Exception {
        if (deployLogPath == null || deployLogPath.isEmpty()) {
            getDelplyRootPath();
            //throw new Exception("have't load DeployLogPath.");
        }
        return deployLogPath;
    }
}
