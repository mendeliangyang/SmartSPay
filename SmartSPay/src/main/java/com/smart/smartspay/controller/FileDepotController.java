/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.FileHelper;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartspay.entity.Filedepot;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.model.DepotFileDetailModel;
import com.smart.smartspay.model.FileDepotParamModel;
import com.smart.smartspay.repository.FileDepotRepository;
import com.smart.smartspay.service.FileDepotService;
import com.smart.smartspay.task.WebSiteConfig;
import com.smart.smartspay.util.DateJsonValueProcessor;
import com.smart.smartspay.util.DeployConfigInfo;
import com.smart.smartspay.util.ResponseFormationJson;
import com.smart.smartspay.util.ResponseResultCode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Resource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/FileDepot")
public class FileDepotController {

    @Resource
    FileDepotRepository fileDepotRepository;

    @Resource
    FileDepotService fileDepotService;

    @Resource
    WebSiteConfig webSiteConfig;

    /**
     * 上传文件到服务器
     *
     * @param strParam
     * @param uploadFiles
     * @return
     *///consumes = {org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE},
    @RequestMapping(value = "/UpLoadFileParam", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String UpLoadFileParam(@RequestParam("param") String strParam, @RequestParam("file") List< MultipartFile> uploadFiles) {
        FileDepotParamModel paramModel = null;
        try {
            paramModel = analyzeUpLoadFileJsonStr(strParam);
            System.out.println(uploadFiles.toString());
            return SaveUpLoadFile(uploadFiles, paramModel);
        } catch (Exception ex) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.Error, ex.getLocalizedMessage());//responseFormat.formationResultToString(ResponseResultCode.Error, ex);
        }

    }

