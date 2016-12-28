package com.carl.breakfast.dao.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Create by Administrator on 2016/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisConfigTest {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void jedisConnectionFactory() throws Exception {
        assertNotNull(redisConnectionFactory);
    }

    @Test
    public void redisTemplate() throws Exception {
        assertNotNull(redisTemplate);

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        assertNotNull(valueOperations);

        valueOperations.set("test_name", "carl");
        String name = valueOperations.get("test_name");

        assertNotNull(name);

        assertEquals("carl", name);
    }

}