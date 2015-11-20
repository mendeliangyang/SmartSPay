/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "Myaccount.findAll", query = "SELECT m FROM Myaccount m"),
    @NamedQuery(name = "Myaccount.findByAccountId", query = "SELECT m FROM Myaccount m WHERE m.accountId = :accountId"),
    @NamedQuery(name = "Myaccount.findByAccountNum", query = "SELECT m FROM Myaccount m WHERE m.accountNum = :accountNum"),
    @NamedQuery(name = "Myaccount.findByAccountType", query = "SELECT m FROM Myaccount m WHERE m.accountType = :accountType"),
    @NamedQuery(name = "Myaccount.findByUserId", query = "SELECT m FROM Myaccount m WHERE m.userId = :userId"),
    @NamedQuery(name = "Myaccount.findByMasterRealName", query = "SELECT m FROM Myaccount m WHERE m.masterRealName = :masterRealName"),
    @NamedQuery(name = "Myaccount.findByMasterVerifyPhone", query = "SELECT m FROM Myaccount m WHERE m.masterVerifyPhone = :masterVerifyPhone"),
    @NamedQuery(name = "Myaccount.findByValidStatus", query = "SELECT m FROM Myaccount m WHERE m.validStatus = :validStatus"),
    @NamedQuery(name = "Myaccount.findByPutTime", query = "SELECT m FROM Myaccount m WHERE m.putTime = :putTime"),
    @NamedQuery(name = "Myaccount.findByInvalidTime", query = "SELECT m FROM Myaccount m WHERE m.invalidTime = :invalidTime")})
public class Myaccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String accountId;
    @Column(length = 40)
    private String accountNum;
    private Integer accountType;
    @Column(length = 40)
    private String userId;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String masterRealName;
    @Column(length = 40)
    private String masterVerifyPhone;
    private Integer validStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date putTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date invalidTime;

    public Myaccount() {
    }

    public Myaccount(String accountId) {
        this.accountId = accountId;
    }

    public Myaccount(String accountId, String masterRealName) {
        this.accountId = accountId;
        this.masterRealName = masterRealName;
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

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
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
        if (!(object instanceof Myaccount)) {
            return false;
        }
        Myaccount other = (Myaccount) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Myaccount[ accountId=" + accountId + " ]";
    }
    
}
