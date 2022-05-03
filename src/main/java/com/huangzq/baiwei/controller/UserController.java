package com.huangzq.baiwei.controller;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.result.DataResult;
import com.huangzq.baiwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/queryAll")
    public DataResult<User> queryAll() {
        DataResult<User> result = new DataResult<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("查询成功");
        result.setResult(userService.queryAll());
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public DataResult<User> queryAll(@PathVariable("id") Integer id) {
        System.out.println("获取的id:"+id);
        DataResult<User> result = new DataResult<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("查询成功");
        result.setResult(userService.getById(id));
        return result;
    }
    @PostMapping("/insert")
    public DataResult<User> insert(@RequestBody User user) {
        DataResult<User> result = new DataResult<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("添加成功");
        try {
            Integer insert = userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        user.setId(insert);
        List<User> results = new ArrayList<>();
        results.add(user);
        result.setResult(results);
        return result;
    }
}
