/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

public enum ResponseResultCode {

    /**
     * 1000 标识base 错误 1200 标识文件系统错误信息
     *
     * 2000 标识 社区金融系统错误
     */
    Error("1000"), Success("0000"), ErrorSignToken("1002"), ErrorParam("1001"), ErrorBase64Error("1003"), ErrorDB("1004"), ErrorBase64ConvertFile("1005"),
    ErrorRepeat("1006"),
    ErrorFileExist("1201"), ErrorFileRepeat("1202"),//文件关联关系重复
    ErrorFileType("1203"),
    ErrorFileUnExistOnDB("1204"),//文件类型错误
    ErrorUserOrPwd("2002"), ErrorUserName("2003"), ErrorExistAccount("2004"), ErrorExistUser("2005"), ErrorUnExistAccount("2006"), ErrorExistAccountBind("2007"),
    ErrorExistUserNickName("2008"), ErrorExistVerifyPhone("2009"),
    ErrorNotFound("4001"), //指定资源没有找到
    ErrorAccountIssueLackItem("6001"),//账户渠道没有配置对应的科目
    ErrorAccountInfoFail("6002"),//账户信息错误，需要联系管理员，查看后台数据
    ErrorAccountLength("6003"),//银行卡长度不正确
    ErrorAccountPattern("6004"),//银行卡格式不正确
    ErrorAccountIssueUnSupport("6005"),//银行卡格式不正确
    ErrorUndefinedActChannel("6006"),//未定义交易渠道
    ErrorDealAccountUnBind("6007"),//交易帐号，没有绑定
    ErrorUndefinedDealInterface("6008"),//交易接口规则未定义
    ErrorUndefinedDealRule("6009"),//交易规则未定义 DealRule
    ErrorUndefinedItem("6010"),//交易科目
    ErrorUndefinedLedger("6011"),//未定义分户账
    ErrorBuildItemDealStreamEmpty("6012"),//生成科目流水帐为空
    ErrorBuildLedgerDealStreamEmpty("6013"),//生成分户账流水为空
    ;

    private String describe;

    ResponseResultCode(String idx) {
        this.describe = idx;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return describe;
    }
}
