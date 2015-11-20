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
    @NamedQuery(name = "Accountbind.findAll", query = "SELECT a FROM Accountbind a"),
    @NamedQuery(name = "Accountbind.findByAccountBindId", query = "SELECT a FROM Accountbind a WHERE a.accountBindId = :accountBindId"),
    @NamedQuery(name = "Accountbind.findByFromAccountId", query = "SELECT a FROM Accountbind a WHERE a.fromAccountId = :fromAccountId"),
    @NamedQuery(name = "Accountbind.findByToAccountId", query = "SELECT a FROM Accountbind a WHERE a.toAccountId = :toAccountId"),
    @NamedQuery(name = "Accountbind.findByUserId", query = "SELECT a FROM Accountbind a WHERE a.userId = :userId"),
    @NamedQuery(name = "Accountbind.findByPutTime", query = "SELECT a FROM Accountbind a WHERE a.putTime = :putTime"),
    @NamedQuery(name = "Accountbind.findByInvalidTime", query = "SELECT a FROM Accountbind a WHERE a.invalidTime = :invalidTime")})
public class Accountbind implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String accountBindId;
    @Column(length = 40)
    private String fromAccountId;
    @Column(length = 40)
    private String toAccountId;
    @Column(length = 40)
    private String userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date putTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date invalidTime;

    public Accountbind() {
    }

    public Accountbind(String accountBindId) {
        this.accountBindId = accountBindId;
    }

    public String getAccountBindId() {
        return accountBindId;
    }

    public void setAccountBindId(String accountBindId) {
        this.accountBindId = accountBindId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        hash += (accountBindId != null ? accountBindId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountbind)) {
            return false;
        }
        Accountbind other = (Accountbind) object;
        if ((this.accountBindId == null && other.accountBindId != null) || (this.accountBindId != null && !this.accountBindId.equals(other.accountBindId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Accountbind[ accountBindId=" + accountBindId + " ]";
    }
    
}
