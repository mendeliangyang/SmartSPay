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
@Table(name = "itemdealrecord", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemdealrecord.findAll", query = "SELECT i FROM Itemdealrecord i")})
public class Itemdealrecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 20)
    private String itemId;
    @Basic(optional = false)
    @Column(name = "CreditORDebit", nullable = false)
    private int creditORDebit;
    @Basic(optional = false)
    @Column(name = "Balance", nullable = false, length = 20)
    private String balance;
    @Basic(optional = false)
    @Column(name = "DealDealTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDealTime;

    public Itemdealrecord() {
    }

    public Itemdealrecord(String itemId) {
        this.itemId = itemId;
    }

    public Itemdealrecord(String itemId, int creditORDebit, String balance, Date dealDealTime) {
        this.itemId = itemId;
        this.creditORDebit = creditORDebit;
        this.balance = balance;
        this.dealDealTime = dealDealTime;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getCreditORDebit() {
        return creditORDebit;
    }

    public void setCreditORDebit(int creditORDebit) {
        this.creditORDebit = creditORDebit;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Date getDealDealTime() {
        return dealDealTime;
    }

    public void setDealDealTime(Date dealDealTime) {
        this.dealDealTime = dealDealTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemdealrecord)) {
            return false;
        }
        Itemdealrecord other = (Itemdealrecord) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Itemdealrecord[ itemId=" + itemId + " ]";
    }
    
}
