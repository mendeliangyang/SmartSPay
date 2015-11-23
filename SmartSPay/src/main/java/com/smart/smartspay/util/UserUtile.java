/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import com.smart.smartscommon.util.MD5Util;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Administrator
 */
public class UserUtile {

    public static String UserPasswordMD5Convert(String source) throws NoSuchAlgorithmException {
        return MD5Util.MD5(source);
    }

}
