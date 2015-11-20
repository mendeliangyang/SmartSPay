/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByNoteId", query = "SELECT n FROM Note n WHERE n.noteId = :noteId"),
    @NamedQuery(name = "Note.findByTitle", query = "SELECT n FROM Note n WHERE n.title = :title"),
    @NamedQuery(name = "Note.findByContent", query = "SELECT n FROM Note n WHERE n.content = :content"),
    @NamedQuery(name = "Note.findByPutDate", query = "SELECT n FROM Note n WHERE n.putDate = :putDate"),
    @NamedQuery(name = "Note.findByLaudCount", query = "SELECT n FROM Note n WHERE n.laudCount = :laudCount"),
    @NamedQuery(name = "Note.findByReadCount", query = "SELECT n FROM Note n WHERE n.readCount = :readCount"),
    @NamedQuery(name = "Note.findByCommunityId", query = "SELECT n FROM Note n WHERE n.communityId = :communityId")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String noteId;
    @Column(length = 100)
    private String title;
    @Column(length = 1000)
    private String content;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date putDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private int laudCount;
    @Basic(optional = false)
    @Column(nullable = false)
    private int readCount;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String communityId;
    @JoinColumn(name = "PutUserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Userdetail putUserId;

    public Note() {
    }

    public Note(String noteId) {
        this.noteId = noteId;
    }

    public Note(String noteId, Date putDate, int laudCount, int readCount, String communityId) {
        this.noteId = noteId;
        this.putDate = putDate;
        this.laudCount = laudCount;
        this.readCount = readCount;
        this.communityId = communityId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String conntext) {
        this.content = conntext;
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

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public Userdetail getPutUserId() {
        return putUserId;
    }

    public void setPutUserId(Userdetail putUserId) {
        this.putUserId = putUserId;
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
