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
public class DealinterfacePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DealRuleNo", nullable = false, length = 20)
    private String dealRuleNo;
    @Basic(optional = false)
    @Column(name = "DealSeq", nullable = false)
    private int dealSeq;

    public DealinterfacePK() {
    }

    public DealinterfacePK(String dealRuleNo, int dealSeq) {
        this.dealRuleNo = dealRuleNo;
        this.dealSeq = dealSeq;
    }

    public String getDealRuleNo() {
        return dealRuleNo;
    }

    public void setDealRuleNo(String dealRuleNo) {
        this.dealRuleNo = dealRuleNo;
    }

    public int getDealSeq() {
        return dealSeq;
    }

    public void setDealSeq(int dealSeq) {
        this.dealSeq = dealSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealRuleNo != null ? dealRuleNo.hashCode() : 0);
        hash += (int) dealSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DealinterfacePK)) {
            return false;
        }
        DealinterfacePK other = (DealinterfacePK) object;
        if ((this.dealRuleNo == null && other.dealRuleNo != null) || (this.dealRuleNo != null && !this.dealRuleNo.equals(other.dealRuleNo))) {
            return false;
        }
        if (this.dealSeq != other.dealSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.DealinterfacePK[ dealRuleNo=" + dealRuleNo + ", dealSeq=" + dealSeq + " ]";
    }
    
}
