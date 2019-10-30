package com.muniao.redissentineldemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSentinelDemoApplicationTests
{

    @Autowired
    JedisSentinelPool jedisSentinelPool;

    @Test
    public void test1() throws InterruptedException
    {
        Jedis jedis = jedisSentinelPool.getResource();
        //jedis.set("k2", "v2");
        System.out.println(jedis.get("key1"));

    }

}
