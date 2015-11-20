/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "smartpay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumetype.findAll", query = "SELECT c FROM Consumetype c"),
    @NamedQuery(name = "Consumetype.findByConsumeTypeId", query = "SELECT c FROM Consumetype c WHERE c.consumeTypeId = :consumeTypeId"),
    @NamedQuery(name = "Consumetype.findByTypeTitle", query = "SELECT c FROM Consumetype c WHERE c.typeTitle = :typeTitle")})
public class Consumetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String consumeTypeId;
    private Integer typeTitle;

    public Consumetype() {
    }

    public Consumetype(String consumeTypeId) {
        this.consumeTypeId = consumeTypeId;
    }

    public String getConsumeTypeId() {
        return consumeTypeId;
    }

    public void setConsumeTypeId(String consumeTypeId) {
        this.consumeTypeId = consumeTypeId;
    }

    public Integer getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(Integer typeTitle) {
        this.typeTitle = typeTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumeTypeId != null ? consumeTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumetype)) {
            return false;
        }
        Consumetype other = (Consumetype) object;
        if ((this.consumeTypeId == null && other.consumeTypeId != null) || (this.consumeTypeId != null && !this.consumeTypeId.equals(other.consumeTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.Consumetype[ consumeTypeId=" + consumeTypeId + " ]";
    }
    
}
