/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.util;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class PageJson {

    PageJson() {
    }

    PageJson(long total, List<?> content) {
        this.total = total;
        this.content = content;
    }

    private long total;

    private List<?> content;

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
