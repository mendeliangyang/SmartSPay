/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.repository;

import com.smart.smartspay.entity.Item;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Administrator
 */
public interface ItemRepository extends CrudRepository<Item, String> {

}
