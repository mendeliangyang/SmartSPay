/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Reply;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Administrator
 */
public interface ReplyRepository extends PagingAndSortingRepository<Reply, String> {

    List<Reply> findByLinkReplyIdAndReplyType(String linkReplyId, int replyType);

    Page<Reply> findByMasterId(String masterId, Pageable pageable);

}
