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
@Table(name = "actchannelstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actchannelstory.findAll", query = "SELECT a FROM Actchannelstory a")})
public class Actchannelstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ActChannelStoryId", nullable = false)
    private Integer actChannelStoryId;
    @Basic(optional = false)
    @Column(name = "ActChannelId", nullable = false, length = 40)
    private String actChannelId;
    @Basic(optional = false)
    @Column(name = "AccountToIssue", nullable = false, length = 2)
    private String accountToIssue;
    @Basic(optional = false)
    @Column(name = "AccountFromIssue", nullable = false, length = 2)
    private String accountFromIssue;
    @Basic(optional = false)
    @Column(name = "DealType", nullable = false, length = 2)
    private String dealType;
    @Basic(optional = false)
    @Column(name = "DealRuleNo", nullable = false, length = 20)
    private String dealRuleNo;
    @Basic(optional = false)
    @Column(name = "PutDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Column(name = "BindMust")
    private Integer bindMust;

    public Actchannelstory() {
    }

    public Actchannelstory(Integer actChannelStoryId) {
        this.actChannelStoryId = actChannelStoryId;
    }

    public Actchannelstory(Integer actChannelStoryId, String actChannelId, String accountToIssue, String accountFromIssue, String dealType, String dealRuleNo, Date putDate) {
        this.actChannelStoryId = actChannelStoryId;
        this.actChannelId = actChannelId;
        this.accountToIssue = accountToIssue;
        this.accountFromIssue = accountFromIssue;
        this.dealType = dealType;
        this.dealRuleNo = dealRuleNo;
        this.putDate = putDate;
    }

    public Integer getActChannelStoryId() {
        return actChannelStoryId;
    }

    public void setActChannelStoryId(Integer actChannelStoryId) {
        this.actChannelStoryId = actChannelStoryId;
    }

    public String getActChannelId() {
        return actChannelId;
    }

    public void setActChannelId(String actChannelId) {
        this.actChannelId = actChannelId;
    }

    public String getAccountToIssue() {
        return accountToIssue;
    }

    public void setAccountToIssue(String accountToIssue) {
        this.accountToIssue = accountToIssue;
    }

    public String getAccountFromIssue() {
        return accountFromIssue;
    }

    public void setAccountFromIssue(String accountFromIssue) {
        this.accountFromIssue = accountFromIssue;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getDealRuleNo() {
        return dealRuleNo;
    }

    public void setDealRuleNo(String dealRuleNo) {
        this.dealRuleNo = dealRuleNo;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public Integer getBindMust() {
        return bindMust;
    }

    public void setBindMust(Integer bindMust) {
        this.bindMust = bindMust;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actChannelStoryId != null ? actChannelStoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actchannelstory)) {
            return false;
        }
        Actchannelstory other = (Actchannelstory) object;
        if ((this.actChannelStoryId == null && other.actChannelStoryId != null) || (this.actChannelStoryId != null && !this.actChannelStoryId.equals(other.actChannelStoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Actchannelstory[ actChannelStoryId=" + actChannelStoryId + " ]";
    }
    
}
