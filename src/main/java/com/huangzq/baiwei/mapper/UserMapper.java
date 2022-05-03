package com.huangzq.baiwei.mapper;

import com.huangzq.baiwei.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT id, username, password FROM t_user")
    List<User> queryAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    List<User> getById(Integer id);

    @Insert("insert into t_user (username,password) values (#{username},#{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(User user);

    @Select("SELECT id, username, password FROM t_user WHERE username = #{username} and password = #{password}")
    List<User> queryByUsernameAndPassword(User user);
}