//    @RequestMapping(value = "/UpBase64File", method = RequestMethod.POST, consumes = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}, produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public String UpBase64File(@RequestParam("param") String param) {
//        String strUpFileName = null, strSvcFileLocalName = null;
//        StringBuffer sbFilePathTemp = new StringBuffer(), sbTemp = new StringBuffer();
//        boolean bSvcFileExist;
//        List<String> strSqls = new ArrayList<String>();
//        int saveFlag = 1;
//        FileDepotParamModel paramModel = null;
//        try {
//            //解析参数
//            paramModel = analyzeBase64Param(param);
//
//            if (paramModel == null) {
//                return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorParam, "paramError");
//            }
//
////            SignInformationModel signModel = SignCommon.verifySign(paramModel.getToken(), false);
////            if (signModel == null) {
////                return responseFormat.formationResultToString(ResponseResultCode.ErrorSignToken, "no authorize");
////            }
//
//            if (paramModel.fileDetaile == null || paramModel.fileDetaile.isEmpty()) {
//                // return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam("base64串为空。", param));
//                return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorBase64Error, "base64串为空");
//            }
//
//            for (DepotFileDetailModel fileDetaile : paramModel.fileDetaile) {
//                //检查文件路径，和文件是否存在
//                strUpFileName = fileDetaile.fileName;
//                //组织路径  root/rsid/date(yymmddhh)/Type
//                //第一级目录
//                sbFilePathTemp.append(paramModel.rsid);
//                sbTemp.append(DeployInfo.GetDeployFilePath()).append(File.separator).append(paramModel.rsid);
//                FileHelper.CheckFileExist(sbTemp.toString());
//                //二级目录
//                sbFilePathTemp.append(File.separator).append(UtileSmart.getCurrentDate());
//                sbTemp.append(File.separator).append(UtileSmart.getCurrentDate());
//                FileHelper.CheckFileExist(sbTemp.toString());
//
//                sbFilePathTemp.append(File.separator).append(fileDetaile.fileOwnType);
//                sbTemp.append(File.separator).append(fileDetaile.fileOwnType);
//                FileHelper.CheckFileExist(sbTemp.toString());
//                //检查上次文件是否存在
//                sbFilePathTemp.append(File.separator).append(strUpFileName).toString();
//                strSvcFileLocalName = sbTemp.append(File.separator).append(strUpFileName).toString();
//                bSvcFileExist = FileHelper.CheckFileExist(strSvcFileLocalName, false);
//                if (bSvcFileExist) {
//
//                    return responseFormat.formationResultToString(ResponseResultCode.ErrorFileExist, "file exist can not change .please contact system manger");
////return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam("文件已经存在，不能修改。请联系管理员维护附件系统。", param));
//                }
//
//                //判断数据库是否存在 ownid 和 fpath重复的数据，如果有数据重复不能上传文件
//                resultParam = DBHelper.ExecuteSqlOnceSelect(DeployInfo.MasterRSID, String.format("SELECT COUNT(*) AS ROWSCOUNT FROM FILEDEPOT WHERE OWNID<>'%s' AND FPATH='%s'", paramModel.ownid, sbFilePathTemp.toString()));
//                if (resultParam.ResultCode != 0) {
//                    return responseFormat.formationResultToString(ResponseResultCode.ErrorDB, resultParam.errMsg);
//                    //return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam(String.format("检查数据库文件信息发送错误。%s", resultParam.errMsg), param));
//                }
//                //检查ROWSCOUNT 不为0可以继续操作 ROWSCOUNT 不等于0表示有其他文件关联该文件，要求客户修改文件名称，或者联系管理员维护服务器文件
//                if (resultParam.ResultJsonObject != null) {
//                    if (Integer.parseInt(resultParam.ResultJsonObject.getJSONObject(DeployInfo.ResultDataTag).getString("ROWSCOUNT")) > 0) {
//                        return responseFormat.formationResultToString(ResponseResultCode.ErrorFileRepeat, "file binded ");
//                        //return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam(String.format("‘%s’,该文件名已经存在并于与其他业务数据关联，请修改文件名称重新提交，或者联系管理员维护附件服务器。", strUpFileName), param));
//                    }
//                }
//                //判断如果类型应该是纯字符串，如果包含 文件路径分隔符(File.separator) 错误路径
//                if (fileDetaile.fileOwnType.indexOf(File.separator) > 0) {
//                    return responseFormat.formationResultToString(ResponseResultCode.ErrorFileType, "file type error. ");
//                    //return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam(String.format("文件类型错误，类型中不应该包含文件分隔符", strUpFileName), paramModel.toStringInformation()));
//                }
//                //调用解析图片方法，返回路径
//                int baseIndex = fileDetaile.fileBase64Value.indexOf(";base64,");
//                if (!FileHelper.ConvertBase64ToImage(fileDetaile.fileBase64Value.substring(baseIndex + 8, fileDetaile.fileBase64Value.length()), strSvcFileLocalName)) {
//                    return responseFormat.formationResultToString(ResponseResultCode.ErrorBase64ConvertFile, String.format("%s: convert image failed", fileDetaile.fileName));
//                    //return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam(String.format("%s: convert image failed", fileDetaile.fileName), param));
//                }
//                //本次文件保存成功，设置本地路径值，后续操作失败可以返回删除保存的文件
//                fileDetaile.fileLocalPath = strSvcFileLocalName;
//
//                if (fileDetaile.fileId != null && !fileDetaile.fileId.isEmpty()) {
//
//                    strSqls.add(String.format("insert into FILEDEPOT_LS (FID,FNAME,FPATH,FSUMMARY,OWNID,OWNFILETYPE,UPLOADDATE) select  FID,FNAME,FPATH,FSUMMARY,OWNID,OWNFILETYPE,UPLOADDATE from FILEDEPOT  as t_f where t_f.OWNID='%s'  and t_f.FID ='%s' ", paramModel.ownid, fileDetaile.fileId));
//
//                    //生成sql语句，待文件全部上传成功，保存到数据库
//                    strSqls.add(String.format(
//                            "update FILEDEPOT set FNAME='%s',FPATH='%s',OWNFILETYPE='%s',UPLOADDATE=getdate()  where FID='%s' and OWNID='%s'",
//                            strUpFileName, sbFilePathTemp.toString(), fileDetaile.fileOwnType, fileDetaile.fileId, paramModel.ownid));
//                } else {
//                    strSqls.add(String.format(
//                            "INSERT INTO FILEDEPOT (FID,FNAME,FPATH,FSUMMARY,OWNID,OWNFILETYPE) VALUES ('%s','%s','%s','%s','%s','%s')",
//                            UUID.randomUUID().toString(), strUpFileName, sbFilePathTemp.toString(), "md5", paramModel.ownid, fileDetaile.fileOwnType)
//                    );
//
//                }
//
//                sbTemp.delete(0, sbTemp.length());
//                sbFilePathTemp.delete(0, sbFilePathTemp.length());
//            }
//            //保存数据到数据库
//            resultParam = DBHelper.ExecuteSql(DeployInfo.MasterRSID, strSqls);
//            if (resultParam.ResultCode >= 0) {
//                saveFlag = 0;
//                //保存成功，将数据库信息返回
//                resultParam = SelectDepotFileByOwn(new FileDepotParamModel(paramModel.ownid));
//                // return formationResult.formationResult(ResponseResultCode.Success, new ExecuteResultParam(resultParam.ResultJsonObject));
//                return responseFormat.formationSuccessResultToString(resultParam.ResultJsonObject);
//            } else {
//                //TODO 如果操作数据库失败，需要把之前上传的文件全部在服务器上删除，负责会影响下次上传
//                return responseFormat.formationResultToString(ResponseResultCode.Error, resultParam.errMsg);
//            }
//        } catch (Exception e) {
//            return responseFormat.formationResultToString(ResponseResultCode.Error, e);
//        } finally {
//            if (saveFlag == 1 && paramModel != null) {
//                DeleteFile(paramModel.fileDetaile);
//            }
//            UtileSmart.FreeObjects(strUpFileName, strSvcFileLocalName, sbFilePathTemp, sbTemp, resultParam, strSqls, paramModel);
//        }
//
//    }
//    public FileDepotParamModel analyzeBase64Param(String strJson) throws Exception {
//        JSONObject jsonObj = null;
//        JSONObject jsonHead = null;
//        JSONObject jsonBody = null;
//        JSONArray arrayBase64 = null;
//        JSONObject jsonTempBase64 = null;
//        FileDepotParamModel paramModel = null;
//        DepotFileDetailModel tempDetailModel = null;
//        try {
//            jsonObj = JSONObject.fromObject(strJson);
//            paramModel = new FileDepotParamModel();
//            jsonHead = jsonObj.getJSONObject("head");
//            jsonBody = jsonObj.getJSONObject("body");
//
//            paramModel.rsid = jsonHead.getString(DeployInfo.paramRSIDKey);
//            paramModel.token = jsonHead.getString(DeployInfo.paramtokenKey);
//            paramModel.ownid = jsonBody.getString("ownid");
//            arrayBase64 = jsonBody.getJSONArray("base64");
//            paramModel.fileDetaile = new HashSet<DepotFileDetailModel>();
//            for (Object arrayBase641 : arrayBase64) {
//                jsonTempBase64 = ((JSONObject) arrayBase641);
//                tempDetailModel = new DepotFileDetailModel();
//                tempDetailModel.fileBase64Value = jsonTempBase64.getString("base64value");
//                if (jsonTempBase64.containsKey("filename")) {
//                    tempDetailModel.fileName = jsonTempBase64.getString("filename");
//                }
//                if (jsonTempBase64.containsKey("fileId")) {
//                    tempDetailModel.fileId = jsonTempBase64.getString("fileId");
//                }
//                tempDetailModel.fileOwnType = jsonTempBase64.getString("fileType");
//                paramModel.fileDetaile.add(tempDetailModel);
//            }
//            return paramModel;
//        } catch (Exception e) {
//            throw new Exception(String.format("analyzeBase64Param error :%s", e.getLocalizedMessage()));
//        } finally {
//            UtileSmart.FreeObjects(jsonBody, jsonHead, jsonObj, jsonTempBase64, arrayBase64, tempDetailModel);
//        }
//
//    }
    /**
     * 解析json
     *
     * @param strJson
     * @return
     * @throws Exception
     */
    public FileDepotParamModel analyzeUpLoadFileJsonStr(String strJson) throws Exception {

        String paramKey_context = "context";
        String paramKey_ownid = "ownId";
        String paramKey_fileDes = "fileDes";
        String paramKey_filename = "fileName";
        String paramKey_fileType = "fileType";
        String paramKey_fileId = "fileId";

        FileDepotParamModel paramModel = null;
        JSONObject jsonObj = null, jsonTempContext = null, jsonTempFileDesc = null;
        JSONArray jsonContext = null, jsonFileDes = null;
        DepotFileDetailModel fileDetailModel = null;
        try {
            jsonObj = JSONObject.fromObject(strJson);
            paramModel = new FileDepotParamModel();
            if (!jsonObj.containsKey(paramKey_context)) {
                throw new NotFoundException("FileDepotParamError no context array.");
            }
            jsonContext = jsonObj.getJSONArray(paramKey_context);

            for (Object contextObj : jsonContext) {
                jsonTempContext = (JSONObject) contextObj;
                paramModel.ownid = jsonTempContext.getString(paramKey_ownid);
                jsonFileDes = jsonTempContext.getJSONArray(paramKey_fileDes);

                for (Object fileDescObj : jsonFileDes) {
                    jsonTempFileDesc = (JSONObject) fileDescObj;
                    fileDetailModel = new DepotFileDetailModel();
                    fileDetailModel.fileName = UtileSmart.TryGetJsonString(jsonTempFileDesc, paramKey_filename);
                    fileDetailModel.fileOwnType = UtileSmart.TryGetJsonString(jsonTempFileDesc, paramKey_fileType);
                    fileDetailModel.fileId = UtileSmart.TryGetJsonString(jsonTempFileDesc, paramKey_fileId);
                    paramModel.addFileDetail(fileDetailModel);
                }
            }
            return paramModel;
        } catch (Exception e) {
            throw new Exception("analyze FileParamModel error.:" + e.getLocalizedMessage());
        } finally {
            UtileSmart.FreeObjects(paramModel, jsonObj, jsonTempContext, jsonTempFileDesc, fileDetailModel, jsonFileDes);
        }
    }

    /**
     * 解析json
     *
     * @param strJson
     * @return
     * @throws Exception
     */
    public FileDepotParamModel analyzeNormalJsonStr(String strJson) throws Exception {

        String paramKey_context = "context";
        String paramKey_ownIds = "ownIds";
        String paramKey_fileIds = "fileIds";
        String paramKey_fileTypes = "fileTypes";

        FileDepotParamModel paramModel = null;
        JSONObject jsonObj = null, jsonTempContext = null;
        JSONObject jsonContext = null;
        DepotFileDetailModel fileDetailModel = null;
        try {
            jsonObj = JSONObject.fromObject(strJson);
            paramModel = new FileDepotParamModel();
            if (!jsonObj.containsKey(paramKey_context)) {
                throw new NotFoundException("FileDepotParamError no context array.");
            }
            jsonContext = jsonObj.getJSONObject(paramKey_context);

            if (jsonContext.containsKey(paramKey_fileIds)) {
                //paramModel.fileIds jsonContext.getJSONArray(paramKey_fileIds);
                paramModel.fileIds = UtileSmart.JSONArrayToListStr(jsonContext.getJSONArray(paramKey_fileIds));
            }
            if (jsonContext.containsKey(paramKey_ownIds)) {
                paramModel.ownIds = UtileSmart.JSONArrayToListStr(jsonContext.getJSONArray(paramKey_ownIds));
//                jsonContext.getJSONArray(paramKey_ownIds);
            }
            if (jsonContext.containsKey(paramKey_fileTypes)) {
                paramModel.ownFileTypes = UtileSmart.JSONArrayToListStr(jsonContext.getJSONArray(paramKey_fileTypes));
//                jsonContext.getJSONArray(paramKey_fileTypes);
            }

            return paramModel;
        } catch (Exception e) {
            throw new Exception("analyze FileParamModel error.:" + e.getLocalizedMessage());
        } finally {
            UtileSmart.FreeObjects(paramModel, jsonObj, fileDetailModel);
        }
    }

    /**
     * 保存上传文件到服务器
     *
     * @param formFileData
     * @param strJson
     * @param isModify 是否提交
     * @return
     */
    private String SaveUpLoadFile(List< MultipartFile> uploadFiles, FileDepotParamModel paramModel) throws Exception {

        String strSvcFileLocalName = null, strUpFileName = null, strTempFilePath = null;
        StringBuffer sbTemp = new StringBuffer();
        StringBuffer sbFilePathTemp = new StringBuffer();
        boolean bSvcFileExist = false;
        DepotFileDetailModel tempFileDetailModel = null;
        int saveFlag = 1;
        Set<Filedepot> fileDepots = null;
        if (paramModel == null) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorParam, String.format("UpLoadFile param error"));
        }
