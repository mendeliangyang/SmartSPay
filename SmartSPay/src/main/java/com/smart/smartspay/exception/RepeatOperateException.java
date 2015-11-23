/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.exception;

/**
 *
 * @author Administrator
 */
public class RepeatOperateException extends Exception {

    public RepeatOperateException() {
        super();
    }

    public RepeatOperateException(String message) {
        super(message);
    }

    public RepeatOperateException(Throwable throwable) {
        super(throwable);
    }

    public RepeatOperateException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
