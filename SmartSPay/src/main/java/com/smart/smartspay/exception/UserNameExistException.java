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
public class UserNameExistException extends SmartBaseException {

    public UserNameExistException() {
        super();
    }

    public UserNameExistException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public UserNameExistException(String message) {
        super(ResponseResultCode.ErrorExistUser, message);
    }

    public UserNameExistException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public UserNameExistException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}
