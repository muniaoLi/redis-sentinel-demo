package com.muniao.redissentineldemo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Set;

@Configuration
public class RedisConfig
{
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWaitMillis;

    @Value("${spring.redis.sentinel.nodes}")
    private Set<String> sentinelNodes;

    @Value("${spring.redis.sentinel.master}")
    private String sentinelMaster;

    @Bean
    public JedisSentinelPool jedisSentinelPool()
    {
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(maxIdle);
        jpc.setMaxWaitMillis(maxWaitMillis);
        jpc.setMaxTotal(maxActive);
        jpc.setMinIdle(minIdle);

        JedisSentinelPool jsp = new JedisSentinelPool(sentinelMaster, sentinelNodes, jpc);
        return jsp;
    }

}
