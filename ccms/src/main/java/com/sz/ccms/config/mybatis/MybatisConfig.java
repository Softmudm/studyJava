package com.sz.ccms.config.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
public class MybatisConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("classpath:dao");
        Properties propertiesMapper = new Properties();
        propertiesMapper.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        propertiesMapper.setProperty("IDENTITY", "SELECT UUID()");
        propertiesMapper.setProperty("ORDER", "BEFORE");
        mapperScannerConfigurer.setProperties(propertiesMapper);
        return mapperScannerConfigurer;
    }
}
