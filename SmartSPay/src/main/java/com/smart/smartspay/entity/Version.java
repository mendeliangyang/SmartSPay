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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v"),
    @NamedQuery(name = "Version.findByVersionId", query = "SELECT v FROM Version v WHERE v.versionId = :versionId"),
    @NamedQuery(name = "Version.findByNum", query = "SELECT v FROM Version v WHERE v.num = :num"),
    @NamedQuery(name = "Version.findByContent", query = "SELECT v FROM Version v WHERE v.content = :content"),
    @NamedQuery(name = "Version.findByResorceLink", query = "SELECT v FROM Version v WHERE v.resorceLink = :resorceLink"),
    @NamedQuery(name = "Version.findByUpType", query = "SELECT v FROM Version v WHERE v.upType = :upType"),
    @NamedQuery(name = "Version.findByPutDate", query = "SELECT v FROM Version v WHERE v.putDate = :putDate")})
public class Version implements Serializable, SmartReponseFormation {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(nullable = false, length = 40)
    private String versionId;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String num;
    @Column(length = 400)
    private String content;
    @Column(length = 200)
    private String resorceLink;
    @Basic(optional = false)
    @Column(nullable = false)
    private int upType;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;

    public Version() {
    }

    public Version(String versionId) {
        this.versionId = versionId;
    }

    public Version(String versionId, String num, int upType, Date putDate) {
        this.versionId = versionId;
        this.num = num;
        this.upType = upType;
        this.putDate = putDate;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResorceLink() {
        return resorceLink;
    }

    public void setResorceLink(String resorceLink) {
        this.resorceLink = resorceLink;
    }

    public int getUpType() {
        return upType;
    }

    public void setUpType(int upType) {
        this.upType = upType;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (versionId != null ? versionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.versionId == null && other.versionId != null) || (this.versionId != null && !this.versionId.equals(other.versionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Version[ versionId=" + versionId + " ]";
    }

}
