/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myaccountls.findAll", query = "SELECT m FROM Myaccountls m"),
    @NamedQuery(name = "Myaccountls.findByAccountId", query = "SELECT m FROM Myaccountls m WHERE m.accountId = :accountId"),
    @NamedQuery(name = "Myaccountls.findByAccountNum", query = "SELECT m FROM Myaccountls m WHERE m.accountNum = :accountNum"),
    @NamedQuery(name = "Myaccountls.findByAccountType", query = "SELECT m FROM Myaccountls m WHERE m.accountType = :accountType"),
    @NamedQuery(name = "Myaccountls.findByUserId", query = "SELECT m FROM Myaccountls m WHERE m.userId = :userId"),
    @NamedQuery(name = "Myaccountls.findByMasterRealName", query = "SELECT m FROM Myaccountls m WHERE m.masterRealName = :masterRealName"),
    @NamedQuery(name = "Myaccountls.findByMasterVerifyPhone", query = "SELECT m FROM Myaccountls m WHERE m.masterVerifyPhone = :masterVerifyPhone"),
    @NamedQuery(name = "Myaccountls.findByPayStatus", query = "SELECT m FROM Myaccountls m WHERE m.payStatus = :payStatus"),
    @NamedQuery(name = "Myaccountls.findByPutTime", query = "SELECT m FROM Myaccountls m WHERE m.putTime = :putTime"),
    @NamedQuery(name = "Myaccountls.findByInvalidTime", query = "SELECT m FROM Myaccountls m WHERE m.invalidTime = :invalidTime")})
public class Myaccountls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String accountId;
    private String accountNum;
    private Integer accountType;
    private String userId;
    private String masterRealName;
    private String masterVerifyPhone;
    private Integer payStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date putTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date invalidTime;

    public Myaccountls() {
    }

    public Myaccountls(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMasterRealName() {
        return masterRealName;
    }

    public void setMasterRealName(String masterRealName) {
        this.masterRealName = masterRealName;
    }

    public String getMasterVerifyPhone() {
        return masterVerifyPhone;
    }

    public void setMasterVerifyPhone(String masterVerifyPhone) {
        this.masterVerifyPhone = masterVerifyPhone;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Myaccountls)) {
            return false;
        }
        Myaccountls other = (Myaccountls) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Myaccountls[ accountId=" + accountId + " ]";
    }
    
}
