package com.huangzq.baiwei.controller;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.result.DataResult;
import com.huangzq.baiwei.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {
    @Resource
    private UserService userService;

    //登录接口
    @PostMapping("/login")
    public DataResult<String> login(@RequestBody User user) {
        DataResult<String> result = new DataResult<>();
        User trueUser = userService.queryByUsername(user.getUsername());
        if (trueUser == null) {
            result.setMsg("该用户不存在！");
            return result;
        }
        if (!trueUser.getPassword().equals(user.getPassword())) {
            result.setMsg("账户或密码错误！");
            return result;
        }
        result.setMsg("登录成功！");
        return result;
    }

    //注销接口
    @PostMapping("/logout")
    public DataResult<String> logout(@RequestHeader("token") String token) {
        //删除redis缓存中的token
//        stringRedisTemplate.delete(token);
        DataResult<String> result = new DataResult<>();
        result.setMsg("注销成功！");
        return result;
    }
}
