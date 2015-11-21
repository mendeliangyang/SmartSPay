/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import com.google.gson.annotations.Expose;
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
import javax.persistence.Transient;
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
    @NamedQuery(name = "Filedepot.findAll", query = "SELECT f FROM Filedepot f"),
    @NamedQuery(name = "Filedepot.findByFileId", query = "SELECT f FROM Filedepot f WHERE f.fileId = :fileId"),
    @NamedQuery(name = "Filedepot.findByFName", query = "SELECT f FROM Filedepot f WHERE f.fName = :fName"),
    @NamedQuery(name = "Filedepot.findByFPath", query = "SELECT f FROM Filedepot f WHERE f.fPath = :fPath"),
    @NamedQuery(name = "Filedepot.findByFSummary", query = "SELECT f FROM Filedepot f WHERE f.fSummary = :fSummary"),
    @NamedQuery(name = "Filedepot.findByOwnId", query = "SELECT f FROM Filedepot f WHERE f.ownId = :ownId"),
    @NamedQuery(name = "Filedepot.findByOwnFileType", query = "SELECT f FROM Filedepot f WHERE f.ownFileType = :ownFileType"),
    @NamedQuery(name = "Filedepot.findByUploadDate", query = "SELECT f FROM Filedepot f WHERE f.uploadDate = :uploadDate")})
public class Filedepot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String fileId;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String fName;
    @Basic(optional = false)
    @Column(nullable = false, length = 400)
    private String fPath;
    @Column(length = 60)
//    @Expose
    private String fSummary;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String ownId;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String ownFileType;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;

    @Transient
    private String HttpPath;

    public String getHttpPath() {
        return HttpPath;
    }

    public void setHttpPath(String HttpPath) {
        this.HttpPath = HttpPath;
    }

    public Filedepot() {
    }

    public Filedepot(String fileId) {
        this.fileId = fileId;
    }

    public Filedepot(String fileId, String fName, String fPath, String ownId, String ownFileType, Date uploadDate) {
        this.fileId = fileId;
        this.fName = fName;
        this.fPath = fPath;
        this.ownId = ownId;
        this.ownFileType = ownFileType;
        this.uploadDate = uploadDate;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFPath() {
        return fPath;
    }

    public void setFPath(String fPath) {
        this.fPath = fPath;
    }

    public String getFSummary() {
        return fSummary;
    }

    public void setFSummary(String fSummary) {
        this.fSummary = fSummary;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }

    public String getOwnFileType() {
        return ownFileType;
    }

    public void setOwnFileType(String ownFileType) {
        this.ownFileType = ownFileType;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filedepot)) {
            return false;
        }
        Filedepot other = (Filedepot) object;
        if ((this.fileId == null && other.fileId != null) || (this.fileId != null && !this.fileId.equals(other.fileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Filedepot[ fileId=" + fileId + " ]";
    }

}
