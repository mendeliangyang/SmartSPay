/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paychannel.findAll", query = "SELECT p FROM Paychannel p"),
    @NamedQuery(name = "Paychannel.findByPayChannlId", query = "SELECT p FROM Paychannel p WHERE p.payChannlId = :payChannlId"),
    @NamedQuery(name = "Paychannel.findByPayType", query = "SELECT p FROM Paychannel p WHERE p.payType = :payType"),
    @NamedQuery(name = "Paychannel.findByCertificateType", query = "SELECT p FROM Paychannel p WHERE p.certificateType = :certificateType"),
    @NamedQuery(name = "Paychannel.findByAccountKind", query = "SELECT p FROM Paychannel p WHERE p.accountKind = :accountKind"),
    @NamedQuery(name = "Paychannel.findByAccountName", query = "SELECT p FROM Paychannel p WHERE p.accountName = :accountName"),
    @NamedQuery(name = "Paychannel.findByDescription", query = "SELECT p FROM Paychannel p WHERE p.description = :description")})
public class Paychannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String payChannlId;
    private Integer payType;
    private Integer certificateType;
    private Integer accountKind;
    private String accountName;
    private String description;

    public Paychannel() {
    }

    public Paychannel(String payChannlId) {
        this.payChannlId = payChannlId;
    }

    public String getPayChannlId() {
        return payChannlId;
    }

    public void setPayChannlId(String payChannlId) {
        this.payChannlId = payChannlId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public Integer getAccountKind() {
        return accountKind;
    }

    public void setAccountKind(Integer accountKind) {
        this.accountKind = accountKind;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payChannlId != null ? payChannlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paychannel)) {
            return false;
        }
        Paychannel other = (Paychannel) object;
        if ((this.payChannlId == null && other.payChannlId != null) || (this.payChannlId != null && !this.payChannlId.equals(other.payChannlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Paychannel[ payChannlId=" + payChannlId + " ]";
    }
    
}
