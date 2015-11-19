/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usernotify.findAll", query = "SELECT u FROM Usernotify u"),
    @NamedQuery(name = "Usernotify.findByUserNotifyId", query = "SELECT u FROM Usernotify u WHERE u.userNotifyId = :userNotifyId"),
    @NamedQuery(name = "Usernotify.findByNotifyId", query = "SELECT u FROM Usernotify u WHERE u.notifyId = :notifyId"),
    @NamedQuery(name = "Usernotify.findByReadStatus", query = "SELECT u FROM Usernotify u WHERE u.readStatus = :readStatus"),
    @NamedQuery(name = "Usernotify.findByUserId", query = "SELECT u FROM Usernotify u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usernotify.findByReadDate", query = "SELECT u FROM Usernotify u WHERE u.readDate = :readDate")})
public class Usernotify implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer userNotifyId;
    @Basic(optional = false)
    private String notifyId;
    @Basic(optional = false)
    private int readStatus;
    @Basic(optional = false)
    private String userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

    public Usernotify() {
    }

    public Usernotify(Integer userNotifyId) {
        this.userNotifyId = userNotifyId;
    }

    public Usernotify(Integer userNotifyId, String notifyId, int readStatus, String userId) {
        this.userNotifyId = userNotifyId;
        this.notifyId = notifyId;
        this.readStatus = readStatus;
        this.userId = userId;
    }

    public Integer getUserNotifyId() {
        return userNotifyId;
    }

    public void setUserNotifyId(Integer userNotifyId) {
        this.userNotifyId = userNotifyId;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userNotifyId != null ? userNotifyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usernotify)) {
            return false;
        }
        Usernotify other = (Usernotify) object;
        if ((this.userNotifyId == null && other.userNotifyId != null) || (this.userNotifyId != null && !this.userNotifyId.equals(other.userNotifyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Usernotify[ userNotifyId=" + userNotifyId + " ]";
    }
    
}
