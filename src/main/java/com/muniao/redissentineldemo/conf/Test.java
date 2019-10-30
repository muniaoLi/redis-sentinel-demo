package com.muniao.redissentineldemo.conf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class Test
{
    public static void main(String[] args)
    {
        Jedis jedis = new Jedis("192.168.0.161", 6380);
        String value = jedis.get("k2");
        System.out.println(value);

        Set<String> set = new HashSet<>();
        set.add("127.0.0.1:26679");
        set.add("127.0.0.1:26479");
        set.add("127.0.0.1:26579");
        JedisSentinelPool jsp = new JedisSentinelPool("mymaster", set);

        Jedis jedis1 = jsp.getResource();
        System.out.println(jedis1.get("k2"));
    }
}
