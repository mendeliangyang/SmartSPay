/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "dealrule", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealrule.findAll", query = "SELECT d FROM Dealrule d")})
public class Dealrule implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DealrulePK dealrulePK;
    @Basic(optional = false)
    @Column(name = "CreditORDebit", nullable = false)
    private int creditORDebit;
    @Basic(optional = false)
    @Column(name = "Scale", nullable = false, length = 8)
    private String scale;
    @Basic(optional = false)
    @Column(name = "ItemIId", nullable = false, length = 40)
    private String itemIId;

    public Dealrule() {
    }

    public Dealrule(DealrulePK dealrulePK) {
        this.dealrulePK = dealrulePK;
    }

    public Dealrule(DealrulePK dealrulePK, int creditORDebit, String scale, String itemIId) {
        this.dealrulePK = dealrulePK;
        this.creditORDebit = creditORDebit;
        this.scale = scale;
        this.itemIId = itemIId;
    }

    public Dealrule(String dealRuleNo, int seqId) {
        this.dealrulePK = new DealrulePK(dealRuleNo, seqId);
    }

    public DealrulePK getDealrulePK() {
        return dealrulePK;
    }

    public void setDealrulePK(DealrulePK dealrulePK) {
        this.dealrulePK = dealrulePK;
    }

    public int getCreditORDebit() {
        return creditORDebit;
    }

    public void setCreditORDebit(int creditORDebit) {
        this.creditORDebit = creditORDebit;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getItemIId() {
        return itemIId;
    }

    public void setItemIId(String itemIId) {
        this.itemIId = itemIId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealrulePK != null ? dealrulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealrule)) {
            return false;
        }
        Dealrule other = (Dealrule) object;
        if ((this.dealrulePK == null && other.dealrulePK != null) || (this.dealrulePK != null && !this.dealrulePK.equals(other.dealrulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealrule[ dealrulePK=" + dealrulePK + " ]";
    }
    
}
