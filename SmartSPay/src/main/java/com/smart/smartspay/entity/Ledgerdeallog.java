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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ledgerdeallog", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledgerdeallog.findAll", query = "SELECT l FROM Ledgerdeallog l")})
public class Ledgerdeallog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LedgerdeallogPK ledgerdeallogPK;
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false, length = 40)
    private String userId;
    @Basic(optional = false)
    @Column(name = "UserAccountNum", nullable = false, length = 40)
    private String userAccountNum;
    @Basic(optional = false)
    @Column(name = "UserAccountIssue", nullable = false, length = 20)
    private String userAccountIssue;
    @Basic(optional = false)
    @Column(name = "AccountBalance", nullable = false)
    private double accountBalance;
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 20)
    private String itemId;
    @Basic(optional = false)
    @Column(name = "DealDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDateTime;

    public Ledgerdeallog() {
    }

    public Ledgerdeallog(LedgerdeallogPK ledgerdeallogPK) {
        this.ledgerdeallogPK = ledgerdeallogPK;
    }

    public Ledgerdeallog(LedgerdeallogPK ledgerdeallogPK, String userId, String userAccountNum, String userAccountIssue, double accountBalance, String itemId, Date dealDateTime) {
        this.ledgerdeallogPK = ledgerdeallogPK;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.userAccountIssue = userAccountIssue;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealDateTime = dealDateTime;
    }

    public Ledgerdeallog(String ledgerId, long dealSeq) {
        this.ledgerdeallogPK = new LedgerdeallogPK(ledgerId, dealSeq);
    }

    public LedgerdeallogPK getLedgerdeallogPK() {
        return ledgerdeallogPK;
    }

    public void setLedgerdeallogPK(LedgerdeallogPK ledgerdeallogPK) {
        this.ledgerdeallogPK = ledgerdeallogPK;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccountNum() {
        return userAccountNum;
    }

    public void setUserAccountNum(String userAccountNum) {
        this.userAccountNum = userAccountNum;
    }

    public String getUserAccountIssue() {
        return userAccountIssue;
    }

    public void setUserAccountIssue(String userAccountIssue) {
        this.userAccountIssue = userAccountIssue;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Date getDealDateTime() {
        return dealDateTime;
    }

    public void setDealDateTime(Date dealDateTime) {
        this.dealDateTime = dealDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ledgerdeallogPK != null ? ledgerdeallogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledgerdeallog)) {
            return false;
        }
        Ledgerdeallog other = (Ledgerdeallog) object;
        if ((this.ledgerdeallogPK == null && other.ledgerdeallogPK != null) || (this.ledgerdeallogPK != null && !this.ledgerdeallogPK.equals(other.ledgerdeallogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledgerdeallog[ ledgerdeallogPK=" + ledgerdeallogPK + " ]";
    }
    
}
