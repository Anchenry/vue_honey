package com.example.springboot_learn.controller;

import com.example.springboot_learn.common.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能：提供接口返回数据
 * 作者：Anchen
 * 日期：2023/11/5 15:19
 */
@RestController
@RequestMapping("/web")
public class WebController {
    /**
     * 根据接口请求路径进行匹配，返回"hello Anchen"
     * @return 返回字符串"hello Anchen"
     */
    @RequestMapping("/hello")
    public Result hello(){
        return Result.success("hello Ac");
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST) // web/post
    public Result post(@RequestBody Obj obj){
        return Result.success(obj);
    }

    @RequestMapping(value = "/put",method = RequestMethod.PUT) // web/put
    public Result put(@RequestBody Obj obj){
        return Result.success(obj);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE) // web/put
    public Result delete(@RequestBody List<Integer> ids){
        return Result.success(ids);
    }
}

