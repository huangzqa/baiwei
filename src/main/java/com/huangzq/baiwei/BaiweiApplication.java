package com.huangzq.baiwei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.huangzq.baiwei.mapper")
public class BaiweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiweiApplication.class, args);
    }

}
