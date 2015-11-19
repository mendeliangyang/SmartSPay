/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notelaud.findAll", query = "SELECT n FROM Notelaud n"),
    @NamedQuery(name = "Notelaud.findByLaudId", query = "SELECT n FROM Notelaud n WHERE n.laudId = :laudId"),
    @NamedQuery(name = "Notelaud.findByNoteId", query = "SELECT n FROM Notelaud n WHERE n.noteId = :noteId"),
    @NamedQuery(name = "Notelaud.findByUserId", query = "SELECT n FROM Notelaud n WHERE n.userId = :userId")})
public class Notelaud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer laudId;
    @Basic(optional = false)
    private String noteId;
    @Basic(optional = false)
    private String userId;

    public Notelaud() {
    }

    public Notelaud(Integer laudId) {
        this.laudId = laudId;
    }

    public Notelaud(Integer laudId, String noteId, String userId) {
        this.laudId = laudId;
        this.noteId = noteId;
        this.userId = userId;
    }

    public Integer getLaudId() {
        return laudId;
    }

    public void setLaudId(Integer laudId) {
        this.laudId = laudId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laudId != null ? laudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notelaud)) {
            return false;
        }
        Notelaud other = (Notelaud) object;
        if ((this.laudId == null && other.laudId != null) || (this.laudId != null && !this.laudId.equals(other.laudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Notelaud[ laudId=" + laudId + " ]";
    }
    
}
