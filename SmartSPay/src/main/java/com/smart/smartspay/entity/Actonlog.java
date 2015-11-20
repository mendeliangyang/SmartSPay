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
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actonlog.findAll", query = "SELECT a FROM Actonlog a"),
    @NamedQuery(name = "Actonlog.findByLogId", query = "SELECT a FROM Actonlog a WHERE a.logId = :logId"),
    @NamedQuery(name = "Actonlog.findByActOnId", query = "SELECT a FROM Actonlog a WHERE a.actOnId = :actOnId"),
    @NamedQuery(name = "Actonlog.findBySendData", query = "SELECT a FROM Actonlog a WHERE a.sendData = :sendData"),
    @NamedQuery(name = "Actonlog.findBySendDateTime", query = "SELECT a FROM Actonlog a WHERE a.sendDateTime = :sendDateTime"),
    @NamedQuery(name = "Actonlog.findByReceiveData", query = "SELECT a FROM Actonlog a WHERE a.receiveData = :receiveData"),
    @NamedQuery(name = "Actonlog.findByReceiveDataTime", query = "SELECT a FROM Actonlog a WHERE a.receiveDataTime = :receiveDataTime")})
public class Actonlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer logId;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String actOnId;
    @Column(length = 1024)
    private String sendData;
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDateTime;
    @Column(length = 1024)
    private String receiveData;
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveDataTime;

    public Actonlog() {
    }

    public Actonlog(Integer logId) {
        this.logId = logId;
    }

    public Actonlog(Integer logId, String actOnId) {
        this.logId = logId;
        this.actOnId = actOnId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getActOnId() {
        return actOnId;
    }

    public void setActOnId(String actOnId) {
        this.actOnId = actOnId;
    }

    public String getSendData() {
        return sendData;
    }

    public void setSendData(String sendData) {
        this.sendData = sendData;
    }

    public Date getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(Date sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public String getReceiveData() {
        return receiveData;
    }

    public void setReceiveData(String receiveData) {
        this.receiveData = receiveData;
    }

    public Date getReceiveDataTime() {
        return receiveDataTime;
    }

    public void setReceiveDataTime(Date receiveDataTime) {
        this.receiveDataTime = receiveDataTime;
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
        if (!(object instanceof Actonlog)) {
            return false;
        }
        Actonlog other = (Actonlog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Actonlog[ logId=" + logId + " ]";
    }
    
}
