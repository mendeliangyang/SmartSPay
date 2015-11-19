/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notify.findAll", query = "SELECT n FROM Notify n"),
    @NamedQuery(name = "Notify.findByNotifyId", query = "SELECT n FROM Notify n WHERE n.notifyId = :notifyId"),
    @NamedQuery(name = "Notify.findByTitle", query = "SELECT n FROM Notify n WHERE n.title = :title"),
    @NamedQuery(name = "Notify.findByContent", query = "SELECT n FROM Notify n WHERE n.content = :content"),
    @NamedQuery(name = "Notify.findByPutDate", query = "SELECT n FROM Notify n WHERE n.putDate = :putDate"),
    @NamedQuery(name = "Notify.findByBranchId", query = "SELECT n FROM Notify n WHERE n.branchId = :branchId"),
    @NamedQuery(name = "Notify.findByBranchAuth", query = "SELECT n FROM Notify n WHERE n.branchAuth = :branchAuth"),
    @NamedQuery(name = "Notify.findByCommunityId", query = "SELECT n FROM Notify n WHERE n.communityId = :communityId")})
public class Notify implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String notifyId;
    private String title;
    private String content;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
//    @Basic(optional = false)
    
    @JoinColumn(name = "BranchId", referencedColumnName = "BranchId")
    @ManyToOne(optional = false)
    private Branch branchId;
    @Basic(optional = false)
    private int branchAuth;
    @Basic(optional = false)
    private String communityId;

//    @OneToOne(cascade = CascadeType.DETACH,optional = false,fetch = FetchType.EAGER)
//     @JoinColumn(name="Branch_BranchId", nullable=true)
//    private Branch branchId;

//    public Branch getBranchContext() {
//        return branchContext;
//    }
//
//    public void setBranchContext(Branch branchContext) {
//        this.branchContext = branchContext;
//    }
    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public Notify() {
    }

    public Notify(String notifyId) {
        this.notifyId = notifyId;
    }

    public Notify(String notifyId, Date putDate, String branchId, int branchAuth, String communityId) {
        this.notifyId = notifyId;
        this.putDate = putDate;
//        this.branchId = branchId;
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
