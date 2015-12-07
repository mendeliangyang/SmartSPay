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
public class SignInformationModel {

    public SignInformationModel() {
    }

    public SignInformationModel(String pId, String pMac, String pDeviceType) {
        this.deviceType = pDeviceType;
        this.userId = pId;
        this.mac = pMac;
        this.signDateTime = new Date().getTime();
    }

    private String token; //encode mac ,deviceType,Id
    private String mac; //device mac address
    private String deviceType; //1 pc,2 andorid,3 ios
    private String userId;// sign user id
    private long signDateTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getSignDateTime() {
        return signDateTime;
    }

    public void setSignDateTime(long signDateTime) {
        this.signDateTime = signDateTime;
    }
    
    

    /**
     * 加密token id,mac,deviceType 合并计算
     *
     * @return
     */
    public String encodeToken() {
        //
        token = userId;
        return token;
    }

    /**
     * 解析token
     */
    public void decodeToken() {
        //

    }
}
