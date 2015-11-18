/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.task;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class AddUp {

    @Scheduled(fixedRate = 720000)
    public void scan() {

    }
}
