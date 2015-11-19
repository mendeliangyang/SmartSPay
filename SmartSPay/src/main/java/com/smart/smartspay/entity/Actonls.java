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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Actonls.findAll", query = "SELECT a FROM Actonls a"),
    @NamedQuery(name = "Actonls.findByActOnLogId", query = "SELECT a FROM Actonls a WHERE a.actOnLogId = :actOnLogId"),
    @NamedQuery(name = "Actonls.findByActOnId", query = "SELECT a FROM Actonls a WHERE a.actOnId = :actOnId"),
    @NamedQuery(name = "Actonls.findByAccountBindId", query = "SELECT a FROM Actonls a WHERE a.accountBindId = :accountBindId"),
    @NamedQuery(name = "Actonls.findByMoney", query = "SELECT a FROM Actonls a WHERE a.money = :money"),
    @NamedQuery(name = "Actonls.findByActOnDateTime", query = "SELECT a FROM Actonls a WHERE a.actOnDateTime = :actOnDateTime"),
    @NamedQuery(name = "Actonls.findByLogOnDateTime", query = "SELECT a FROM Actonls a WHERE a.logOnDateTime = :logOnDateTime"),
    @NamedQuery(name = "Actonls.findByActOnStatus", query = "SELECT a FROM Actonls a WHERE a.actOnStatus = :actOnStatus"),
    @NamedQuery(name = "Actonls.findByUserId", query = "SELECT a FROM Actonls a WHERE a.userId = :userId"),
    @NamedQuery(name = "Actonls.findByFromAccountId", query = "SELECT a FROM Actonls a WHERE a.fromAccountId = :fromAccountId"),
    @NamedQuery(name = "Actonls.findByToAccountId", query = "SELECT a FROM Actonls a WHERE a.toAccountId = :toAccountId")})
public class Actonls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer actOnLogId;
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

    public Actonls() {
    }

    public Actonls(Integer actOnLogId) {
        this.actOnLogId = actOnLogId;
    }

    public Actonls(Integer actOnLogId, String actOnId) {
        this.actOnLogId = actOnLogId;
        this.actOnId = actOnId;
    }

    public Integer getActOnLogId() {
        return actOnLogId;
    }

    public void setActOnLogId(Integer actOnLogId) {
        this.actOnLogId = actOnLogId;
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
        hash += (actOnLogId != null ? actOnLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actonls)) {
            return false;
        }
        Actonls other = (Actonls) object;
        if ((this.actOnLogId == null && other.actOnLogId != null) || (this.actOnLogId != null && !this.actOnLogId.equals(other.actOnLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Actonls[ actOnLogId=" + actOnLogId + " ]";
    }
    
}
