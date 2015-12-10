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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "filedepotstory", catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filedepotstory.findAll", query = "SELECT f FROM Filedepotstory f")})
public class Filedepotstory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "logId", nullable = false)
    private Integer logId;
    @Column(name = "FileId", length = 40)
    private String fileId;
    @Column(name = "FName", length = 200)
    private String fName;
    @Column(name = "FPath", length = 400)
    private String fPath;
    @Column(name = "FSummary", length = 60)
    private String fSummary;
    @Column(name = "OwnId", length = 40)
    private String ownId;
    @Column(name = "OwnFileType", length = 60)
    private String ownFileType;
    @Column(name = "UploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;

    public Filedepotstory() {
    }

    public Filedepotstory(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
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
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filedepotstory)) {
            return false;
        }
        Filedepotstory other = (Filedepotstory) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Filedepotstory[ logId=" + logId + " ]";
    }
    
}
