/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartspay.entity.Filedepot;
import com.smart.smartspay.entity.FiledepotLs;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.repository.FileDepotLSRepository;
import com.smart.smartspay.repository.FileDepotRepository;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class FileDepotService {

    @Resource
    FileDepotRepository fileDepotRepository;

    @Resource
    FileDepotLSRepository fileDepotLsRepository;

    @Transactional
    public void saveFiles(Set<Filedepot> fileDepots) throws NotFoundException {
        Filedepot tempFileDepot = null;
        FiledepotLs tempFiledepotLs = null;
        for (Filedepot fileDepot : fileDepots) {
            if (fileDepot.getFileId() != null && !fileDepot.getFileId().isEmpty()) {
                tempFileDepot = fileDepotRepository.findOne(fileDepot.getFileId());
                if (tempFileDepot == null) {
                    throw new NotFoundException(String.format("fileId '%s' does not exist.", fileDepot.getFileId()));
                }
                tempFiledepotLs = new FiledepotLs();
                tempFiledepotLs.setFName(tempFileDepot.getFName());
                tempFiledepotLs.setFPath(tempFileDepot.getFPath());
                tempFiledepotLs.setFSummary(tempFileDepot.getFSummary());
                tempFiledepotLs.setFileId(tempFileDepot.getFileId());
                tempFiledepotLs.setOwnFileType(tempFileDepot.getOwnFileType());
                tempFiledepotLs.setOwnId(tempFileDepot.getOwnId());
                tempFiledepotLs.setUploadDate(tempFileDepot.getUploadDate());
                fileDepotLsRepository.save(tempFiledepotLs);
            }
            fileDepot.setUploadDate(new Date());
            fileDepotRepository.save(fileDepot);
        }
    }

}
