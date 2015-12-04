/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class DealrulestoryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DealRuleId", nullable = false, length = 20)
    private String dealRuleId;
    @Basic(optional = false)
    @Column(name = "SeqId", nullable = false)
    private int seqId;

    public DealrulestoryPK() {
    }

    public DealrulestoryPK(String dealRuleId, int seqId) {
        this.dealRuleId = dealRuleId;
        this.seqId = seqId;
    }

    public String getDealRuleId() {
        return dealRuleId;
    }

    public void setDealRuleId(String dealRuleId) {
        this.dealRuleId = dealRuleId;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealRuleId != null ? dealRuleId.hashCode() : 0);
        hash += (int) seqId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DealrulestoryPK)) {
            return false;
        }
        DealrulestoryPK other = (DealrulestoryPK) object;
        if ((this.dealRuleId == null && other.dealRuleId != null) || (this.dealRuleId != null && !this.dealRuleId.equals(other.dealRuleId))) {
            return false;
        }
        if (this.seqId != other.seqId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.DealrulestoryPK[ dealRuleId=" + dealRuleId + ", seqId=" + seqId + " ]";
    }
    
}
