/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author Administrator
 */
@Aspect
public class ControllerAspect {

    @Around(value = "execution(* com.smart.smartspay.controller.*.*(..))")
    public Object aroundImpl(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //  log
            Object[] args = joinPoint.getArgs();
            System.out.println(args.toString() + joinPoint.toString());
            //log
            Object resultObject = joinPoint.proceed(joinPoint.getArgs());
            return resultObject;
        } catch (Exception e) {
            return "error";
        } finally {
            //log
        }

    }
}
