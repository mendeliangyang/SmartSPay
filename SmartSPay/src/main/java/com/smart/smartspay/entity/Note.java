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
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByNoteId", query = "SELECT n FROM Note n WHERE n.noteId = :noteId"),
    @NamedQuery(name = "Note.findByTitle", query = "SELECT n FROM Note n WHERE n.title = :title"),
    @NamedQuery(name = "Note.findByConntext", query = "SELECT n FROM Note n WHERE n.conntext = :conntext"),
    @NamedQuery(name = "Note.findByPutDate", query = "SELECT n FROM Note n WHERE n.putDate = :putDate"),
    @NamedQuery(name = "Note.findByLaudCount", query = "SELECT n FROM Note n WHERE n.laudCount = :laudCount"),
    @NamedQuery(name = "Note.findByReadCount", query = "SELECT n FROM Note n WHERE n.readCount = :readCount"),
    @NamedQuery(name = "Note.findByPutUserId", query = "SELECT n FROM Note n WHERE n.putUserId = :putUserId"),
    @NamedQuery(name = "Note.findByCommunityId", query = "SELECT n FROM Note n WHERE n.communityId = :communityId")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer noteId;
    private String title;
    private String conntext;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Basic(optional = false)
    private int laudCount;
    @Basic(optional = false)
    private int readCount;
    @Basic(optional = false)
    private String putUserId;
    @Basic(optional = false)
    private String communityId;

    public Note() {
    }

    public Note(Integer noteId) {
        this.noteId = noteId;
    }

    public Note(Integer noteId, Date putDate, int laudCount, int readCount, String putUserId, String communityId) {
        this.noteId = noteId;
        this.putDate = putDate;
        this.laudCount = laudCount;
        this.readCount = readCount;
        this.putUserId = putUserId;
        this.communityId = communityId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getLaudCount() {
        return laudCount;
    }

    public void setLaudCount(int laudCount) {
        this.laudCount = laudCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getPutUserId() {
        return putUserId;
    }

    public void setPutUserId(String putUserId) {
        this.putUserId = putUserId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noteId != null ? noteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.noteId == null && other.noteId != null) || (this.noteId != null && !this.noteId.equals(other.noteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Note[ noteId=" + noteId + " ]";
    }
    
}
