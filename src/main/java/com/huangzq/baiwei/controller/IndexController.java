package com.huangzq.baiwei.controller;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.result.DataResult;
import com.huangzq.baiwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public DataResult<User> login(@RequestBody User user) {
//        User user = new User(null, username, password);
        System.out.println(user);
        return service.login(user);
    }
}
