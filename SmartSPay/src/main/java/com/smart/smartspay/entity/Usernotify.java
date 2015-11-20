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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Usernotify.findAll", query = "SELECT u FROM Usernotify u"),
    @NamedQuery(name = "Usernotify.findByUserNotifyId", query = "SELECT u FROM Usernotify u WHERE u.userNotifyId = :userNotifyId"),
    @NamedQuery(name = "Usernotify.findByReadStatus", query = "SELECT u FROM Usernotify u WHERE u.readStatus = :readStatus"),
    @NamedQuery(name = "Usernotify.findByReadDate", query = "SELECT u FROM Usernotify u WHERE u.readDate = :readDate")})
public class Usernotify implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer userNotifyId;
    @Basic(optional = false)
    @Column(nullable = false)
    private int readStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;
    @JoinColumn(name = "NotifyId", referencedColumnName = "NotifyId", nullable = false)
    @ManyToOne(optional = false)
    private Notify notifyId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Userdetail userId;

    public Usernotify() {
    }

    public Usernotify(Integer userNotifyId) {
        this.userNotifyId = userNotifyId;
    }

    public Usernotify(Integer userNotifyId, int readStatus) {
        this.userNotifyId = userNotifyId;
        this.readStatus = readStatus;
    }

    public Integer getUserNotifyId() {
        return userNotifyId;
    }

    public void setUserNotifyId(Integer userNotifyId) {
        this.userNotifyId = userNotifyId;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Notify getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Notify notifyId) {
        this.notifyId = notifyId;
    }

    public Userdetail getUserId() {
        return userId;
    }

    public void setUserId(Userdetail userId) {
        this.userId = userId;
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