//        SignInformationModel signModel = SignCommon.verifySign(paramModel.getToken(), false);
//        if (signModel == null) {
//            return responseFormat.formationResultToString(ResponseResultCode.ErrorSignToken, "no authorize");
//        }

        try {
            fileDepots = new HashSet<Filedepot>();
            for (MultipartFile tempFile : uploadFiles) {
                strUpFileName = tempFile.getOriginalFilename();
                //组织路径  root/date(yymmddhh)/Type
                //第一级目录
//                sbFilePathTemp.append(paramModel.rsid);
                sbTemp.append(DeployConfigInfo.getDeployDepotPath());
                FileHelper.CheckFileExist(sbTemp.toString());
                //二级目录
                String tempDirStr = UtileSmart.getCurrentDate();
                sbFilePathTemp.append(File.separator).append(tempDirStr);
                sbTemp.append(File.separator).append(tempDirStr);
                FileHelper.CheckFileExist(sbTemp.toString());
                tempFileDetailModel = paramModel.getFileDetailModel(strUpFileName);
                if (tempFileDetailModel == null) {
                    return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorParam, String.format("param error"));
                }
                //判断如果类型应该是纯字符串，如果包含 文件路径分隔符(File.separator) 错误路径
                if (tempFileDetailModel.fileOwnType.indexOf(File.separator) > 0) {
                    return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorFileType, String.format("file type error"));
                }
                sbFilePathTemp.append(File.separator).append(tempFileDetailModel.fileOwnType);
                sbTemp.append(File.separator).append(tempFileDetailModel.fileOwnType);
                FileHelper.CheckFileExist(sbTemp.toString());
                //检查上次文件是否存在
                sbFilePathTemp.append(File.separator).append(strUpFileName).toString();
                strSvcFileLocalName = sbTemp.append(File.separator).append(strUpFileName).toString();
                bSvcFileExist = FileHelper.CheckFileExist(strSvcFileLocalName, false);
                if (bSvcFileExist) {
                    return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorFileExist, "file exist");
                }
                //判断数据库是否存在 ownid 和 fpath重复的数据，如果有数据重复不能上传文件
                long fileDBCount = fileDepotRepository.countByFNameAndOwnId(paramModel.ownid, strUpFileName);

                if (fileDBCount != 0) {
                    return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorFileRepeat, "file binded");
                }

                tempFile.transferTo(new File(strSvcFileLocalName));

                //本次文件保存成功，设置本地路径值，后续操作失败可以返回删除保存的文件
                tempFileDetailModel.fileLocalPath = strSvcFileLocalName;
                //生成sql语句，待文件全部上传成功，保存到数据库

                Filedepot fileDepot = new Filedepot();
                if (tempFileDetailModel.fileId != null && !tempFileDetailModel.fileId.isEmpty()) {
                    fileDepot.setFileId(tempFileDetailModel.fileId);
                }
                fileDepot.setOwnId(paramModel.ownid);
                fileDepot.setOwnFileType(tempFileDetailModel.fileOwnType);
                fileDepot.setFName(strUpFileName);
                fileDepot.setFPath(sbFilePathTemp.toString());
                fileDepots.add(fileDepot);
                sbTemp.delete(0, sbTemp.length());
                sbFilePathTemp.delete(0, sbFilePathTemp.length());
            }
            //保存数据到数据库
            fileDepotService.saveFiles(fileDepots);
            saveFlag = 0;
            return ResponseFormationJson.FormationResponseSucess(null);
        } catch (Exception e) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorDB, e);
        } finally {
            if (saveFlag == 1) {
                DeleteFile(paramModel.fileDetaile);
            }
            UtileSmart.FreeObjects(strSvcFileLocalName, strUpFileName, strTempFilePath,
                    sbTemp, sbFilePathTemp, fileDepots, paramModel, tempFileDetailModel);
        }

    }

    /**
     * 删除指定文件
     *
     * @param fileDetailModels
     */
    private void DeleteFile(Set<DepotFileDetailModel> fileDetailModels) {
        if (fileDetailModels != null && !fileDetailModels.isEmpty()) {
            for (DepotFileDetailModel fileDetailModel : fileDetailModels) {
                if (fileDetailModel.fileLocalPath != null && !fileDetailModel.fileLocalPath.isEmpty()) {
                    FileHelper.deleteFile(fileDetailModel.fileLocalPath);
                }
            }
        }

    }

