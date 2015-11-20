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
    @NamedQuery(name = "Advice.findAll", query = "SELECT a FROM Advice a"),
    @NamedQuery(name = "Advice.findByAdviceId", query = "SELECT a FROM Advice a WHERE a.adviceId = :adviceId"),
    @NamedQuery(name = "Advice.findByContent", query = "SELECT a FROM Advice a WHERE a.content = :content"),
    @NamedQuery(name = "Advice.findByPutDate", query = "SELECT a FROM Advice a WHERE a.putDate = :putDate"),
    @NamedQuery(name = "Advice.findByProcessFlag", query = "SELECT a FROM Advice a WHERE a.processFlag = :processFlag"),
    @NamedQuery(name = "Advice.findByProcessDate", query = "SELECT a FROM Advice a WHERE a.processDate = :processDate"),
    @NamedQuery(name = "Advice.findByProcessReply", query = "SELECT a FROM Advice a WHERE a.processReply = :processReply")})
public class Advice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String adviceId;
    @Basic(optional = false)
    @Column(nullable = false, length = 400)
    private String content;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    private Integer processFlag;
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Column(length = 400)
    private String processReply;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Userdetail userId;

    public Advice() {
    }

    public Advice(String adviceId) {
        this.adviceId = adviceId;
    }

    public Advice(String adviceId, String content, Date putDate) {
        this.adviceId = adviceId;
        this.content = content;
        this.putDate = putDate;
    }

    public String getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(String adviceId) {
        this.adviceId = adviceId;
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

    public Integer getProcessFlag() {
        return processFlag;
    }

    public void setProcessFlag(Integer processFlag) {
        this.processFlag = processFlag;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getProcessReply() {
        return processReply;
    }

    public void setProcessReply(String processReply) {
        this.processReply = processReply;
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
        hash += (adviceId != null ? adviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advice)) {
            return false;
        }
        Advice other = (Advice) object;
        if ((this.adviceId == null && other.adviceId != null) || (this.adviceId != null && !this.adviceId.equals(other.adviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Advice[ adviceId=" + adviceId + " ]";
    }
    
}
