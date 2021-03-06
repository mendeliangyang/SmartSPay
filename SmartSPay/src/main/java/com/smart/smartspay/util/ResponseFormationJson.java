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
import com.smart.smartspay.entity.SmartReponseFormation;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

/**
 *
 * @author Administrator
 */
public class ResponseFormationJson {

    private final static String retCode_Key = "retCode";
    private final static String retMsg_Key = "retMsg";
    private final static String retContext_Key = "context";

    public static String getRetCode_Key() {
        return retCode_Key;
    }

    public static String FormationResponseSucess() {
        return FormationResponse(ResponseResultCode.Success, "", null);
    }

    public static <T extends SmartReponseFormation> String FormationResponseSucess(T jsonObject) {
        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild().toJsonTree(jsonObject));
    }

    public static <T extends SmartReponseFormation> String FormationResponseSucess(List<T> jsonObject) {
        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild().toJsonTree(jsonObject));
    }

//    public static <T extends SmartReponseFormation> String FormationResponseSucess(Iterator<T> jsonObject) {
//        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild().toJsonTree(jsonObject));
//    }

    public static String FormationResponseSucess(Map<String, Object> objects) {
        JsonObject jsonObject = new JsonObject();
        for (String keySet : objects.keySet()) {
            jsonObject.add(keySet, GsonUtilSmart.GsonBuild().toJsonTree(objects.get(keySet)));
        }
        return FormationResponse(ResponseResultCode.Success, "", jsonObject);
    }

    public static <T> String FormationResponseSucess(T jsonObject, ExclusionStrategy exclude) {

        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild(exclude).toJsonTree(jsonObject));
    }

    public static <T> String FormationResponseSucess(Page<T> context) {
        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild().toJsonTree(new PageJson(context.getTotalElements(), context.getContent())));
    }

    public static <T> String FormationResponseSucess(Page<T> context, ExclusionStrategy exclude) {
        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild(exclude).toJsonTree(new PageJson(context.getTotalElements(), context.getContent())));
    }

//    public static <T> String FormationResponseSucess(long total, List<T> jsonObject, ExclusionStrategy exclude) {
//        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild(exclude).toJsonTree(new PageJson(total, jsonObject)));
//    }
//
//    public static String FormationResponseSucess(long total, List<?> jsonObject) {
//        return FormationResponse(ResponseResultCode.Success, "", GsonUtilSmart.GsonBuild().toJsonTree(new PageJson(total, jsonObject)));
//    }
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
