package com.carl.breakfast.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 基础配置
 * @author Carl
 * @date 2017/1/2
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class BaseConfig {
    /*使用这个bean才能解析出${}语法*/
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
