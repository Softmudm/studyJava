package com.sz.wx.redis;

import com.sz.wx.service.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    PaperService paperService;

    @Test
    public void TestString(){
        stringRedisTemplate.opsForValue().set("k1","v1");
        System.out.println(stringRedisTemplate.opsForValue().get("k1"));
    }
    @Test
    public void TestApi(){
        System.out.println(paperService.getPaperByPaperid(1));
    }
}
