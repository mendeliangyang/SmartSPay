/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "USERDETAIL")
public class UserDetailEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;
    private String userName;
    private String password;
    private String nickName;
    private String verifyPhone;
    private String RealName;
    private int gender;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;
    private String idCard;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date signUpDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date signOnDate;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getVerifyPhone() {
        return verifyPhone;
    }

    public void setVerifyPhone(String verifyPhone) {
        this.verifyPhone = verifyPhone;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    public Date getSignOnDate() {
        return signOnDate;
    }

    public void setSignOnDate(Date signOnDate) {
        this.signOnDate = signOnDate;
    }
    
    
}
