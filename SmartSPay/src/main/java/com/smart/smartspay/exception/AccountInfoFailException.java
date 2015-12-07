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
public class AccountInfoFailException extends SmartBaseException {

    public AccountInfoFailException() {
        super();
    }

    public AccountInfoFailException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public AccountInfoFailException( String message) {
        super(ResponseResultCode.ErrorNotFound, message);
    }

    public AccountInfoFailException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public AccountInfoFailException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}