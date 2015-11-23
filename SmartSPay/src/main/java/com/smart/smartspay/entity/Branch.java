/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
public class Branch implements Serializable, SmartReponseFormation {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String branchId;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String branchName;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String branchUpId;
    private Integer branchLevel;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String communityId;

    public Branch() {
    }

    public Branch(String branchId) {
        this.branchId = branchId;
    }

    public Branch(String branchId, String branchName, String branchUpId, String communityId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchUpId = branchUpId;
        this.communityId = communityId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchUpId() {
        return branchUpId;
    }

    public void setBranchUpId(String branchUpId) {
        this.branchUpId = branchUpId;
    }

    public Integer getBranchLevel() {
        return branchLevel;
    }

    public void setBranchLevel(Integer branchLevel) {
        this.branchLevel = branchLevel;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Branch[ branchId=" + branchId + " ]";
    }

}
