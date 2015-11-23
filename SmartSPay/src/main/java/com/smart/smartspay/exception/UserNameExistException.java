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
public class UserNameExistException extends Exception {

    public UserNameExistException() {
        super();
    }

    public UserNameExistException(String message) {
        super(message);
    }

    public UserNameExistException(Throwable throwable) {
        super(throwable);
    }

    public UserNameExistException(String message, Throwable throwable) {
        super(message, throwable);
    }
}