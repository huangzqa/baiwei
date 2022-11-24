package com.huangzq.baiwei.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用于获取springcontext（spring的上下文）对象
 * @author huangzq
 */
@Component
public class SpringContaxtHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContaxtHolder.applicationContext = applicationContext;
    }

    /**
     * 获取上下文
     * @return
     */
    public static ApplicationContext getContext() {
        return SpringContaxtHolder.applicationContext;
    }

    /**
     * 通过name获取bean
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return SpringContaxtHolder.applicationContext.getBean(name);
    }

    /**
     * 通过class获取bean
     * @param aClass
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> aClass) {
        return SpringContaxtHolder.applicationContext.getBean(aClass);
    }
}
