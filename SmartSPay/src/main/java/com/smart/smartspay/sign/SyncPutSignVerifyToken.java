/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.sign;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class SyncPutSignVerifyToken implements Runnable {

    SignInformationModel signModel;

    public SyncPutSignVerifyToken(SignInformationModel model) {
        this.signModel = model;
    }

    @Override
    public void run() {
        synchronized (SignCommon.SignRecords) {
            for (SignInformationModel SignRecord : SignCommon.SignRecords) {
                if (SignRecord.getToken().equals(signModel.getToken())) {
                    SignRecord.setSignDateTime(new Date().getTime());
                    return;
                }
            }
            SignCommon.SignRecords.add(signModel);
        }
    }

}
