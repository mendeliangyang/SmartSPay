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
public class UserNickNameExistException extends Exception {

    public UserNickNameExistException() {
        super();
    }

    public UserNickNameExistException(String message) {
        super(message);
    }

    public UserNickNameExistException(Throwable throwable) {
        super(throwable);
    }

    public UserNickNameExistException(String message, Throwable throwable) {
        super(message, throwable);
    }
}