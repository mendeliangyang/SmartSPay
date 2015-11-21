/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.entity;

import java.util.List;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
public abstract class BaseFileDepot {

    public abstract String getFileOwnId();

    @Transient
    private List<Filedepot> fileDetail;

    public List<Filedepot> getFileDetail() {
        return fileDetail;
    }

    public void setFileDetail(List<Filedepot> fileDetail) {
        this.fileDetail = fileDetail;
    }

}
