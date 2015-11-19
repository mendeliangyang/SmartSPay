/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import net.sf.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class ResponseFormationJson {

    private final static String retCode_Key = "retCode";
    private final static String retMsg_Key = "retMsg";
    private final static String retContext_Key = "Context";

    public static String getRetCode_Key() {
        return retCode_Key;
    }

    public static String FormationResponseSucess(JSONObject jsonObject) {
        return FormationResponse(ResponseResultCode.Success, "", jsonObject);
    }

    public static String FormationResponse(ResponseResultCode code, String retMsg, JSONObject retContext) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate(retCode_Key, code.toString());
        jsonObject.accumulate(retMsg_Key, retMsg);
        jsonObject.accumulate(retContext_Key, retContext);
        return jsonObject.toString();
    }

}
