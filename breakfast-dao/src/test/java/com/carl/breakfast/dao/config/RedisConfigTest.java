package com.carl.breakfast.dao.config;

import com.carl.breakfast.dao.config.redis.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Random;

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

    @Test
    public void testSet() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        int count = 0;
        while (true) {
            Random forDom = new Random();
            Random witeDom = new Random();
            count++;

            int forCount = forDom.nextInt(1000) + 1;
            System.out.println("正在执行次数：" + count + "," + forCount);
            for (int i = 0, l = forCount; i < l; i++) {
                valueOperations.set("k" + count + "-" + i, "v" + count + "-" + i);
                try {
                    int w = witeDom.nextInt(15) + 1;
                    Thread.sleep(w);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

}