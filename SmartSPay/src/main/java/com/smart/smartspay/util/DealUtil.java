/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import com.smart.smartscommon.util.UtileSmart;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class DealUtil {

    final static Random random = new Random();

    public static String generateActNo() {
        return String.format("%s%06d", UtileSmart.getCurrentDate("yyyyMMddHHmmss"), random.nextInt(999999));
    }
}
