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
@Table(name = "ledger", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledger.findAll", query = "SELECT l FROM Ledger l"),
    @NamedQuery(name = "Ledger.findByLedgerId", query = "SELECT l FROM Ledger l WHERE l.ledgerId = :ledgerId"),
    @NamedQuery(name = "Ledger.findByUserId", query = "SELECT l FROM Ledger l WHERE l.userId = :userId"),
    @NamedQuery(name = "Ledger.findByUserAccountNum", query = "SELECT l FROM Ledger l WHERE l.userAccountNum = :userAccountNum"),
    @NamedQuery(name = "Ledger.findByUserAccountIssue", query = "SELECT l FROM Ledger l WHERE l.userAccountIssue = :userAccountIssue"),
    @NamedQuery(name = "Ledger.findByAccountBalance", query = "SELECT l FROM Ledger l WHERE l.accountBalance = :accountBalance"),
    @NamedQuery(name = "Ledger.findByItemId", query = "SELECT l FROM Ledger l WHERE l.itemId = :itemId"),
    @NamedQuery(name = "Ledger.findByDealSeq", query = "SELECT l FROM Ledger l WHERE l.dealSeq = :dealSeq"),
    @NamedQuery(name = "Ledger.findByPutLedgerDate", query = "SELECT l FROM Ledger l WHERE l.putLedgerDate = :putLedgerDate")})
public class Ledger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LedgerId", nullable = false, length = 40)
    private String ledgerId;
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
    @Column(name = "DealSeq", nullable = false)
    private long dealSeq;
    @Basic(optional = false)
    @Column(name = "PutLedgerDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putLedgerDate;

    public Ledger() {
    }

    public Ledger(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Ledger(String ledgerId, String userId, String userAccountNum, String userAccountIssue, double accountBalance, String itemId, long dealSeq, Date putLedgerDate) {
        this.ledgerId = ledgerId;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.userAccountIssue = userAccountIssue;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealSeq = dealSeq;
        this.putLedgerDate = putLedgerDate;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(String ledgerId) {
        this.ledgerId = ledgerId;
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

    public long getDealSeq() {
        return dealSeq;
    }

    public void setDealSeq(long dealSeq) {
        this.dealSeq = dealSeq;
    }

    public Date getPutLedgerDate() {
        return putLedgerDate;
    }

    public void setPutLedgerDate(Date putLedgerDate) {
        this.putLedgerDate = putLedgerDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ledgerId != null ? ledgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledger)) {
            return false;
        }
        Ledger other = (Ledger) object;
        if ((this.ledgerId == null && other.ledgerId != null) || (this.ledgerId != null && !this.ledgerId.equals(other.ledgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledger[ ledgerId=" + ledgerId + " ]";
    }
    
}
