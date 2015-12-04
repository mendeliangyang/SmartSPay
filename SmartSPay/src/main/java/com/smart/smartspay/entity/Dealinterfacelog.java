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
@Table(name = "dealinterfacelog", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealinterfacelog.findAll", query = "SELECT d FROM Dealinterfacelog d"),
    @NamedQuery(name = "Dealinterfacelog.findByDealRuleId", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealRuleId = :dealRuleId"),
    @NamedQuery(name = "Dealinterfacelog.findByDealTotal", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealTotal = :dealTotal"),
    @NamedQuery(name = "Dealinterfacelog.findByScale", query = "SELECT d FROM Dealinterfacelog d WHERE d.scale = :scale"),
    @NamedQuery(name = "Dealinterfacelog.findByReceive", query = "SELECT d FROM Dealinterfacelog d WHERE d.receive = :receive"),
    @NamedQuery(name = "Dealinterfacelog.findByDealDescribe", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealDescribe = :dealDescribe"),
    @NamedQuery(name = "Dealinterfacelog.findByDealDate", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealDate = :dealDate"),
    @NamedQuery(name = "Dealinterfacelog.findByUserId", query = "SELECT d FROM Dealinterfacelog d WHERE d.userId = :userId"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter1", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter1 = :dealParameter1"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter2", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter2 = :dealParameter2"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter3", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter3 = :dealParameter3"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter4", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter4 = :dealParameter4"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter5", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter5 = :dealParameter5"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter6", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter6 = :dealParameter6"),
    @NamedQuery(name = "Dealinterfacelog.findByDealParameter7", query = "SELECT d FROM Dealinterfacelog d WHERE d.dealParameter7 = :dealParameter7")})
public class Dealinterfacelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DealRuleId", nullable = false, length = 20)
    private String dealRuleId;
    @Basic(optional = false)
    @Column(name = "DealTotal", nullable = false)
    private double dealTotal;
    @Basic(optional = false)
    @Column(name = "Scale", nullable = false)
    private double scale;
    @Basic(optional = false)
    @Column(name = "Receive", nullable = false, length = 40)
    private String receive;
    @Basic(optional = false)
    @Column(name = "DealDescribe", nullable = false, length = 200)
    private String dealDescribe;
    @Basic(optional = false)
    @Column(name = "DealDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealDate;
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false, length = 40)
    private String userId;
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
    @Column(name = "DealParameter6", length = 40)
    private String dealParameter6;
    @Column(name = "DealParameter7", length = 40)
    private String dealParameter7;

    public Dealinterfacelog() {
    }

    public Dealinterfacelog(String dealRuleId) {
        this.dealRuleId = dealRuleId;
    }

    public Dealinterfacelog(String dealRuleId, double dealTotal, double scale, String receive, String dealDescribe, Date dealDate, String userId) {
        this.dealRuleId = dealRuleId;
        this.dealTotal = dealTotal;
        this.scale = scale;
        this.receive = receive;
        this.dealDescribe = dealDescribe;
        this.dealDate = dealDate;
        this.userId = userId;
    }

    public String getDealRuleId() {
        return dealRuleId;
    }

    public void setDealRuleId(String dealRuleId) {
        this.dealRuleId = dealRuleId;
    }

    public double getDealTotal() {
        return dealTotal;
    }

    public void setDealTotal(double dealTotal) {
        this.dealTotal = dealTotal;
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

    public String getDealDescribe() {
        return dealDescribe;
    }

    public void setDealDescribe(String dealDescribe) {
        this.dealDescribe = dealDescribe;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        if (!(object instanceof Dealinterfacelog)) {
            return false;
        }
        Dealinterfacelog other = (Dealinterfacelog) object;
        if ((this.dealRuleId == null && other.dealRuleId != null) || (this.dealRuleId != null && !this.dealRuleId.equals(other.dealRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealinterfacelog[ dealRuleId=" + dealRuleId + " ]";
    }
    
}
