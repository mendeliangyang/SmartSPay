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
@Table(name = "dealrulestory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealrulestory.findAll", query = "SELECT d FROM Dealrulestory d"),
    @NamedQuery(name = "Dealrulestory.findByDealRuleId", query = "SELECT d FROM Dealrulestory d WHERE d.dealrulestoryPK.dealRuleId = :dealRuleId"),
    @NamedQuery(name = "Dealrulestory.findBySeqId", query = "SELECT d FROM Dealrulestory d WHERE d.dealrulestoryPK.seqId = :seqId"),
    @NamedQuery(name = "Dealrulestory.findByDealTitle", query = "SELECT d FROM Dealrulestory d WHERE d.dealTitle = :dealTitle"),
    @NamedQuery(name = "Dealrulestory.findByBindMust", query = "SELECT d FROM Dealrulestory d WHERE d.bindMust = :bindMust"),
    @NamedQuery(name = "Dealrulestory.findByCreditORDebit", query = "SELECT d FROM Dealrulestory d WHERE d.creditORDebit = :creditORDebit"),
    @NamedQuery(name = "Dealrulestory.findByScale", query = "SELECT d FROM Dealrulestory d WHERE d.scale = :scale")})
public class Dealrulestory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DealrulestoryPK dealrulestoryPK;
    @Basic(optional = false)
    @Column(name = "DealTitle", nullable = false, length = 200)
    private String dealTitle;
    @Basic(optional = false)
    @Column(name = "BindMust", nullable = false)
    private int bindMust;
    @Basic(optional = false)
    @Column(name = "CreditORDebit", nullable = false)
    private int creditORDebit;
    @Basic(optional = false)
    @Column(name = "Scale", nullable = false)
    private double scale;

    public Dealrulestory() {
    }

    public Dealrulestory(DealrulestoryPK dealrulestoryPK) {
        this.dealrulestoryPK = dealrulestoryPK;
    }

    public Dealrulestory(DealrulestoryPK dealrulestoryPK, String dealTitle, int bindMust, int creditORDebit, double scale) {
        this.dealrulestoryPK = dealrulestoryPK;
        this.dealTitle = dealTitle;
        this.bindMust = bindMust;
        this.creditORDebit = creditORDebit;
        this.scale = scale;
    }

    public Dealrulestory(String dealRuleId, int seqId) {
        this.dealrulestoryPK = new DealrulestoryPK(dealRuleId, seqId);
    }

    public DealrulestoryPK getDealrulestoryPK() {
        return dealrulestoryPK;
    }

    public void setDealrulestoryPK(DealrulestoryPK dealrulestoryPK) {
        this.dealrulestoryPK = dealrulestoryPK;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(String dealTitle) {
        this.dealTitle = dealTitle;
    }

    public int getBindMust() {
        return bindMust;
    }

    public void setBindMust(int bindMust) {
        this.bindMust = bindMust;
    }

    public int getCreditORDebit() {
        return creditORDebit;
    }

    public void setCreditORDebit(int creditORDebit) {
        this.creditORDebit = creditORDebit;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealrulestoryPK != null ? dealrulestoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealrulestory)) {
            return false;
        }
        Dealrulestory other = (Dealrulestory) object;
        if ((this.dealrulestoryPK == null && other.dealrulestoryPK != null) || (this.dealrulestoryPK != null && !this.dealrulestoryPK.equals(other.dealrulestoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealrulestory[ dealrulestoryPK=" + dealrulestoryPK + " ]";
    }
    
}
