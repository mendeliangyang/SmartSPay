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
@Table(name = "item", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemId", query = "SELECT i FROM Item i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Item.findByLevel", query = "SELECT i FROM Item i WHERE i.level = :level"),
    @NamedQuery(name = "Item.findByParentItemId", query = "SELECT i FROM Item i WHERE i.parentItemId = :parentItemId"),
    @NamedQuery(name = "Item.findByCreditORDebit", query = "SELECT i FROM Item i WHERE i.creditORDebit = :creditORDebit"),
    @NamedQuery(name = "Item.findByBalance", query = "SELECT i FROM Item i WHERE i.balance = :balance"),
    @NamedQuery(name = "Item.findByAccountSeq", query = "SELECT i FROM Item i WHERE i.accountSeq = :accountSeq"),
    @NamedQuery(name = "Item.findByPutItemDate", query = "SELECT i FROM Item i WHERE i.putItemDate = :putItemDate")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 20)
    private String itemId;
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
    @Column(name = "AccountSeq", nullable = false)
    private int accountSeq;
    @Basic(optional = false)
    @Column(name = "PutItemDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putItemDate;

    public Item() {
    }

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public Item(String itemId, int level, String parentItemId, int creditORDebit, double balance, int accountSeq, Date putItemDate) {
        this.itemId = itemId;
        this.level = level;
        this.parentItemId = parentItemId;
        this.creditORDebit = creditORDebit;
        this.balance = balance;
        this.accountSeq = accountSeq;
        this.putItemDate = putItemDate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public int getAccountSeq() {
        return accountSeq;
    }

    public void setAccountSeq(int accountSeq) {
        this.accountSeq = accountSeq;
    }

    public Date getPutItemDate() {
        return putItemDate;
    }

    public void setPutItemDate(Date putItemDate) {
        this.putItemDate = putItemDate;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Item[ itemId=" + itemId + " ]";
    }
    
}
