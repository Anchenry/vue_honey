package com.example.springboot_learn.common;

import lombok.Data; // 自动生成类的setter、getter、toString和equals方法
import lombok.Builder; // 自动生成用于构建对象的构造函数和setter方法
import lombok.NoArgsConstructor; // 自动生成类的无参构造函数
import lombok.AllArgsConstructor; // 自动生成类的带参数构造函数和setter方法

/**
 * 功能：
 * 作者：Anchen
 * 日期：2023/11/5 15:51
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    public static final String CODE_SUCCESS = "200";
    public static final String CODE_SYS_ERROR = "500";
    public static final String CODE_AUTH_ERROR = "401";

    /*
    * 请求的返回编码 200 401 404 500
    * 编码表示这次请求hi成功还是失败
    * 或者说 可以看护失败的类型是什么
    */
    private String code;
    /*
    * msg表示错误的详细信息
    */
    private String msg;
    /*数据从什么地方返回出去？
    * 就是这个data
    * user Object类型是User
    * List Object类型是List
    * Map Object类型是Map
    */
    private Object data;
    public static Result success() {
        return new Result(CODE_SUCCESS, "请求成功", null);
    }
    public static Result success(Object data) {
        return new Result(CODE_SUCCESS, "请求成功", data);
    }
    public static Result error(String msg) {
        return new Result(CODE_SYS_ERROR, msg, null);
    }
    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }
    public static Result error() {
        return new Result(CODE_SYS_ERROR, "系统错误", null);
    }
}
