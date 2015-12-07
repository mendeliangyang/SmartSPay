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
@Table(name = "ledgerstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledgerstory.findAll", query = "SELECT l FROM Ledgerstory l")})
public class Ledgerstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LedgerStoryId", nullable = false)
    private Integer ledgerStoryId;
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
    @Column(name = "PutLedgerDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putLedgerDateTime;
    @Column(name = "OperationDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDateTime;
    @Basic(optional = false)
    @Column(name = "ledgerStatus", nullable = false)
    private int ledgerStatus;

    public Ledgerstory() {
    }

    public Ledgerstory(Integer ledgerStoryId) {
        this.ledgerStoryId = ledgerStoryId;
    }

    public Ledgerstory(Integer ledgerStoryId, String ledgerId, String userId, String userAccountNum, String userAccountIssue, double accountBalance, String itemId, long dealSeq, Date putLedgerDateTime, int ledgerStatus) {
        this.ledgerStoryId = ledgerStoryId;
        this.ledgerId = ledgerId;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.userAccountIssue = userAccountIssue;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealSeq = dealSeq;
        this.putLedgerDateTime = putLedgerDateTime;
        this.ledgerStatus = ledgerStatus;
    }

    public Integer getLedgerStoryId() {
        return ledgerStoryId;
    }

    public void setLedgerStoryId(Integer ledgerStoryId) {
        this.ledgerStoryId = ledgerStoryId;
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
        hash += (ledgerStoryId != null ? ledgerStoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledgerstory)) {
            return false;
        }
        Ledgerstory other = (Ledgerstory) object;
        if ((this.ledgerStoryId == null && other.ledgerStoryId != null) || (this.ledgerStoryId != null && !this.ledgerStoryId.equals(other.ledgerStoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledgerstory[ ledgerStoryId=" + ledgerStoryId + " ]";
    }
    
}
