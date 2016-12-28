package com.carl.breakfast.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisShardInfo;

/**
 * @author Carl
 * @date 2016/12/28
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:redis.properties")
})
public class RedisConfig {

    /*使用这个bean才能解析出${}语法*/
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public RedisConnectionFactory jedisConnectionFactory(@Value("${host}") String host, @Value("${port}") int port) {
        JedisShardInfo shardInfo = new JedisShardInfo(host, port);
        RedisConnectionFactory factory = new JedisConnectionFactory(shardInfo);
        return factory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
