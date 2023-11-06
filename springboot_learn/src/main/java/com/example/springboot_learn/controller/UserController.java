package com.example.springboot_learn.controller;

import com.example.springboot_learn.common.Page;
import com.example.springboot_learn.common.Result;
import com.example.springboot_learn.entity.User;
import com.example.springboot_learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：
 * 作者：Anchen
 * 日期：2023/11/5 22:06
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //新增用户信息
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        try{
            userService.insertUser(user);
        }catch(Exception e){
            if(e instanceof DuplicateKeyException){
                return Result.error("插入数据库错误");
            }else {
                return Result.error("系统错误");
            }
        }
        return Result.success();
    }

    // 修改用户信息
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        try{
            userService.updateUser(user);
        }catch(Exception e){
            if(e instanceof DuplicateKeyException){
                return Result.error("插入数据库错误");
            }else {
                return Result.error("系统错误");
            }
        }
        return Result.success();
    }

    // 删除用户信息
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        try{
            userService.deleteUser(id);
        }catch(Exception e){
            return Result.error("系统错误");
        }
        return Result.success();
    }

    //批量删除
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids){
        try{
            userService.batchDeleteUser(ids);
        }catch(Exception e){
            return Result.error("系统错误");
        }
        return Result.success();
    }

    // 查询用户信息
    @GetMapping("/selectAll")
    public Result selectUser(){
        List<User>  userList = userService.selectAll();
        return Result.success(userList);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        User  user = userService.selectById(id);
        return Result.success(user);
    }

    @GetMapping("/selectByName/{name}")
    public Result selectByName(@PathVariable String name){
        List<User>  user = userService.selectByName(name);
        return Result.success(user);
    }

    @GetMapping("/selectByMore")
    public Result selectByMore(@RequestParam String username,@RequestParam String name){
        List<User>  user = userService.selectByMore(username,name);
        return Result.success(user);
    }

    //模糊查询
    @GetMapping("/selectByMo")
    public Result selectByMo(@RequestParam String username,@RequestParam String name){
        List<User>  user = userService.selectByMo(username,name);
        return Result.success(user);
    }

    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username,@RequestParam String name){
        Map<String,Object> result = new HashMap<>();
        Page<User> page = userService.selectByPage(pageNum,pageSize,username,name);
        return Result.success(page);
    }
}
