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
@Table(name = "itemstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemstory.findAll", query = "SELECT i FROM Itemstory i")})
public class Itemstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ItemStoryId", nullable = false)
    private Integer itemStoryId;
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 40)
    private String itemId;
    @Basic(optional = false)
    @Column(name = "Itemlevel", nullable = false)
    private int itemlevel;
    @Basic(optional = false)
    @Column(name = "ParentItemId", nullable = false, length = 20)
    private String parentItemId;
    @Column(name = "CreditORDebit")
    private Integer creditORDebit;
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
    @Basic(optional = false)
    @Column(name = "ItemName", nullable = false, length = 40)
    private String itemName;
    @Column(name = "ItemDescribe", length = 100)
    private String itemDescribe;
    @Column(name = "OperationDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDateTime;

    public Itemstory() {
    }

    public Itemstory(Integer itemStoryId) {
        this.itemStoryId = itemStoryId;
    }

    public Itemstory(Integer itemStoryId, String itemId, int itemlevel, String parentItemId, double balance, int accountSeq, Date putItemDate, String itemName) {
        this.itemStoryId = itemStoryId;
        this.itemId = itemId;
        this.itemlevel = itemlevel;
        this.parentItemId = parentItemId;
        this.balance = balance;
        this.accountSeq = accountSeq;
        this.putItemDate = putItemDate;
        this.itemName = itemName;
    }

    public Integer getItemStoryId() {
        return itemStoryId;
    }

    public void setItemStoryId(Integer itemStoryId) {
        this.itemStoryId = itemStoryId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getItemlevel() {
        return itemlevel;
    }

    public void setItemlevel(int itemlevel) {
        this.itemlevel = itemlevel;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Integer getCreditORDebit() {
        return creditORDebit;
    }

    public void setCreditORDebit(Integer creditORDebit) {
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    public Date getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(Date operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemStoryId != null ? itemStoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemstory)) {
            return false;
        }
        Itemstory other = (Itemstory) object;
        if ((this.itemStoryId == null && other.itemStoryId != null) || (this.itemStoryId != null && !this.itemStoryId.equals(other.itemStoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Itemstory[ itemStoryId=" + itemStoryId + " ]";
    }
    
}
