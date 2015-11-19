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
    @NamedQuery(name = "Advice.findAll", query = "SELECT a FROM Advice a"),
    @NamedQuery(name = "Advice.findByAdviceId", query = "SELECT a FROM Advice a WHERE a.adviceId = :adviceId"),
    @NamedQuery(name = "Advice.findByContent", query = "SELECT a FROM Advice a WHERE a.content = :content"),
    @NamedQuery(name = "Advice.findByPutDate", query = "SELECT a FROM Advice a WHERE a.putDate = :putDate"),
    @NamedQuery(name = "Advice.findByUserId", query = "SELECT a FROM Advice a WHERE a.userId = :userId"),
    @NamedQuery(name = "Advice.findByProcessFlag", query = "SELECT a FROM Advice a WHERE a.processFlag = :processFlag"),
    @NamedQuery(name = "Advice.findByProcessDate", query = "SELECT a FROM Advice a WHERE a.processDate = :processDate"),
    @NamedQuery(name = "Advice.findByProcessReply", query = "SELECT a FROM Advice a WHERE a.processReply = :processReply")})
public class Advice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String adviceId;
    @Basic(optional = false)
    private String content;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Basic(optional = false)
    private String userId;
    private Integer processFlag;
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    private String processReply;

    public Advice() {
    }

    public Advice(String adviceId) {
        this.adviceId = adviceId;
    }

    public Advice(String adviceId, String content, Date putDate, String userId) {
        this.adviceId = adviceId;
        this.content = content;
        this.putDate = putDate;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
