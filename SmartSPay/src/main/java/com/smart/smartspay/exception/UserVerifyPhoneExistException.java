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
public class UserVerifyPhoneExistException extends SmartBaseException {

    public UserVerifyPhoneExistException() {
        super();
    }

    public UserVerifyPhoneExistException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public UserVerifyPhoneExistException(String message) {
        super(ResponseResultCode.ErrorExistVerifyPhone, message);
    }

    public UserVerifyPhoneExistException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public UserVerifyPhoneExistException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}
