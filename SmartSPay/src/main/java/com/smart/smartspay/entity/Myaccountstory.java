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
@Table(name = "myaccountstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myaccountstory.findAll", query = "SELECT m FROM Myaccountstory m"),
    @NamedQuery(name = "Myaccountstory.findByAccountId", query = "SELECT m FROM Myaccountstory m WHERE m.accountId = :accountId"),
    @NamedQuery(name = "Myaccountstory.findByAccountNum", query = "SELECT m FROM Myaccountstory m WHERE m.accountNum = :accountNum"),
    @NamedQuery(name = "Myaccountstory.findByAccountIssue", query = "SELECT m FROM Myaccountstory m WHERE m.accountIssue = :accountIssue"),
    @NamedQuery(name = "Myaccountstory.findByUserId", query = "SELECT m FROM Myaccountstory m WHERE m.userId = :userId"),
    @NamedQuery(name = "Myaccountstory.findByMasterRealName", query = "SELECT m FROM Myaccountstory m WHERE m.masterRealName = :masterRealName"),
    @NamedQuery(name = "Myaccountstory.findByMasterVerifyPhone", query = "SELECT m FROM Myaccountstory m WHERE m.masterVerifyPhone = :masterVerifyPhone"),
    @NamedQuery(name = "Myaccountstory.findByValidStatus", query = "SELECT m FROM Myaccountstory m WHERE m.validStatus = :validStatus"),
    @NamedQuery(name = "Myaccountstory.findByPutTime", query = "SELECT m FROM Myaccountstory m WHERE m.putTime = :putTime"),
    @NamedQuery(name = "Myaccountstory.findByInvalidTime", query = "SELECT m FROM Myaccountstory m WHERE m.invalidTime = :invalidTime"),
    @NamedQuery(name = "Myaccountstory.findByItemId", query = "SELECT m FROM Myaccountstory m WHERE m.itemId = :itemId")})
public class Myaccountstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AccountId", nullable = false, length = 40)
    private String accountId;
    @Basic(optional = false)
    @Column(name = "AccountNum", nullable = false, length = 40)
    private String accountNum;
    @Basic(optional = false)
    @Column(name = "AccountIssue", nullable = false, length = 2)
    private String accountIssue;
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false, length = 40)
    private String userId;
    @Column(name = "MasterRealName", length = 60)
    private String masterRealName;
    @Column(name = "MasterVerifyPhone", length = 40)
    private String masterVerifyPhone;
    @Column(name = "ValidStatus")
    private Integer validStatus;
    @Column(name = "PutTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date putTime;
    @Column(name = "InvalidTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invalidTime;
    @Column(name = "ItemId", length = 20)
    private String itemId;

    public Myaccountstory() {
    }

    public Myaccountstory(String accountId) {
        this.accountId = accountId;
    }

    public Myaccountstory(String accountId, String accountNum, String accountIssue, String userId) {
        this.accountId = accountId;
        this.accountNum = accountNum;
        this.accountIssue = accountIssue;
        this.userId = userId;
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

    public String getAccountIssue() {
        return accountIssue;
    }

    public void setAccountIssue(String accountIssue) {
        this.accountIssue = accountIssue;
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
        if (!(object instanceof Myaccountstory)) {
            return false;
        }
        Myaccountstory other = (Myaccountstory) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Myaccountstory[ accountId=" + accountId + " ]";
    }
    
}
