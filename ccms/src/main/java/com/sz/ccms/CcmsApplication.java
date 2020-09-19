package com.sz.ccms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.sz.ccms.dao")
public class CcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcmsApplication.class, args);
    }

}
