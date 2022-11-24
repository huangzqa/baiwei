package com.huangzq.baiwei.controller;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.result.DataResult;
import com.huangzq.baiwei.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author huangzq
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/queryAll")
    public DataResult<User> queryAll() {
        DataResult<User> result = new DataResult<>();
        result.setSuccess(true);
        result.setMsg("查询成功");
        result.setResult(userService.queryAll());
        return result;
    }

    @PostMapping("/queryByUsername")
    public DataResult<User> queryAll(@RequestParam String username, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        LOGGER.info("parameterMap----{}", parameterMap);
        LOGGER.info("获取到的username----{}", username);
        DataResult<User> result = new DataResult<>();
        User user = userService.queryByUsername(username);
        result.setSuccess(true);
        result.setMsg("查询成功");
        if (user == null) {
            result.setResult(new ArrayList<>());
        } else {
            result.setTotal(1);
            ArrayList<User> users = new ArrayList<>();
            users.add(user);
            result.setResult(users);
        }
        return result;
    }

    @GetMapping("/get/{id}")
    public DataResult<User> queryAll(@PathVariable("id") Integer id) {
        System.out.println("获取的id:" + id);
        DataResult<User> result = new DataResult<>();
        result.setSuccess(true);
        result.setMsg("查询成功");
        result.setResult(userService.getById(id));
        return result;
    }

    @PostMapping("/add")
    public DataResult<User> insert(@RequestBody User user) {
        DataResult<User> result = new DataResult<>();
        try {
            result = userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update")
    public DataResult<User> update(@RequestBody User user) {
        DataResult<User> result = new DataResult<>();
        try {
            result = userService.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }


}