//    /**
//     * 根据own作废 own下面的文件修改数据库状态
//     *
//     * @param strParam
//     * @return
//     */
//    @POST
//    @Path("InvalidDepotFileByOwn")
//    public String InvalidDepotFileByOwn(String strParam) {
//        //sbTemp.append(DeployInfo.GetDeployFilePath()).append(sbFilePathTemp);
//        FileDepotParamModel paramModel = null;
//        ExecuteResultParam resultModel = null;
//        try {
//            paramModel = analyzeNormalJsonStr(strParam);
//
//            SignInformationModel signModel = SignCommon.verifySign(paramModel.getToken(), false);
//            if (signModel == null) {
//                return responseFormat.formationResultToString(ResponseResultCode.ErrorSignToken, "no authorize");
//            }
//
//            resultModel = InvalidDepotFile(paramModel);
//            if (resultModel.ResultCode >= 0) {
//                // return formationResult.formationResult(ResponseResultCode.Success, new ExecuteResultParam(resultModel.ResultJsonObject));
//
//                return responseFormat.formationSuccessResultToString(resultModel.ResultJsonObject);
//            } else {
//                //return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam(resultModel.errMsg, strParam));
//
//                return responseFormat.formationResultToString(ResponseResultCode.ErrorDB, resultModel.errMsg);
//            }
//        } catch (Exception e) {
//
//            return responseFormat.formationResultToString(ResponseResultCode.ErrorDB, e);
//            //return formationResult.formationResult(ResponseResultCode.Error, new ExecuteResultParam(e.getLocalizedMessage(), strParam, e));
//        }
//    }
//    private ExecuteResultParam InvalidDepotFile(FileDepotParamModel paramModel) throws Exception {
//        StringBuffer sbSql = new StringBuffer();
//        StringBuffer sbSqlDelete = new StringBuffer();
//        List<String> lsSql = null;
//        try {
//            sbSql.append(String.format("insert into FILEDEPOT_LS (FID,FNAME,FPATH,FSUMMARY,OWNID,OWNFILETYPE,UPLOADDATE) select  FID,FNAME,FPATH,FSUMMARY,OWNID,OWNFILETYPE,UPLOADDATE from FILEDEPOT  as t_f where t_f.OWNID='%s' ", paramModel.ownid));
//            sbSqlDelete.append(String.format("delete FILEDEPOT  where OWNID='%s' ", paramModel.ownid));
//            if (paramModel.fileDetaile != null && paramModel.fileDetaile.size() > 0) {
//                if (paramModel.selectFlag == 1) {
//                    sbSql.append(" and t_f.FID in (");
//                    sbSqlDelete.append(" and FID in (");
//                } else if (paramModel.selectFlag == 2) {
//                    sbSql.append(" and t_f.OWNFILETYPE in ( ");
//                    sbSqlDelete.append(" and OWNFILETYPE in ( ");
//                } else {
//                    return new ExecuteResultParam(-1, "解析json参数失败，文件描述不为空，但是标记值未修改。");
//                }
//                for (DepotFileDetailModel paramModelTemp : paramModel.fileDetaile) {
//                    if (paramModel.selectFlag == 1) {
//                        sbSql.append("'").append(paramModelTemp.fileId).append("'");
//                        sbSqlDelete.append("'").append(paramModelTemp.fileId).append("'");
//                    } else if (paramModel.selectFlag == 2) {
//                        sbSql.append("'").append(paramModelTemp.fileOwnType).append("'");
//                        sbSqlDelete.append("'").append(paramModelTemp.fileOwnType).append("'");
//                    } else {
//                        return new ExecuteResultParam(-1, "解析json参数失败，文件描述不为空，但是标记值未修改。");
//                    }
//                    sbSql.append(',');
//                    sbSqlDelete.append(",");
//                }
//                sbSql.deleteCharAt(sbSql.length() - 1);
//                sbSql.append(")");
//
//                sbSqlDelete.deleteCharAt(sbSqlDelete.length() - 1);
//                sbSqlDelete.append(")");
//            }
//            lsSql = new ArrayList<String>();
//
//            lsSql.add(sbSql.toString());
//            lsSql.add(sbSqlDelete.toString());
//            return DBHelper.ExecuteSql(DeployInfo.MasterRSID, lsSql);
//        } catch (Exception e) {
//            throw new Exception(e.getLocalizedMessage());
//        } finally {
//            UtileSmart.FreeObjects(paramModel, sbSql, sbSqlDelete);
//        }
//    }
    /**
     * 根据own查询own对应的所有
     *
     * @param strParam
     * @return
     */
    @RequestMapping(value = "/getDepotFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getDepotFile(@RequestBody String strParam) {
        FileDepotParamModel paramModel = null;
        try {
            paramModel = analyzeNormalJsonStr(strParam);

//            SignInformationModel signModel = SignCommon.verifySign(paramModel.getToken(), false);
//            if (signModel == null) {
//                return responseFormat.formationResultToString(ResponseResultCode.ErrorSignToken, "no authorize");
//            }
            List<Filedepot> fileDepots = fileDepotRepository.findByFileIdInOrOwnIdInOrOwnFileTypeIn(paramModel.fileIds, paramModel.ownIds, paramModel.ownFileTypes);
            StringBuffer sb = new StringBuffer();
            for (Filedepot fileDepot : fileDepots) {
                sb.append(webSiteConfig.getWebSiteHttpDepotPath()).append(fileDepot.getFPath().replace('\\', '/'));
                fileDepot.setHttpPath(sb.toString());
                sb.delete(0, sb.length());
            }

            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
//            JSONObject jsonObject = JSONObject.fromObject(fileDepots, jsonConfig);
            JSONArray jsonArray = JSONArray.fromObject(fileDepots, jsonConfig);

            return ResponseFormationJson.FormationResponseSucess(jsonArray);
        } catch (Exception e) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorDB, e);
        }
    }
}
