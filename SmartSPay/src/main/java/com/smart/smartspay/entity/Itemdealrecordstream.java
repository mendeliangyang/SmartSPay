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
@Table(name = "itemdealrecordstream", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemdealrecordstream.findAll", query = "SELECT i FROM Itemdealrecordstream i")})
public class Itemdealrecordstream implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StreamId", nullable = false)
    private Integer streamId;
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
    @Column(name = "DealId", length = 40)
    private String dealId;

    public Itemdealrecordstream() {
    }

    public Itemdealrecordstream(Integer streamId) {
        this.streamId = streamId;
    }

    public Itemdealrecordstream(Integer streamId, String itemId, int creditORDebit, String balance, Date dealDealTime) {
        this.streamId = streamId;
        this.itemId = itemId;
        this.creditORDebit = creditORDebit;
        this.balance = balance;
        this.dealDealTime = dealDealTime;
    }

    public Integer getStreamId() {
        return streamId;
    }

    public void setStreamId(Integer streamId) {
        this.streamId = streamId;
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

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (streamId != null ? streamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemdealrecordstream)) {
            return false;
        }
        Itemdealrecordstream other = (Itemdealrecordstream) object;
        if ((this.streamId == null && other.streamId != null) || (this.streamId != null && !this.streamId.equals(other.streamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Itemdealrecordstream[ streamId=" + streamId + " ]";
    }
    
}
