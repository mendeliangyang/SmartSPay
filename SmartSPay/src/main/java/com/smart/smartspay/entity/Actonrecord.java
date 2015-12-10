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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "actonrecord", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actonrecord.findAll", query = "SELECT a FROM Actonrecord a")})
public class Actonrecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ActOnRecordId", nullable = false)
    private Integer actOnRecordId;
    @Basic(optional = false)
    @Column(name = "ActOnId", nullable = false, length = 40)
    private String actOnId;
    @Basic(optional = false)
    @Column(name = "FromAccountId", nullable = false, length = 40)
    private String fromAccountId;
    @Basic(optional = false)
    @Column(name = "ToAccountId", nullable = false, length = 40)
    private String toAccountId;
    @Basic(optional = false)
    @Column(name = "Money", nullable = false, length = 20)
    private String money;
    @Basic(optional = false)
    @Column(name = "ActOnDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actOnDateTime;
    @Basic(optional = false)
    @Column(name = "OperationTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationTime;
    @Basic(optional = false)
    @Column(name = "ActOnStatus", nullable = false)
    private int actOnStatus;
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false, length = 40)
    private String userId;
    @Column(name = "AccountBindId", length = 40)
    private String accountBindId;

    public Actonrecord() {
    }

    public Actonrecord(Integer actOnRecordId) {
        this.actOnRecordId = actOnRecordId;
    }

    public Actonrecord(Integer actOnRecordId, String actOnId, String fromAccountId, String toAccountId, String money, Date actOnDateTime, Date operationTime, int actOnStatus, String userId) {
        this.actOnRecordId = actOnRecordId;
        this.actOnId = actOnId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.money = money;
        this.actOnDateTime = actOnDateTime;
        this.operationTime = operationTime;
        this.actOnStatus = actOnStatus;
        this.userId = userId;
    }

    public Integer getActOnRecordId() {
        return actOnRecordId;
    }

    public void setActOnRecordId(Integer actOnRecordId) {
        this.actOnRecordId = actOnRecordId;
    }

    public String getActOnId() {
        return actOnId;
    }

    public void setActOnId(String actOnId) {
        this.actOnId = actOnId;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Date getActOnDateTime() {
        return actOnDateTime;
    }

    public void setActOnDateTime(Date actOnDateTime) {
        this.actOnDateTime = actOnDateTime;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public int getActOnStatus() {
        return actOnStatus;
    }

    public void setActOnStatus(int actOnStatus) {
        this.actOnStatus = actOnStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountBindId() {
        return accountBindId;
    }

    public void setAccountBindId(String accountBindId) {
        this.accountBindId = accountBindId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actOnRecordId != null ? actOnRecordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actonrecord)) {
            return false;
        }
        Actonrecord other = (Actonrecord) object;
        if ((this.actOnRecordId == null && other.actOnRecordId != null) || (this.actOnRecordId != null && !this.actOnRecordId.equals(other.actOnRecordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Actonrecord[ actOnRecordId=" + actOnRecordId + " ]";
    }
    
}
