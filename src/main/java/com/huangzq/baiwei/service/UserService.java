package com.huangzq.baiwei.service;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.mapper.UserMapper;
import com.huangzq.baiwei.result.DataResult;
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
    public DataResult<User> login(User user) {
        DataResult<User> result = new DataResult<>();
        List<User> users = userMapper.queryByUsernameAndPassword(user);
        result.setResult(users);
        if (users.isEmpty()){
            result.setSuccess(false);
            result.setMsg("用户名或密码错误");
            return result;
        }
        result.setMsg("登录成功");
        result.setSuccess(true);
        return result;
    }
    public List<User> getById(Integer id) {
        return userMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insert(User user) {
        Integer insert = userMapper.insert(user);
        System.out.println(1 / 0);
        return insert;
    }
}
