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
public class CustomErrorCodeException extends SmartBaseException {

    public CustomErrorCodeException() {
        super();
    }

    public CustomErrorCodeException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public CustomErrorCodeException( String message) {
        super(ResponseResultCode.ErrorNotFound, message);
    }

    public CustomErrorCodeException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public CustomErrorCodeException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}