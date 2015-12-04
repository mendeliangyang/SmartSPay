/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class ItemlogPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ItemId", nullable = false, length = 20)
    private String itemId;
    @Basic(optional = false)
    @Column(name = "AccountSeq", nullable = false)
    private int accountSeq;

    public ItemlogPK() {
    }

    public ItemlogPK(String itemId, int accountSeq) {
        this.itemId = itemId;
        this.accountSeq = accountSeq;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getAccountSeq() {
        return accountSeq;
    }

    public void setAccountSeq(int accountSeq) {
        this.accountSeq = accountSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        hash += (int) accountSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemlogPK)) {
            return false;
        }
        ItemlogPK other = (ItemlogPK) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        if (this.accountSeq != other.accountSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smart.smartspay.entity.ItemlogPK[ itemId=" + itemId + ", accountSeq=" + accountSeq + " ]";
    }
    
}
