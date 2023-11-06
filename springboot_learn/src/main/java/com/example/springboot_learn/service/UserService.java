package com.example.springboot_learn.service;

import com.example.springboot_learn.entity.User;
import com.example.springboot_learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springboot_learn.common.Page;


/**
 * 功能：
 * 作者：Anchen
 * 日期：2023/11/5 22:02
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void insertUser(User user){
        userMapper.insert(user);
    }

    public void updateUser(User user) {
        userMapper.update(user);
    }

    public void deleteUser(Integer id) {
        userMapper.delete(id);
    }

    public void batchDeleteUser(List<Integer> ids) {
        for (Integer id : ids) {
            userMapper.delete(id);
        }
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public List<User> selectByMore(String username, String name) {
        return userMapper.selectByMore(username,name);
    }

    public List<User> selectByMo(String username, String name) {
        return userMapper.selectByMo(username,name);
    }

    public Page<User> selectByPage(Integer pageNum, Integer pageSize, String username, String name) {
        Integer skipNum = (pageNum-1)*pageSize; // 计算出来

        Page<User> page = new Page<>();
        List<User> userlist = userMapper.selectByPage(skipNum,pageSize,username,name);
        Integer total = userMapper.selectCountByPage(username,name);
        page.setTotal(total);
        page.setList(userlist);
        return page;
    }
}
