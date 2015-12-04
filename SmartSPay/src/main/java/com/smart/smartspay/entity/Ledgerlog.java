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
@Table(name = "ledgerlog", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledgerlog.findAll", query = "SELECT l FROM Ledgerlog l"),
    @NamedQuery(name = "Ledgerlog.findByLedgerId", query = "SELECT l FROM Ledgerlog l WHERE l.ledgerlogPK.ledgerId = :ledgerId"),
    @NamedQuery(name = "Ledgerlog.findByUserId", query = "SELECT l FROM Ledgerlog l WHERE l.userId = :userId"),
    @NamedQuery(name = "Ledgerlog.findByUserAccountNum", query = "SELECT l FROM Ledgerlog l WHERE l.userAccountNum = :userAccountNum"),
    @NamedQuery(name = "Ledgerlog.findByUserAccountIssue", query = "SELECT l FROM Ledgerlog l WHERE l.userAccountIssue = :userAccountIssue"),
    @NamedQuery(name = "Ledgerlog.findByAccountBalance", query = "SELECT l FROM Ledgerlog l WHERE l.accountBalance = :accountBalance"),
    @NamedQuery(name = "Ledgerlog.findByItemId", query = "SELECT l FROM Ledgerlog l WHERE l.itemId = :itemId"),
    @NamedQuery(name = "Ledgerlog.findByDealSeq", query = "SELECT l FROM Ledgerlog l WHERE l.ledgerlogPK.dealSeq = :dealSeq"),
    @NamedQuery(name = "Ledgerlog.findByDealDate", query = "SELECT l FROM Ledgerlog l WHERE l.dealDate = :dealDate")})
public class Ledgerlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LedgerlogPK ledgerlogPK;
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
    @Column(name = "DealDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDate;

    public Ledgerlog() {
    }

    public Ledgerlog(LedgerlogPK ledgerlogPK) {
        this.ledgerlogPK = ledgerlogPK;
    }

    public Ledgerlog(LedgerlogPK ledgerlogPK, String userId, String userAccountNum, String userAccountIssue, double accountBalance, String itemId, Date dealDate) {
        this.ledgerlogPK = ledgerlogPK;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.userAccountIssue = userAccountIssue;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealDate = dealDate;
    }

    public Ledgerlog(String ledgerId, long dealSeq) {
        this.ledgerlogPK = new LedgerlogPK(ledgerId, dealSeq);
    }

    public LedgerlogPK getLedgerlogPK() {
        return ledgerlogPK;
    }

    public void setLedgerlogPK(LedgerlogPK ledgerlogPK) {
        this.ledgerlogPK = ledgerlogPK;
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

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ledgerlogPK != null ? ledgerlogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledgerlog)) {
            return false;
        }
        Ledgerlog other = (Ledgerlog) object;
        if ((this.ledgerlogPK == null && other.ledgerlogPK != null) || (this.ledgerlogPK != null && !this.ledgerlogPK.equals(other.ledgerlogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledgerlog[ ledgerlogPK=" + ledgerlogPK + " ]";
    }
    
}
