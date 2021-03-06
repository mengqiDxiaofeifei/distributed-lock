package com.zhou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zhou.dao")// 导tk下的包
public class ZhouSpringbootLockApp {

    public static void main(String[] args) {
        SpringApplication.run(ZhouSpringbootLockApp.class, args);
    }
}
