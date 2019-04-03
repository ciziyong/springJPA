package com.springboot.springbootjpa;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootjpaApplication.class, args);
        LoggerFactory.getLogger(SpringbootjpaApplication.class).info("启动成功");
    }

}
