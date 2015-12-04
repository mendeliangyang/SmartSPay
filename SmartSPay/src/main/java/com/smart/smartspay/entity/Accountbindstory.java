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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "accountbindstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountbindstory.findAll", query = "SELECT a FROM Accountbindstory a"),
    @NamedQuery(name = "Accountbindstory.findByAccountBindId", query = "SELECT a FROM Accountbindstory a WHERE a.accountBindId = :accountBindId"),
    @NamedQuery(name = "Accountbindstory.findByFromAccountId", query = "SELECT a FROM Accountbindstory a WHERE a.fromAccountId = :fromAccountId"),
    @NamedQuery(name = "Accountbindstory.findByToAccountId", query = "SELECT a FROM Accountbindstory a WHERE a.toAccountId = :toAccountId"),
    @NamedQuery(name = "Accountbindstory.findByUserId", query = "SELECT a FROM Accountbindstory a WHERE a.userId = :userId"),
    @NamedQuery(name = "Accountbindstory.findByPutTime", query = "SELECT a FROM Accountbindstory a WHERE a.putTime = :putTime"),
    @NamedQuery(name = "Accountbindstory.findByInvalidTime", query = "SELECT a FROM Accountbindstory a WHERE a.invalidTime = :invalidTime")})
public class Accountbindstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AccountBindId", nullable = false, length = 40)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String accountBindId;
    @Column(name = "FromAccountId", length = 40)
    private String fromAccountId;
    @Column(name = "ToAccountId", length = 40)
    private String toAccountId;
    @Column(name = "UserId", length = 40)
    private String userId;
    @Column(name = "PutTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date putTime;
    @Column(name = "InvalidTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invalidTime;

    public Accountbindstory() {
    }

    public Accountbindstory(String accountBindId) {
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
        if (!(object instanceof Accountbindstory)) {
            return false;
        }
        Accountbindstory other = (Accountbindstory) object;
        if ((this.accountBindId == null && other.accountBindId != null) || (this.accountBindId != null && !this.accountBindId.equals(other.accountBindId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Accountbindstory[ accountBindId=" + accountBindId + " ]";
    }
    
}
