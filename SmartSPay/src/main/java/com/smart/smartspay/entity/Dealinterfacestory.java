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
@Table(name = "dealinterfacestory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealinterfacestory.findAll", query = "SELECT d FROM Dealinterfacestory d")})
public class Dealinterfacestory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DealinterfacestoryPK dealinterfacestoryPK;
    @Basic(optional = false)
    @Column(name = "Scale", nullable = false)
    private double scale;
    @Basic(optional = false)
    @Column(name = "ReceiveAccount", nullable = false, length = 40)
    private String receiveAccount;
    @Column(name = "DealParameter1", length = 40)
    private String dealParameter1;
    @Column(name = "DealParameter2", length = 100)
    private String dealParameter2;
    @Column(name = "DealParameter3", length = 100)
    private String dealParameter3;
    @Column(name = "DealParameter4", length = 200)
    private String dealParameter4;
    @Column(name = "DealParameter5", length = 200)
    private String dealParameter5;
    @Column(name = "DealParameter6", length = 400)
    private String dealParameter6;
    @Column(name = "DealParameter7", length = 400)
    private String dealParameter7;
    @Column(name = "DealParameter8", length = 400)
    private String dealParameter8;
    @Column(name = "DealParameter9", length = 400)
    private String dealParameter9;

    public Dealinterfacestory() {
    }

    public Dealinterfacestory(DealinterfacestoryPK dealinterfacestoryPK) {
        this.dealinterfacestoryPK = dealinterfacestoryPK;
    }

    public Dealinterfacestory(DealinterfacestoryPK dealinterfacestoryPK, double scale, String receiveAccount) {
        this.dealinterfacestoryPK = dealinterfacestoryPK;
        this.scale = scale;
        this.receiveAccount = receiveAccount;
    }

    public Dealinterfacestory(String dealRuleNo, int dealSeq) {
        this.dealinterfacestoryPK = new DealinterfacestoryPK(dealRuleNo, dealSeq);
    }

    public DealinterfacestoryPK getDealinterfacestoryPK() {
        return dealinterfacestoryPK;
    }

    public void setDealinterfacestoryPK(DealinterfacestoryPK dealinterfacestoryPK) {
        this.dealinterfacestoryPK = dealinterfacestoryPK;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getDealParameter1() {
        return dealParameter1;
    }

    public void setDealParameter1(String dealParameter1) {
        this.dealParameter1 = dealParameter1;
    }

    public String getDealParameter2() {
        return dealParameter2;
    }

    public void setDealParameter2(String dealParameter2) {
        this.dealParameter2 = dealParameter2;
    }

    public String getDealParameter3() {
        return dealParameter3;
    }

    public void setDealParameter3(String dealParameter3) {
        this.dealParameter3 = dealParameter3;
    }

    public String getDealParameter4() {
        return dealParameter4;
    }

    public void setDealParameter4(String dealParameter4) {
        this.dealParameter4 = dealParameter4;
    }

    public String getDealParameter5() {
        return dealParameter5;
    }

    public void setDealParameter5(String dealParameter5) {
        this.dealParameter5 = dealParameter5;
    }

    public String getDealParameter6() {
        return dealParameter6;
    }

    public void setDealParameter6(String dealParameter6) {
        this.dealParameter6 = dealParameter6;
    }

    public String getDealParameter7() {
        return dealParameter7;
    }

    public void setDealParameter7(String dealParameter7) {
        this.dealParameter7 = dealParameter7;
    }

    public String getDealParameter8() {
        return dealParameter8;
    }

    public void setDealParameter8(String dealParameter8) {
        this.dealParameter8 = dealParameter8;
    }

    public String getDealParameter9() {
        return dealParameter9;
    }

    public void setDealParameter9(String dealParameter9) {
        this.dealParameter9 = dealParameter9;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealinterfacestoryPK != null ? dealinterfacestoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealinterfacestory)) {
            return false;
        }
        Dealinterfacestory other = (Dealinterfacestory) object;
        if ((this.dealinterfacestoryPK == null && other.dealinterfacestoryPK != null) || (this.dealinterfacestoryPK != null && !this.dealinterfacestoryPK.equals(other.dealinterfacestoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealinterfacestory[ dealinterfacestoryPK=" + dealinterfacestoryPK + " ]";
    }
    
}
