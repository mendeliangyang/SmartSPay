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
public class DealrulestroryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DealRuleNo", nullable = false, length = 20)
    private String dealRuleNo;
    @Basic(optional = false)
    @Column(name = "SeqId", nullable = false)
    private int seqId;

    public DealrulestroryPK() {
    }

    public DealrulestroryPK(String dealRuleNo, int seqId) {
        this.dealRuleNo = dealRuleNo;
        this.seqId = seqId;
    }

    public String getDealRuleNo() {
        return dealRuleNo;
    }

    public void setDealRuleNo(String dealRuleNo) {
        this.dealRuleNo = dealRuleNo;
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
        hash += (dealRuleNo != null ? dealRuleNo.hashCode() : 0);
        hash += (int) seqId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DealrulestroryPK)) {
            return false;
        }
        DealrulestroryPK other = (DealrulestroryPK) object;
        if ((this.dealRuleNo == null && other.dealRuleNo != null) || (this.dealRuleNo != null && !this.dealRuleNo.equals(other.dealRuleNo))) {
            return false;
        }
        if (this.seqId != other.seqId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.DealrulestroryPK[ dealRuleNo=" + dealRuleNo + ", seqId=" + seqId + " ]";
    }
    
}
