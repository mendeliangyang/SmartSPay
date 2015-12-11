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
    @NamedQuery(name = "Ledger.findAll", query = "SELECT l FROM Ledger l")})
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
    @Column(name = "AccountNum", nullable = false, length = 40)
    private String accountNum;
    @Basic(optional = false)
    @Column(name = "AccountIssue", nullable = false, length = 2)
    private String accountIssue;
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
    @Column(name = "PutLedgerDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putLedgerDateTime;
    @Basic(optional = false)
    @Column(name = "OperationDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDateTime;
    @Basic(optional = false)
    @Column(name = "ledgerStatus", nullable = false)
    private int ledgerStatus;

    public Ledger() {
    }

    public Ledger(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Ledger(String ledgerId, String userId, String accountNum, String accountIssue, double accountBalance, String itemId, long dealSeq, Date putLedgerDateTime, Date operationDateTime, int ledgerStatus) {
        this.ledgerId = ledgerId;
        this.userId = userId;
        this.accountNum = accountNum;
        this.accountIssue = accountIssue;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealSeq = dealSeq;
        this.putLedgerDateTime = putLedgerDateTime;
        this.operationDateTime = operationDateTime;
        this.ledgerStatus = ledgerStatus;
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

    public Date getPutLedgerDateTime() {
        return putLedgerDateTime;
    }

    public void setPutLedgerDateTime(Date putLedgerDateTime) {
        this.putLedgerDateTime = putLedgerDateTime;
    }

    public Date getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(Date operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    public int getLedgerStatus() {
        return ledgerStatus;
    }

    public void setLedgerStatus(int ledgerStatus) {
        this.ledgerStatus = ledgerStatus;
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
