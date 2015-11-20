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
@NamedQueries({
    @NamedQuery(name = "Community.findAll", query = "SELECT c FROM Community c"),
    @NamedQuery(name = "Community.findByCommunityId", query = "SELECT c FROM Community c WHERE c.communityId = :communityId"),
    @NamedQuery(name = "Community.findByCommunityName", query = "SELECT c FROM Community c WHERE c.communityName = :communityName")})
public class Community implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String communityId;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String communityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "communityId")
    private Collection<Communityuser> communityuserCollection;

    public Community() {
    }

    public Community(String communityId) {
        this.communityId = communityId;
    }

    public Community(String communityId, String communityName) {
        this.communityId = communityId;
        this.communityName = communityName;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @XmlTransient
    public Collection<Communityuser> getCommunityuserCollection() {
        return communityuserCollection;
    }

    public void setCommunityuserCollection(Collection<Communityuser> communityuserCollection) {
        this.communityuserCollection = communityuserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (communityId != null ? communityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Community)) {
            return false;
        }
        Community other = (Community) object;
        if ((this.communityId == null && other.communityId != null) || (this.communityId != null && !this.communityId.equals(other.communityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Community[ communityId=" + communityId + " ]";
    }
    
}
