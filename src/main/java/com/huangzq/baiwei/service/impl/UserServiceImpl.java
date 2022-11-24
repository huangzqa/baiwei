package com.huangzq.baiwei.service.impl;

import com.huangzq.baiwei.bean.User;
import com.huangzq.baiwei.mapper.UserMapper;
import com.huangzq.baiwei.result.DataResult;
import com.huangzq.baiwei.service.UserService;
import com.huangzq.baiwei.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public List<User> queryAll() {
        try (SqlSession sqlSession = DBUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.queryAll();
        }
    }

    public User queryByUsername(String username) {
        try (SqlSession sqlSession = DBUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.queryByUsername(username);
        }
    }

    public DataResult<User> login(User user) {
        DataResult<User> result = new DataResult<>();
        List<User> users;
        try (SqlSession sqlSession = DBUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            users = userMapper.queryByUsernameAndPassword(user);
        }
        result.setResult(users);
        if (users.isEmpty()) {
            result.setSuccess(false);
            result.setMsg("用户名或密码错误");
            return result;
        }
        result.setMsg("登录成功");
        result.setSuccess(true);
        return result;
    }

    public List<User> getById(Integer id) {
        try (SqlSession sqlSession = DBUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getById(id);
        }
    }

    public DataResult<User> insert(User user) {
        DataResult<User> result = new DataResult<>();
        int insert = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            insert = userMapper.insert(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (insert == 1) {
            result.setSuccess(true);
            result.setMsg("增加成功");
        } else {
            result.setSuccess(false);
            result.setMsg("增加失败！");
        }
        return result;
    }

    public DataResult<User> updateById(User user) {
        DataResult<User> result = new DataResult<>();
        Integer id = user.getId();
        if (id == null) {
            result.setSuccess(false);
            result.setMsg("请输入id");
            return result;
        }
        int update = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            update = userMapper.updateById(user);
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (update == 1) {
            result.setSuccess(true);
            result.setMsg("修改成功");
        } else {
            result.setSuccess(false);
            result.setMsg("未查询到相关用户！");
        }
        return result;
    }
}
