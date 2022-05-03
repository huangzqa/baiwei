package com.huangzq.baiwei.service;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryAll() {
        return userMapper.queryAll();
    }
    public List<User> getById(Integer id) {
        return userMapper.queryAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insert(User user) {
        Integer insert = userMapper.insert(user);
        System.out.println(1 / 0);
        return insert;
    }
}
