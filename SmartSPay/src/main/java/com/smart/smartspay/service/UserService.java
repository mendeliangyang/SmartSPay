/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.service;

import com.smart.smartspay.entity.Userdetail;
import com.smart.smartspay.exception.NotFoundException;
import com.smart.smartspay.exception.UserNameExistException;
import com.smart.smartspay.exception.UserNickNameExistException;
import com.smart.smartspay.exception.UserVerifyPhoneExistException;
import com.smart.smartspay.repository.UserDetailRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class UserService {

    @Resource
    UserDetailRepository userdetailRepository;

    @Transactional
    public void registerUser(Userdetail userdetail) throws UserNickNameExistException, UserNameExistException, UserVerifyPhoneExistException {
        long countTemp = userdetailRepository.countByNickName(userdetail.getNickName());
        if (countTemp != 0) {
            throw new UserNickNameExistException("nickName exist.");
        }
        countTemp = userdetailRepository.countByUserName(userdetail.getUserName());
        if (countTemp != 0) {
            throw new UserNameExistException("userName exist.");
        }
        countTemp = userdetailRepository.countByVerifyPhone(userdetail.getVerifyPhone());
        if (countTemp != 0) {
            throw new UserVerifyPhoneExistException("verifyPhone exist.");
        }

        userdetailRepository.save(userdetail);

    }

    @Transactional
    public void modifyPassword(Userdetail user) throws NotFoundException {

        Userdetail userdetail = userdetailRepository.findByUserName(user.getUserName());
        if (userdetail == null) {
            throw new NotFoundException("user name don't exist.");
        }

        userdetail.setUPassword(user.getUPassword());

        userdetailRepository.save(userdetail);

    }
}
