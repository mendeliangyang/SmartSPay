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
    @NamedQuery(name = "Dealrule.findAll", query = "SELECT d FROM Dealrule d"),
    @NamedQuery(name = "Dealrule.findByDealRuleId", query = "SELECT d FROM Dealrule d WHERE d.dealrulePK.dealRuleId = :dealRuleId"),
    @NamedQuery(name = "Dealrule.findBySeqId", query = "SELECT d FROM Dealrule d WHERE d.dealrulePK.seqId = :seqId"),
    @NamedQuery(name = "Dealrule.findByDealTitle", query = "SELECT d FROM Dealrule d WHERE d.dealTitle = :dealTitle"),
    @NamedQuery(name = "Dealrule.findByBindMust", query = "SELECT d FROM Dealrule d WHERE d.bindMust = :bindMust"),
    @NamedQuery(name = "Dealrule.findByCreditORDebit", query = "SELECT d FROM Dealrule d WHERE d.creditORDebit = :creditORDebit"),
    @NamedQuery(name = "Dealrule.findByScale", query = "SELECT d FROM Dealrule d WHERE d.scale = :scale")})
public class Dealrule implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DealrulePK dealrulePK;
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

    public Dealrule() {
    }

    public Dealrule(DealrulePK dealrulePK) {
        this.dealrulePK = dealrulePK;
    }

    public Dealrule(DealrulePK dealrulePK, String dealTitle, int bindMust, int creditORDebit, double scale) {
        this.dealrulePK = dealrulePK;
        this.dealTitle = dealTitle;
        this.bindMust = bindMust;
        this.creditORDebit = creditORDebit;
        this.scale = scale;
    }

    public Dealrule(String dealRuleId, int seqId) {
        this.dealrulePK = new DealrulePK(dealRuleId, seqId);
    }

    public DealrulePK getDealrulePK() {
        return dealrulePK;
    }

    public void setDealrulePK(DealrulePK dealrulePK) {
        this.dealrulePK = dealrulePK;
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
