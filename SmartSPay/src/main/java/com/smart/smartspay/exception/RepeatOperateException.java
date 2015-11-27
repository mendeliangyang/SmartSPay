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
public class RepeatOperateException extends SmartBaseException {

    public RepeatOperateException() {
        super();
    }

    public RepeatOperateException(ResponseResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public RepeatOperateException(String message) {
        super(ResponseResultCode.ErrorRepeat, message);
    }

    public RepeatOperateException(ResponseResultCode resultCode, Throwable throwable) {
        super(resultCode, throwable);
    }

    public RepeatOperateException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(resultCode, message, throwable);
    }
}
