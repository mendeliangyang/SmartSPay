/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Userdetail;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Administrator
 */
public interface UserDetailRepository extends CrudRepository<Userdetail, String> {

    List<Userdetail> findByUserNameContaining(String userName);

    Userdetail findByUserName(String userName);

    @Query("select u from Userdetail u where u.userName=:userName and u.uPassword=:uPassword")
    Userdetail getUserDetail(@Param("userName") String userName, @Param("uPassword") String uPassword);

    Long countByUserName(String userName);

    Long countByVerifyPhone(String verifyPhone);

    Long countByNickName(String NickName);

}
