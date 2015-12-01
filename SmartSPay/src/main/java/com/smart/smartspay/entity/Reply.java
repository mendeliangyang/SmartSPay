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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Reply extends BaseFileDepot implements Serializable, SmartReponseFormation {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ReplyId", nullable = false, length = 40)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String replyId;
    @Basic(optional = false)
    @Column(name = "MasterId", nullable = false, length = 40)
    private String masterId;
    @Column(name = "LinkReplyId", length = 40)
    private String linkReplyId;
    @Column(name = "Conntext", length = 400)
    private String conntext;
    @Column(name = "PutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Basic(optional = false)
    @Column(name = "ReplyType", nullable = false)
    private int replyType;
//    @Basic(optional = false)
//    @Column(name = "UserId", nullable = false, length = 40)
//    private String userId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Userdetail userId;

    public Reply() {
    }

    public Reply(String replyId) {
        this.replyId = replyId;
    }

    public Reply(String replyId, String masterId, int replyType, String userId) {
        this.replyId = replyId;
        this.masterId = masterId;
        this.replyType = replyType;
//        this.userId = userId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getLinkReplyId() {
        return linkReplyId;
    }

    public void setLinkReplyId(String linkReplyId) {
        this.linkReplyId = linkReplyId;
    }

    public String getConntext() {
        return conntext;
    }

    public void setConntext(String conntext) {
        this.conntext = conntext;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public int getReplyType() {
        return replyType;
    }

    public void setReplyType(int replyType) {
        this.replyType = replyType;
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
        hash += (replyId != null ? replyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reply)) {
            return false;
        }
        Reply other = (Reply) object;
        if ((this.replyId == null && other.replyId != null) || (this.replyId != null && !this.replyId.equals(other.replyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Reply[ replyId=" + replyId + " ]";
    }

    @Override
    public String getFileOwnId() {
        return this.replyId;
    }

}
