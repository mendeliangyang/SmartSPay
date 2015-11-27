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
public class NotFoundException extends SmartBaseException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public NotFoundException( String message) {
        super(ResponseResultCode.ErrorNotFound, message);
    }

    public NotFoundException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public NotFoundException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}
