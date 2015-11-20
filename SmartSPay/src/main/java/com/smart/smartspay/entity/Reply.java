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
    @NamedQuery(name = "Reply.findAll", query = "SELECT r FROM Reply r"),
    @NamedQuery(name = "Reply.findByReplyId", query = "SELECT r FROM Reply r WHERE r.replyId = :replyId"),
    @NamedQuery(name = "Reply.findByLinkReplyId", query = "SELECT r FROM Reply r WHERE r.linkReplyId = :linkReplyId"),
    @NamedQuery(name = "Reply.findByConntext", query = "SELECT r FROM Reply r WHERE r.conntext = :conntext"),
    @NamedQuery(name = "Reply.findByPutDate", query = "SELECT r FROM Reply r WHERE r.putDate = :putDate")})
public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String replyId;
    @Column(length = 40)
    private String linkReplyId;
    @Column(length = 400)
    private String conntext;
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @JoinColumn(name = "NoteId", referencedColumnName = "NoteId", nullable = false)
    @ManyToOne(optional = false)
    private Note noteId;

    public Reply() {
    }

    public Reply(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
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

    public Note getNoteId() {
        return noteId;
    }

    public void setNoteId(Note noteId) {
        this.noteId = noteId;
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
    
}
