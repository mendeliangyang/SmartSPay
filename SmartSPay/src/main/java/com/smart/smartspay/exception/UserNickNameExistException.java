/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.exception;

import com.smart.smartspay.util.ResponseResultCode;

/**
 *
 * @author Administrator
 */
public class UserNickNameExistException extends SmartBaseException {

    public UserNickNameExistException() {
        super();
    }

    public UserNickNameExistException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public UserNickNameExistException(String message) {
        super(ResponseResultCode.ErrorExistUserNickName, message);
    }

    public UserNickNameExistException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public UserNickNameExistException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}
