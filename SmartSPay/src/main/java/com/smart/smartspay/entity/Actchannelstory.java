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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "actchannelstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actchannelstory.findAll", query = "SELECT a FROM Actchannelstory a"),
    @NamedQuery(name = "Actchannelstory.findByActChannelId", query = "SELECT a FROM Actchannelstory a WHERE a.actChannelId = :actChannelId"),
    @NamedQuery(name = "Actchannelstory.findByAccount1Type", query = "SELECT a FROM Actchannelstory a WHERE a.account1Type = :account1Type"),
    @NamedQuery(name = "Actchannelstory.findByAccount2Type", query = "SELECT a FROM Actchannelstory a WHERE a.account2Type = :account2Type"),
    @NamedQuery(name = "Actchannelstory.findByDealType", query = "SELECT a FROM Actchannelstory a WHERE a.dealType = :dealType"),
    @NamedQuery(name = "Actchannelstory.findByDealRuleId", query = "SELECT a FROM Actchannelstory a WHERE a.dealRuleId = :dealRuleId"),
    @NamedQuery(name = "Actchannelstory.findByPutDate", query = "SELECT a FROM Actchannelstory a WHERE a.putDate = :putDate")})
public class Actchannelstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ActChannelId", nullable = false, length = 40)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String actChannelId;
    @Basic(optional = false)
    @Column(name = "Account1Type", nullable = false, length = 2)
    private String account1Type;
    @Basic(optional = false)
    @Column(name = "Account2Type", nullable = false, length = 2)
    private String account2Type;
    @Basic(optional = false)
    @Column(name = "DealType", nullable = false, length = 2)
    private String dealType;
    @Basic(optional = false)
    @Column(name = "DealRuleId", nullable = false, length = 20)
    private String dealRuleId;
    @Basic(optional = false)
    @Column(name = "PutDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;

    public Actchannelstory() {
    }

    public Actchannelstory(String actChannelId) {
        this.actChannelId = actChannelId;
    }

    public Actchannelstory(String actChannelId, String account1Type, String account2Type, String dealType, String dealRuleId, Date putDate) {
        this.actChannelId = actChannelId;
        this.account1Type = account1Type;
        this.account2Type = account2Type;
        this.dealType = dealType;
        this.dealRuleId = dealRuleId;
        this.putDate = putDate;
    }

    public String getActChannelId() {
        return actChannelId;
    }

    public void setActChannelId(String actChannelId) {
        this.actChannelId = actChannelId;
    }

    public String getAccount1Type() {
        return account1Type;
    }

    public void setAccount1Type(String account1Type) {
        this.account1Type = account1Type;
    }

    public String getAccount2Type() {
        return account2Type;
    }

    public void setAccount2Type(String account2Type) {
        this.account2Type = account2Type;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getDealRuleId() {
        return dealRuleId;
    }

    public void setDealRuleId(String dealRuleId) {
        this.dealRuleId = dealRuleId;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actChannelId != null ? actChannelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actchannelstory)) {
            return false;
        }
        Actchannelstory other = (Actchannelstory) object;
        if ((this.actChannelId == null && other.actChannelId != null) || (this.actChannelId != null && !this.actChannelId.equals(other.actChannelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Actchannelstory[ actChannelId=" + actChannelId + " ]";
    }
    
}
