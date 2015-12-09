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
@Table(name = "accountissue", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountissue.findAll", query = "SELECT a FROM Accountissue a")})
public class Accountissue implements Serializable, SmartReponseFormation {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AccountIssusId", nullable = false, length = 2)
    private String accountIssusId;
    @Basic(optional = false)
    @Column(name = "IssueDescribe", nullable = false, length = 40)
    private String issueDescribe;
    @Basic(optional = false)
    @Column(name = "ItemIdPrivate", nullable = false, length = 20)
    private String itemIdPrivate;
    @Basic(optional = false)
    @Column(name = "ItemIdPublic", nullable = false, length = 20)
    private String itemIdPublic;
    @Basic(optional = false)
    @Column(name = "BankIssueNum", nullable = false, length = 20)
    private String bankIssueNum;

    public Accountissue() {
    }

    public Accountissue(String accountIssusId) {
        this.accountIssusId = accountIssusId;
    }

    public Accountissue(String accountIssusId, String issueDescribe, String itemIdPrivate, String itemIdPublic, String bankIssueNum) {
        this.accountIssusId = accountIssusId;
        this.issueDescribe = issueDescribe;
        this.itemIdPrivate = itemIdPrivate;
        this.itemIdPublic = itemIdPublic;
        this.bankIssueNum = bankIssueNum;
    }

    public String getAccountIssusId() {
        return accountIssusId;
    }

    public void setAccountIssusId(String accountIssusId) {
        this.accountIssusId = accountIssusId;
    }

    public String getIssueDescribe() {
        return issueDescribe;
    }

    public void setIssueDescribe(String issueDescribe) {
        this.issueDescribe = issueDescribe;
    }

    public String getItemIdPrivate() {
        return itemIdPrivate;
    }

    public void setItemIdPrivate(String itemIdPrivate) {
        this.itemIdPrivate = itemIdPrivate;
    }

    public String getItemIdPublic() {
        return itemIdPublic;
    }

    public void setItemIdPublic(String itemIdPublic) {
        this.itemIdPublic = itemIdPublic;
    }

    public String getBankIssueNum() {
        return bankIssueNum;
    }

    public void setBankIssueNum(String bankIssueNum) {
        this.bankIssueNum = bankIssueNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountIssusId != null ? accountIssusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountissue)) {
            return false;
        }
        Accountissue other = (Accountissue) object;
        if ((this.accountIssusId == null && other.accountIssusId != null) || (this.accountIssusId != null && !this.accountIssusId.equals(other.accountIssusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Accountissue[ accountIssusId=" + accountIssusId + " ]";
    }

}
