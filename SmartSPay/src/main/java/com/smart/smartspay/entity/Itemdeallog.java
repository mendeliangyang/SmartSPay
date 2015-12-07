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
@Table(name = "itemdeallog", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemdeallog.findAll", query = "SELECT i FROM Itemdeallog i")})
public class Itemdeallog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemdeallogPK itemdeallogPK;
    @Basic(optional = false)
    @Column(name = "ParentItemId", nullable = false, length = 20)
    private String parentItemId;
    @Basic(optional = false)
    @Column(name = "CreditORDebit", nullable = false)
    private int creditORDebit;
    @Basic(optional = false)
    @Column(name = "Balance", nullable = false)
    private double balance;
    @Basic(optional = false)
    @Column(name = "DealDealTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDealTime;

    public Itemdeallog() {
    }

    public Itemdeallog(ItemdeallogPK itemdeallogPK) {
        this.itemdeallogPK = itemdeallogPK;
    }

    public Itemdeallog(ItemdeallogPK itemdeallogPK, String parentItemId, int creditORDebit, double balance, Date dealDealTime) {
        this.itemdeallogPK = itemdeallogPK;
        this.parentItemId = parentItemId;
        this.creditORDebit = creditORDebit;
        this.balance = balance;
        this.dealDealTime = dealDealTime;
    }

    public Itemdeallog(String itemId, int accountSeq) {
        this.itemdeallogPK = new ItemdeallogPK(itemId, accountSeq);
    }

    public ItemdeallogPK getItemdeallogPK() {
        return itemdeallogPK;
    }

    public void setItemdeallogPK(ItemdeallogPK itemdeallogPK) {
        this.itemdeallogPK = itemdeallogPK;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public int getCreditORDebit() {
        return creditORDebit;
    }

    public void setCreditORDebit(int creditORDebit) {
        this.creditORDebit = creditORDebit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
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
        hash += (itemdeallogPK != null ? itemdeallogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemdeallog)) {
            return false;
        }
        Itemdeallog other = (Itemdeallog) object;
        if ((this.itemdeallogPK == null && other.itemdeallogPK != null) || (this.itemdeallogPK != null && !this.itemdeallogPK.equals(other.itemdeallogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Itemdeallog[ itemdeallogPK=" + itemdeallogPK + " ]";
    }
    
}
