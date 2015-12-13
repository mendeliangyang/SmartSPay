/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartspay.entity.BaseFileDepot;
import com.smart.smartspay.entity.Filedepot;
import com.smart.smartspay.entity.Filedepotstory;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.repository.FileDepotStoryRepository;
import com.smart.smartspay.repository.FileDepotRepository;
import com.smart.smartspay.task.WebSiteConfig;
import com.smart.smartspay.util.ResponseResultCode;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
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
    FileDepotStoryRepository fileDepotStoryRepository;

    @Resource
    WebSiteConfig webSiteConfig;

    @Transactional
    public void saveFiles(Set<Filedepot> fileDepots) throws NotFoundException {
        Filedepot tempFileDepot = null;
        Filedepotstory tempFiledepotLs = null;
        for (Filedepot fileDepot : fileDepots) {
            if (fileDepot.getFileId() != null && !fileDepot.getFileId().isEmpty()) {
                tempFileDepot = fileDepotRepository.findOne(fileDepot.getFileId());
                if (tempFileDepot == null) {
                    throw new NotFoundException(ResponseResultCode.ErrorFileUnExistOnDB, String.format("fileId '%s' does not exist.", fileDepot.getFileId()));
                }
                tempFiledepotLs = new Filedepotstory();
                tempFiledepotLs.setFName(tempFileDepot.getFName());
                tempFiledepotLs.setFPath(tempFileDepot.getFPath());
                tempFiledepotLs.setFSummary(tempFileDepot.getFSummary());
                tempFiledepotLs.setFileId(tempFileDepot.getFileId());
                tempFiledepotLs.setOwnFileType(tempFileDepot.getOwnFileType());
                tempFiledepotLs.setOwnId(tempFileDepot.getOwnId());
                tempFiledepotLs.setUploadDate(tempFileDepot.getUploadDate());
                fileDepotStoryRepository.save(tempFiledepotLs);
            }
            fileDepot.setUploadDate(new Date());
            fileDepotRepository.save(fileDepot);
        }
    }

    public List<Filedepot> getFilesByOwnId(String ownId) {
        List<Filedepot> filedepots = fileDepotRepository.findByOwnId(ownId);
        StringBuffer sb = new StringBuffer();
        for (Filedepot fileDepot : filedepots) {
            sb.append(webSiteConfig.getWebSiteHttpDepotPath()).append(fileDepot.getFPath().replace('\\', '/'));
            fileDepot.setHttpPath(sb.toString());
            sb.delete(0, sb.length());
        }
        return filedepots;
    }

    public <T extends BaseFileDepot> Page<T> getFilesByOwn(Page<T> owns) {
        for (T content : owns.getContent()) {
            content.setFileDetail(getFilesByOwnId(content.getFileOwnId()));
        }
        return owns;
    }

    public <T extends BaseFileDepot> T getFilesByOwn(T own) {
        own.setFileDetail(getFilesByOwnId(own.getFileOwnId()));
        return own;
    }
}
