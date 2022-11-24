package com.huangzq.baiwei.service;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.result.DataResult;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    User queryByUsername(String username);

    DataResult<User> login(User user);

    List<User> getById(Integer id);

    DataResult<User> insert(User user);

    DataResult<User> updateById(User user);
}
