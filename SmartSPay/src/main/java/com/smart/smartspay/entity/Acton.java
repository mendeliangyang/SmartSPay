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
    @NamedQuery(name = "Acton.findAll", query = "SELECT a FROM Acton a"),
    @NamedQuery(name = "Acton.findByActOnId", query = "SELECT a FROM Acton a WHERE a.actOnId = :actOnId"),
    @NamedQuery(name = "Acton.findByAccountBindId", query = "SELECT a FROM Acton a WHERE a.accountBindId = :accountBindId"),
    @NamedQuery(name = "Acton.findByMoney", query = "SELECT a FROM Acton a WHERE a.money = :money"),
    @NamedQuery(name = "Acton.findByActOnDateTime", query = "SELECT a FROM Acton a WHERE a.actOnDateTime = :actOnDateTime"),
    @NamedQuery(name = "Acton.findByLogOnDateTime", query = "SELECT a FROM Acton a WHERE a.logOnDateTime = :logOnDateTime"),
    @NamedQuery(name = "Acton.findByActOnStatus", query = "SELECT a FROM Acton a WHERE a.actOnStatus = :actOnStatus"),
    @NamedQuery(name = "Acton.findByUserId", query = "SELECT a FROM Acton a WHERE a.userId = :userId"),
    @NamedQuery(name = "Acton.findByFromAccountId", query = "SELECT a FROM Acton a WHERE a.fromAccountId = :fromAccountId"),
    @NamedQuery(name = "Acton.findByToAccountId", query = "SELECT a FROM Acton a WHERE a.toAccountId = :toAccountId")})
public class Acton implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String actOnId;
    private String accountBindId;
    private Integer money;
    @Temporal(TemporalType.TIMESTAMP)
    private Date actOnDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date logOnDateTime;
    private Integer actOnStatus;
    private String userId;
    private String fromAccountId;
    private String toAccountId;

    public Acton() {
    }

    public Acton(String actOnId) {
        this.actOnId = actOnId;
    }

    public String getActOnId() {
        return actOnId;
    }

    public void setActOnId(String actOnId) {
        this.actOnId = actOnId;
    }

    public String getAccountBindId() {
        return accountBindId;
    }

    public void setAccountBindId(String accountBindId) {
        this.accountBindId = accountBindId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getActOnDateTime() {
        return actOnDateTime;
    }

    public void setActOnDateTime(Date actOnDateTime) {
        this.actOnDateTime = actOnDateTime;
    }

    public Date getLogOnDateTime() {
        return logOnDateTime;
    }

    public void setLogOnDateTime(Date logOnDateTime) {
        this.logOnDateTime = logOnDateTime;
    }

    public Integer getActOnStatus() {
        return actOnStatus;
    }

    public void setActOnStatus(Integer actOnStatus) {
        this.actOnStatus = actOnStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actOnId != null ? actOnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acton)) {
            return false;
        }
        Acton other = (Acton) object;
        if ((this.actOnId == null && other.actOnId != null) || (this.actOnId != null && !this.actOnId.equals(other.actOnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Acton[ actOnId=" + actOnId + " ]";
    }
    
}
