/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Filedepot;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Administrator
 */
public interface FileDepotRepository extends CrudRepository<Filedepot, String> {

    Long countByFNameAndOwnId(String fName, String ownId);

    List<Filedepot> findByFileIdInOrOwnIdInOrOwnFileTypeIn(List<String> fileIds, List<String> ownIds, List<String> ownFileTypes);

    List<Filedepot> findByOwnId(String ownId);

}
