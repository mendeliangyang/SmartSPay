/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.controller;

import com.smart.smartscommon.util.AnalyzeParam;
import com.smart.smartscommon.util.UtileSmart;
import com.smart.smartscommon.util.gsonsmart.SmartExclusionStrategy;
import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.repository.UserDetailRepository;
import com.smart.smartspay.service.UserService;
import com.smart.smartspay.sign.SignCommon;
import com.smart.smartspay.sign.SignInformationModel;
import com.smart.smartspay.util.ResponseFormationJson;
import com.smart.smartspay.util.ResponseResultCode;
import com.smart.smartspay.util.UserUtile;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/UserDetail")
public class UserDetailController {

//    @Autowired
    @Resource
    private UserDetailRepository userDetailRepository;

    @Resource
    UserService userService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String registerUser(@RequestBody String param) throws Exception {

        String paramKey_userName = "userName";
        String paramKey_uPassword = "uPassword";
        String paramKey_verifyPhone = "verifyPhone";
        String paramKey_nickName = "nickName";
        String paramKey_verifyCode = "verifyCode";

        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);

        //todo verify  user mobliePhone and verifyCode
        UtileSmart.getStringFromMap(paramMap, paramKey_verifyCode);

        Userdetail user = new Userdetail();
        String nickName = UtileSmart.tryGetStringFromMap(paramMap, paramKey_nickName);
        String userName = UtileSmart.getStringFromMap(paramMap, paramKey_userName);
        nickName = (nickName == null ? userName : nickName);
        user.setUserId(UtileSmart.getUUID());
        user.setNickName(nickName);
        user.setUserName(userName);
        user.setVerifyPhone(UtileSmart.getStringFromMap(paramMap, paramKey_verifyPhone));
        user.setUPassword(UserUtile.UserPasswordMD5Convert(UtileSmart.getStringFromMap(paramMap, paramKey_uPassword)));
        user.setSignUpTime(new Date());
        userService.registerUser(user);
        return ResponseFormationJson.FormationResponseSucess(user);

    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String modifyPassword(@RequestBody String param) throws Exception {

        String paramKey_userName = "userName";
        String paramKey_verifyCode = "verifyCode";
        String paramKey_uPassword = "uPassword";

        Map<String, Object> paramMap = new HashMap<String, Object>();
        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        //todo verify verifyCode
        UtileSmart.getStringFromMap(paramMap, paramKey_verifyCode);

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        Userdetail user = new Userdetail();
        user.setUserName(UtileSmart.getStringFromMap(paramMap, paramKey_userName));
        user.setUPassword(UserUtile.UserPasswordMD5Convert(UtileSmart.getStringFromMap(paramMap, paramKey_uPassword)));
        userService.modifyPassword(user);

        return ResponseFormationJson.FormationResponseSucess();

    }

    @RequestMapping(value = "/modifyPassword2", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String modifyPassword2(@RequestBody String param) throws Exception {

        String paramKey_userName = "userName";
        String paramKey_overPassword = "overPassword";
        String paramKey_uPassword = "uPassword";

        Map<String, Object> paramMap = new HashMap<String, Object>();
        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        //todo verify verifyCode
        UtileSmart.getStringFromMap(paramMap, paramKey_overPassword);

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        Userdetail user = new Userdetail();
        user.setUserName(UtileSmart.getStringFromMap(paramMap, paramKey_userName));
        user.setUPassword(UserUtile.UserPasswordMD5Convert(UtileSmart.getStringFromMap(paramMap, paramKey_overPassword)));
        userService.modifyPassword2(user, UserUtile.UserPasswordMD5Convert(UtileSmart.getStringFromMap(paramMap, paramKey_uPassword)));

        return ResponseFormationJson.FormationResponseSucess();

    }

    @RequestMapping(value = "/getUserDetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUserDetail(@RequestBody String param) throws Exception {

        String paramKey_userId = "userId";
        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        Userdetail userDetail = userDetailRepository.findOne(UtileSmart.getStringFromMap(paramMap, paramKey_userId));

        Map<Class<?>, String[]> exclude = new HashMap<Class<?>, String[]>();
        exclude.put(String.class, new String[]{"idCard"});

        return ResponseFormationJson.FormationResponseSucess(userDetail, new SmartExclusionStrategy(exclude));

    }

    @RequestMapping(value = "/signOn", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String SignOn(@RequestBody String param) throws Exception {

        String paramKey_userName = "userName";
        String paramKey_uPassword = "uPassword";

        Map<String, Object> paramMap = new HashMap<String, Object>();

        AnalyzeParam.AnalyzeParamToMap(param, paramMap);
        Userdetail userdeatil = userDetailRepository.getUserDetail(UtileSmart.getStringFromMap(paramMap, paramKey_userName),
                UserUtile.UserPasswordMD5Convert(UtileSmart.getStringFromMap(paramMap, paramKey_uPassword)));
        if (userdeatil == null) {
            return ResponseFormationJson.FormationResponse(ResponseResultCode.ErrorUserOrPwd, "user don't exist.");
        }
        //登录成功，返回用户信息
        SignInformationModel signModel = SignCommon.SignIn(userdeatil.getUserId(), null, null);
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("token", signModel.getToken());
        results.put("userdetail", userdeatil);
        return ResponseFormationJson.FormationResponseSucess(results);
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String signOut(@RequestBody String param) {
        return ResponseFormationJson.FormationResponseSucess();

    }
}
