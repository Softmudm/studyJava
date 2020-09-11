package com.sz.user2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sz.user2.dao")
@EnableFeignClients
public class User2Application {

    public static void main(String[] args) {
        SpringApplication.run(User2Application.class, args);
    }

}
