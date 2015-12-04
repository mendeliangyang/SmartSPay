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
@Table(name = "dealtype", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealtype.findAll", query = "SELECT d FROM Dealtype d"),
    @NamedQuery(name = "Dealtype.findByDealTypeId", query = "SELECT d FROM Dealtype d WHERE d.dealTypeId = :dealTypeId"),
    @NamedQuery(name = "Dealtype.findByDealTypeDescribe", query = "SELECT d FROM Dealtype d WHERE d.dealTypeDescribe = :dealTypeDescribe")})
public class Dealtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DealTypeId", nullable = false, length = 2)
    private String dealTypeId;
    @Basic(optional = false)
    @Column(name = "DealTypeDescribe", nullable = false, length = 40)
    private String dealTypeDescribe;

    public Dealtype() {
    }

    public Dealtype(String dealTypeId) {
        this.dealTypeId = dealTypeId;
    }

    public Dealtype(String dealTypeId, String dealTypeDescribe) {
        this.dealTypeId = dealTypeId;
        this.dealTypeDescribe = dealTypeDescribe;
    }

    public String getDealTypeId() {
        return dealTypeId;
    }

    public void setDealTypeId(String dealTypeId) {
        this.dealTypeId = dealTypeId;
    }

    public String getDealTypeDescribe() {
        return dealTypeDescribe;
    }

    public void setDealTypeDescribe(String dealTypeDescribe) {
        this.dealTypeDescribe = dealTypeDescribe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealTypeId != null ? dealTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealtype)) {
            return false;
        }
        Dealtype other = (Dealtype) object;
        if ((this.dealTypeId == null && other.dealTypeId != null) || (this.dealTypeId != null && !this.dealTypeId.equals(other.dealTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Dealtype[ dealTypeId=" + dealTypeId + " ]";
    }
    
}
