/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "dealinterface", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealinterface.findAll", query = "SELECT d FROM Dealinterface d"),
    @NamedQuery(name = "Dealinterface.findByDealRuleId", query = "SELECT d FROM Dealinterface d WHERE d.dealRuleId = :dealRuleId"),
    @NamedQuery(name = "Dealinterface.findByScale", query = "SELECT d FROM Dealinterface d WHERE d.scale = :scale"),
    @NamedQuery(name = "Dealinterface.findByReceive", query = "SELECT d FROM Dealinterface d WHERE d.receive = :receive"),
    @NamedQuery(name = "Dealinterface.findByDealParameter1", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter1 = :dealParameter1"),
    @NamedQuery(name = "Dealinterface.findByDealParameter2", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter2 = :dealParameter2"),
    @NamedQuery(name = "Dealinterface.findByDealParameter3", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter3 = :dealParameter3"),
    @NamedQuery(name = "Dealinterface.findByDealParameter4", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter4 = :dealParameter4"),
    @NamedQuery(name = "Dealinterface.findByDealParameter5", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter5 = :dealParameter5"),
    @NamedQuery(name = "Dealinterface.findByDealParameter6", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter6 = :dealParameter6"),
    @NamedQuery(name = "Dealinterface.findByDealParameter7", query = "SELECT d FROM Dealinterface d WHERE d.dealParameter7 = :dealParameter7")})
public class Dealinterface implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DealRuleId", nullable = false, length = 20)
    private String dealRuleId;
    @Basic(optional = false)
    @Column(name = "Scale", nullable = false)
    private double scale;
    @Basic(optional = false)
    @Column(name = "Receive", nullable = false, length = 40)
    private String receive;
    @Basic(optional = false)
    @Column(name = "DealParameter1", nullable = false, length = 40)
    private String dealParameter1;
    @Column(name = "DealParameter2", length = 100)
    private String dealParameter2;
    @Column(name = "DealParameter3", length = 100)
    private String dealParameter3;
    @Column(name = "DealParameter4", length = 200)
    private String dealParameter4;
    @Column(name = "DealParameter5", length = 200)
    private String dealParameter5;
    @Column(name = "DealParameter6", length = 40)
    private String dealParameter6;
    @Column(name = "DealParameter7", length = 40)
    private String dealParameter7;

    public Dealinterface() {
    }

    public Dealinterface(String dealRuleId) {
        this.dealRuleId = dealRuleId;
    }

    public Dealinterface(String dealRuleId, double scale, String receive, String dealParameter1) {
        this.dealRuleId = dealRuleId;
        this.scale = scale;
        this.receive = receive;
        this.dealParameter1 = dealParameter1;
    }

    public String getDealRuleId() {
        return dealRuleId;
    }

    public void setDealRuleId(String dealRuleId) {
        this.dealRuleId = dealRuleId;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealRuleId != null ? dealRuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealinterface)) {
            return false;
        }
        Dealinterface other = (Dealinterface) object;
        if ((this.dealRuleId == null && other.dealRuleId != null) || (this.dealRuleId != null && !this.dealRuleId.equals(other.dealRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealinterface[ dealRuleId=" + dealRuleId + " ]";
    }
    
}
