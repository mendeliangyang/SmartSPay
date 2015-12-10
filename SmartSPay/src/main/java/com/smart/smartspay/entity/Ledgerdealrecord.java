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
@Table(name = "ledgerdealrecord", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledgerdealrecord.findAll", query = "SELECT l FROM Ledgerdealrecord l")})
public class Ledgerdealrecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LedgerdealrecordPK ledgerdealrecordPK;
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

    public Ledgerdealrecord() {
    }

    public Ledgerdealrecord(LedgerdealrecordPK ledgerdealrecordPK) {
        this.ledgerdealrecordPK = ledgerdealrecordPK;
    }

    public Ledgerdealrecord(LedgerdealrecordPK ledgerdealrecordPK, String userId, String userAccountNum, String userAccountIssue, double accountBalance, String itemId, Date dealDateTime) {
        this.ledgerdealrecordPK = ledgerdealrecordPK;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.userAccountIssue = userAccountIssue;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealDateTime = dealDateTime;
    }

    public Ledgerdealrecord(String ledgerId, long dealSeq) {
        this.ledgerdealrecordPK = new LedgerdealrecordPK(ledgerId, dealSeq);
    }

    public LedgerdealrecordPK getLedgerdealrecordPK() {
        return ledgerdealrecordPK;
    }

    public void setLedgerdealrecordPK(LedgerdealrecordPK ledgerdealrecordPK) {
        this.ledgerdealrecordPK = ledgerdealrecordPK;
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
        hash += (ledgerdealrecordPK != null ? ledgerdealrecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledgerdealrecord)) {
            return false;
        }
        Ledgerdealrecord other = (Ledgerdealrecord) object;
        if ((this.ledgerdealrecordPK == null && other.ledgerdealrecordPK != null) || (this.ledgerdealrecordPK != null && !this.ledgerdealrecordPK.equals(other.ledgerdealrecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledgerdealrecord[ ledgerdealrecordPK=" + ledgerdealrecordPK + " ]";
    }
    
}
