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
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumeyearmonth.findAll", query = "SELECT c FROM Consumeyearmonth c"),
    @NamedQuery(name = "Consumeyearmonth.findByConsume", query = "SELECT c FROM Consumeyearmonth c WHERE c.consume = :consume"),
    @NamedQuery(name = "Consumeyearmonth.findByAccountId", query = "SELECT c FROM Consumeyearmonth c WHERE c.accountId = :accountId"),
    @NamedQuery(name = "Consumeyearmonth.findByConsumeType", query = "SELECT c FROM Consumeyearmonth c WHERE c.consumeType = :consumeType"),
    @NamedQuery(name = "Consumeyearmonth.findByMoney", query = "SELECT c FROM Consumeyearmonth c WHERE c.money = :money"),
    @NamedQuery(name = "Consumeyearmonth.findByPutDate", query = "SELECT c FROM Consumeyearmonth c WHERE c.putDate = :putDate"),
    @NamedQuery(name = "Consumeyearmonth.findByTitle", query = "SELECT c FROM Consumeyearmonth c WHERE c.title = :title"),
    @NamedQuery(name = "Consumeyearmonth.findByUserId", query = "SELECT c FROM Consumeyearmonth c WHERE c.userId = :userId")})
public class Consumeyearmonth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String consume;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String accountId;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String consumeType;
    @Basic(optional = false)
    @Column(nullable = false)
    private float money;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String title;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String userId;

    public Consumeyearmonth() {
    }

    public Consumeyearmonth(String consume) {
        this.consume = consume;
    }

    public Consumeyearmonth(String consume, String accountId, String consumeType, float money, Date putDate, String title, String userId) {
        this.consume = consume;
        this.accountId = accountId;
        this.consumeType = consumeType;
        this.money = money;
        this.putDate = putDate;
        this.title = title;
        this.userId = userId;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consume != null ? consume.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumeyearmonth)) {
            return false;
        }
        Consumeyearmonth other = (Consumeyearmonth) object;
        if ((this.consume == null && other.consume != null) || (this.consume != null && !this.consume.equals(other.consume))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Consumeyearmonth[ consume=" + consume + " ]";
    }
    
}
