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
@Table(name = "bankissue", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankissue.findAll", query = "SELECT b FROM Bankissue b")})
public class Bankissue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "BankIssueName", length = 60)
    private String bankIssueName;
    @Column(name = "BankIssueNum", length = 20)
    private String bankIssueNum;
    @Column(name = "BankKindName", length = 40)
    private String bankKindName;
    @Column(name = "BankType", length = 20)
    private String bankType;
    @Column(name = "BankNoLength")
    private Integer bankNoLength;
    @Id
    @Basic(optional = false)
    @Column(name = "BankBin", nullable = false, length = 6)
    private String bankBin;

    public Bankissue() {
    }

    public Bankissue(String bankBin) {
        this.bankBin = bankBin;
    }

    public String getBankIssueName() {
        return bankIssueName;
    }

    public void setBankIssueName(String bankIssueName) {
        this.bankIssueName = bankIssueName;
    }

    public String getBankIssueNum() {
        return bankIssueNum;
    }

    public void setBankIssueNum(String bankIssueNum) {
        this.bankIssueNum = bankIssueNum;
    }

    public String getBankKindName() {
        return bankKindName;
    }

    public void setBankKindName(String bankKindName) {
        this.bankKindName = bankKindName;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getBankNoLength() {
        return bankNoLength;
    }

    public void setBankNoLength(Integer bankNoLength) {
        this.bankNoLength = bankNoLength;
    }

    public String getBankBin() {
        return bankBin;
    }

    public void setBankBin(String bankBin) {
        this.bankBin = bankBin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankBin != null ? bankBin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankissue)) {
            return false;
        }
        Bankissue other = (Bankissue) object;
        if ((this.bankBin == null && other.bankBin != null) || (this.bankBin != null && !this.bankBin.equals(other.bankBin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Bankissue[ bankBin=" + bankBin + " ]";
    }
    
}
