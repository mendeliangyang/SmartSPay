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
@Table(name = "ledgerdealrecordstream", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledgerdealrecordstream.findAll", query = "SELECT l FROM Ledgerdealrecordstream l")})
public class Ledgerdealrecordstream implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LedgerStreamId", nullable = false)
    private Integer ledgerStreamId;
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
    @Column(name = "AccountBalance", nullable = false, length = 20)
    private String accountBalance;
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 20)
    private String itemId;
    @Basic(optional = false)
    @Column(name = "DealDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDateTime;
    @Column(name = "DealId", length = 40)
    private String dealId;

    public Ledgerdealrecordstream() {
    }

    public Ledgerdealrecordstream(Integer ledgerStreamId) {
        this.ledgerStreamId = ledgerStreamId;
    }

    public Ledgerdealrecordstream(Integer ledgerStreamId, String ledgerId, String userId, String userAccountNum, String accountBalance, String itemId, Date dealDateTime) {
        this.ledgerStreamId = ledgerStreamId;
        this.ledgerId = ledgerId;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.accountBalance = accountBalance;
        this.itemId = itemId;
        this.dealDateTime = dealDateTime;
    }

    public Integer getLedgerStreamId() {
        return ledgerStreamId;
    }

    public void setLedgerStreamId(Integer ledgerStreamId) {
        this.ledgerStreamId = ledgerStreamId;
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

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
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

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ledgerStreamId != null ? ledgerStreamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledgerdealrecordstream)) {
            return false;
        }
        Ledgerdealrecordstream other = (Ledgerdealrecordstream) object;
        if ((this.ledgerStreamId == null && other.ledgerStreamId != null) || (this.ledgerStreamId != null && !this.ledgerStreamId.equals(other.ledgerStreamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledgerdealrecordstream[ ledgerStreamId=" + ledgerStreamId + " ]";
    }
    
}
