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
@Table(name = "dealrulestrory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealrulestrory.findAll", query = "SELECT d FROM Dealrulestrory d")})
public class Dealrulestrory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DealrulestroryPK dealrulestroryPK;
    @Basic(optional = false)
    @Column(name = "CreditORDebit", nullable = false)
    private int creditORDebit;
    @Basic(optional = false)
    @Column(name = "Scale", nullable = false, length = 8)
    private String scale;
    @Basic(optional = false)
    @Column(name = "ItemIId", nullable = false, length = 40)
    private String itemIId;

    public Dealrulestrory() {
    }

    public Dealrulestrory(DealrulestroryPK dealrulestroryPK) {
        this.dealrulestroryPK = dealrulestroryPK;
    }

    public Dealrulestrory(DealrulestroryPK dealrulestroryPK, int creditORDebit, String scale, String itemIId) {
        this.dealrulestroryPK = dealrulestroryPK;
        this.creditORDebit = creditORDebit;
        this.scale = scale;
        this.itemIId = itemIId;
    }

    public Dealrulestrory(String dealRuleNo, int seqId) {
        this.dealrulestroryPK = new DealrulestroryPK(dealRuleNo, seqId);
    }

    public DealrulestroryPK getDealrulestroryPK() {
        return dealrulestroryPK;
    }

    public void setDealrulestroryPK(DealrulestroryPK dealrulestroryPK) {
        this.dealrulestroryPK = dealrulestroryPK;
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
        hash += (dealrulestroryPK != null ? dealrulestroryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealrulestrory)) {
            return false;
        }
        Dealrulestrory other = (Dealrulestrory) object;
        if ((this.dealrulestroryPK == null && other.dealrulestroryPK != null) || (this.dealrulestroryPK != null && !this.dealrulestroryPK.equals(other.dealrulestroryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealrulestrory[ dealrulestroryPK=" + dealrulestroryPK + " ]";
    }
    
}
