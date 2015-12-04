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
@Table(name = "actonstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actonstory.findAll", query = "SELECT a FROM Actonstory a"),
    @NamedQuery(name = "Actonstory.findByActOnLogId", query = "SELECT a FROM Actonstory a WHERE a.actOnLogId = :actOnLogId"),
    @NamedQuery(name = "Actonstory.findByActOnId", query = "SELECT a FROM Actonstory a WHERE a.actOnId = :actOnId"),
    @NamedQuery(name = "Actonstory.findByAccountBindId", query = "SELECT a FROM Actonstory a WHERE a.accountBindId = :accountBindId"),
    @NamedQuery(name = "Actonstory.findByMoney", query = "SELECT a FROM Actonstory a WHERE a.money = :money"),
    @NamedQuery(name = "Actonstory.findByActOnDateTime", query = "SELECT a FROM Actonstory a WHERE a.actOnDateTime = :actOnDateTime"),
    @NamedQuery(name = "Actonstory.findByLogOnDateTime", query = "SELECT a FROM Actonstory a WHERE a.logOnDateTime = :logOnDateTime"),
    @NamedQuery(name = "Actonstory.findByActOnStatus", query = "SELECT a FROM Actonstory a WHERE a.actOnStatus = :actOnStatus"),
    @NamedQuery(name = "Actonstory.findByUserId", query = "SELECT a FROM Actonstory a WHERE a.userId = :userId"),
    @NamedQuery(name = "Actonstory.findByFromAccountId", query = "SELECT a FROM Actonstory a WHERE a.fromAccountId = :fromAccountId"),
    @NamedQuery(name = "Actonstory.findByToAccountId", query = "SELECT a FROM Actonstory a WHERE a.toAccountId = :toAccountId")})
public class Actonstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ActOnLogId", nullable = false)
    private Integer actOnLogId;
    @Basic(optional = false)
    @Column(name = "ActOnId", nullable = false, length = 40)
    private String actOnId;
    @Column(name = "AccountBindId", length = 40)
    private String accountBindId;
    @Column(name = "Money")
    private Integer money;
    @Column(name = "ActOnDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actOnDateTime;
    @Column(name = "LogOnDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logOnDateTime;
    @Column(name = "ActOnStatus")
    private Integer actOnStatus;
    @Column(name = "UserId", length = 40)
    private String userId;
    @Column(name = "FromAccountId", length = 40)
    private String fromAccountId;
    @Column(name = "ToAccountId", length = 40)
    private String toAccountId;

    public Actonstory() {
    }

    public Actonstory(Integer actOnLogId) {
        this.actOnLogId = actOnLogId;
    }

    public Actonstory(Integer actOnLogId, String actOnId) {
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
        if (!(object instanceof Actonstory)) {
            return false;
        }
        Actonstory other = (Actonstory) object;
        if ((this.actOnLogId == null && other.actOnLogId != null) || (this.actOnLogId != null && !this.actOnLogId.equals(other.actOnLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Actonstory[ actOnLogId=" + actOnLogId + " ]";
    }
    
}
