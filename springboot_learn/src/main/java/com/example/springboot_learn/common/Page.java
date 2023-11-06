package com.example.springboot_learn.common;

import java.util.List;

/**
 * 功能：
 * 作者：Anchen
 * 日期：2023/11/6 14:42
 */

public class Page<T> {
    private Integer total;
    private List<T> list;

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }
}
