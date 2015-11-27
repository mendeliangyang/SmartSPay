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
public abstract class SmartBaseException extends Exception {

    public SmartBaseException() {
        super();
    }

    public SmartBaseException(ResponseResultCode resultCode) {
        super();
        this.resultCode = resultCode;
    }

    public SmartBaseException(ResponseResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public SmartBaseException(ResponseResultCode resultCode, Throwable throwable) {
        super(throwable);
        this.resultCode = resultCode;
    }

    public SmartBaseException(ResponseResultCode resultCode, String message, Throwable throwable) {
        super(message, throwable);
        this.resultCode = resultCode;
    }

    private ResponseResultCode resultCode;

    public ResponseResultCode getResultCode() {
        return resultCode;
    }

}
