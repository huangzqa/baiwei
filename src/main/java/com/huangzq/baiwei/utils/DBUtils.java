package com.huangzq.baiwei.utils;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * DBUtils
 * @author 22072
 */
public class DBUtils {
    @Resource
    private static ApplicationContext applicationContext;

    /**
     * 手动获取sqlSession
     * @return SqlSession
     */
    public static SqlSession getSession() {
        SqlSessionFactory bean = SpringContaxtHolder.getBean(SqlSessionFactory.class);
        return bean.openSession();
    }

}
