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
@Table(name = "itemlog", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemlog.findAll", query = "SELECT i FROM Itemlog i"),
    @NamedQuery(name = "Itemlog.findByItemId", query = "SELECT i FROM Itemlog i WHERE i.itemlogPK.itemId = :itemId"),
    @NamedQuery(name = "Itemlog.findByLevel", query = "SELECT i FROM Itemlog i WHERE i.level = :level"),
    @NamedQuery(name = "Itemlog.findByParentItemId", query = "SELECT i FROM Itemlog i WHERE i.parentItemId = :parentItemId"),
    @NamedQuery(name = "Itemlog.findByCreditORDebit", query = "SELECT i FROM Itemlog i WHERE i.creditORDebit = :creditORDebit"),
    @NamedQuery(name = "Itemlog.findByBalance", query = "SELECT i FROM Itemlog i WHERE i.balance = :balance"),
    @NamedQuery(name = "Itemlog.findByAccountSeq", query = "SELECT i FROM Itemlog i WHERE i.itemlogPK.accountSeq = :accountSeq"),
    @NamedQuery(name = "Itemlog.findByDealTime", query = "SELECT i FROM Itemlog i WHERE i.dealTime = :dealTime")})
public class Itemlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemlogPK itemlogPK;
    @Basic(optional = false)
    @Column(name = "level", nullable = false)
    private int level;
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
    @Column(name = "DealTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealTime;

    public Itemlog() {
    }

    public Itemlog(ItemlogPK itemlogPK) {
        this.itemlogPK = itemlogPK;
    }

    public Itemlog(ItemlogPK itemlogPK, int level, String parentItemId, int creditORDebit, double balance, Date dealTime) {
        this.itemlogPK = itemlogPK;
        this.level = level;
        this.parentItemId = parentItemId;
        this.creditORDebit = creditORDebit;
        this.balance = balance;
        this.dealTime = dealTime;
    }

    public Itemlog(String itemId, int accountSeq) {
        this.itemlogPK = new ItemlogPK(itemId, accountSeq);
    }

    public ItemlogPK getItemlogPK() {
        return itemlogPK;
    }

    public void setItemlogPK(ItemlogPK itemlogPK) {
        this.itemlogPK = itemlogPK;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemlogPK != null ? itemlogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemlog)) {
            return false;
        }
        Itemlog other = (Itemlog) object;
        if ((this.itemlogPK == null && other.itemlogPK != null) || (this.itemlogPK != null && !this.itemlogPK.equals(other.itemlogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Itemlog[ itemlogPK=" + itemlogPK + " ]";
    }
    
}
