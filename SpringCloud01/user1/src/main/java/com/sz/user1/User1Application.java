package com.sz.user1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sz.user1.dao")
@EnableFeignClients
public class User1Application {

    public static void main(String[] args) {
        SpringApplication.run(User1Application.class, args);
    }

}
