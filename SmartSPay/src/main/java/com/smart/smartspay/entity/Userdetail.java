/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
public class Userdetail extends BaseFileDepot implements Serializable, SmartReponseFormation {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String userId;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String userName;
    @Basic(optional = false)
    @Column(nullable = false, length = 40) //transient
    private String uPassword;
    @Column(length = 40)
    private String nickName;
    @Column(length = 20)
    private String verifyPhone;
    @Column(length = 40)
    private String realName;
    private Integer gender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(length = 20)
    private String idCard;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date signOnTime;

    public Userdetail() {
    }

    public Userdetail(String userId) {
        this.userId = userId;
    }

    public Userdetail(String userId, String userName, String uPassword, Date signUpTime) {
        this.userId = userId;
        this.userName = userName;
        this.uPassword = uPassword;
        this.signUpTime = signUpTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
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
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
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

    public Date getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    public Date getSignOnTime() {
        return signOnTime;
    }

    public void setSignOnTime(Date signOnTime) {
        this.signOnTime = signOnTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdetail)) {
            return false;
        }
        Userdetail other = (Userdetail) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Userdetail[ userId=" + userId + " ]";
    }

    @Override
    public String getFileOwnId() {
        return this.userId;
    }

}
