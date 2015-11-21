/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.smart.smartscommon.util.gsonsmart.GsonUtilSmart;

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

    public static String FormationResponseSucess(Object jsonObject) {
        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild().toJsonTree(jsonObject));
    }

    public static String FormationResponseSucess(Object jsonObject, ExclusionStrategy exclude) {
        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild(exclude).toJsonTree(jsonObject));
    }

    public static String FormationResponse(ResponseResultCode code, String retMsg) {
        return FormationResponse(code, retMsg, null);
    }

    public static String FormationResponse(ResponseResultCode code, Exception exception) {
        return FormationResponse(code, exception.getLocalizedMessage(), null);
    }

    public static String FormationResponse(ResponseResultCode code, String retMsg, JsonElement retContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(retCode_Key, code.toString());
        jsonObject.addProperty(retMsg_Key, retMsg);
        jsonObject.add(retContext_Key, retContext);
        return jsonObject.toString();
    }

}
