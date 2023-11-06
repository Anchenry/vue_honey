package com.example.springboot_learn.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能：连接至数据库
 * 作者：Anchen
 * 日期：2023/11/5 21:11
 */

@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
}
