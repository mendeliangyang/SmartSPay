/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.servlet;

import com.smart.smartspay.sign.SignCommon;
import com.smart.smartspay.util.DeployConfigInfo;
import com.smart.smartspay.util.SmartLog4j;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Administrator
 */
public class StartOptionConfig extends HttpServlet {

    public StartOptionConfig() throws Exception {
        //
        SmartLog4j.initializeLog4j();
        
        SignCommon.initialSignVerify();
    }

}
