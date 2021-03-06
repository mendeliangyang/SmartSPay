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
@Table(name = "ledgerdealrecord", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ledgerdealrecord.findAll", query = "SELECT l FROM Ledgerdealrecord l")})
public class Ledgerdealrecord implements Serializable {
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
    @Column(name = "Balance", nullable = false, length = 20)
    private String balance;
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 20)
    private String itemId;
    @Basic(optional = false)
    @Column(name = "DealDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDateTime;

    public Ledgerdealrecord() {
    }

    public Ledgerdealrecord(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Ledgerdealrecord(String ledgerId, String userId, String userAccountNum, String balance, String itemId, Date dealDateTime) {
        this.ledgerId = ledgerId;
        this.userId = userId;
        this.userAccountNum = userAccountNum;
        this.balance = balance;
        this.itemId = itemId;
        this.dealDateTime = dealDateTime;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
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
        hash += (ledgerId != null ? ledgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledgerdealrecord)) {
            return false;
        }
        Ledgerdealrecord other = (Ledgerdealrecord) object;
        if ((this.ledgerId == null && other.ledgerId != null) || (this.ledgerId != null && !this.ledgerId.equals(other.ledgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Ledgerdealrecord[ ledgerId=" + ledgerId + " ]";
    }
    
}
