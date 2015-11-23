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
public class UserVerifyPhoneExistException extends Exception {

    public UserVerifyPhoneExistException() {
        super();
    }

    public UserVerifyPhoneExistException(String message) {
        super(message);
    }

    public UserVerifyPhoneExistException(Throwable throwable) {
        super(throwable);
    }

    public UserVerifyPhoneExistException(String message, Throwable throwable) {
        super(message, throwable);
    }
}