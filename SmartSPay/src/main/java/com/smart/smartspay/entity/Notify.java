/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "smartpay", schema = "")
@XmlRootElement

public class Notify implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String notifyId;
    @Column(length = 80)
    private String title;
    @Column(length = 400)
    private String content;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private int branchAuth;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String communityId;

    @JoinColumn(name = "BranchId", referencedColumnName = "BranchId", nullable = false)
    @ManyToOne(optional = false)
    private Branch branchId;

    public Notify() {
    }

    public Notify(String notifyId) {
        this.notifyId = notifyId;
    }

    public Notify(String notifyId, Date putDate, int branchAuth, String communityId) {
        this.notifyId = notifyId;
        this.putDate = putDate;
        this.branchAuth = branchAuth;
        this.communityId = communityId;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public int getBranchAuth() {
        return branchAuth;
    }

    public void setBranchAuth(int branchAuth) {
        this.branchAuth = branchAuth;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notifyId != null ? notifyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notify)) {
            return false;
        }
        Notify other = (Notify) object;
        if ((this.notifyId == null && other.notifyId != null) || (this.notifyId != null && !this.notifyId.equals(other.notifyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Notify[ notifyId=" + notifyId + " ]";
    }

}
