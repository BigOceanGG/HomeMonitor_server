package com.ocean.controller;

import com.ocean.redis.domain.RedisInDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisControler {

    private final Logger logger = LoggerFactory.getLogger(RedisControler.class);

    @Autowired
    protected RedisTemplate redisTemplate;


    /**
     * 获取key是否存在
     * @param key key值
     * @return 返回是否存在
     */
    @PostMapping("/getKeyExists")
    public boolean  getKeyExists(@RequestParam("key") String key){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //缓存存在
        return  redisTemplate.hasKey(key);

    }


    /**
     * 设置值设定过期时间
     * @param redisInDto 输入对象
     */
    @PostMapping("/setKeyValueByTime")
    public void  setKeyValueByTime(@RequestBody RedisInDto redisInDto){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //缓存不存在，将数据存入缓存
        operations.set(redisInDto.getKey(), redisInDto.getValue(), redisInDto.getSecond(), TimeUnit.SECONDS);

    }

    /**
     * 设置值
     * @param redisInDto 输入参数
     */
    @PostMapping("/setKeyValue")
    public void  setKeyValue(@RequestBody RedisInDto redisInDto){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //缓存不存在，将数据存入缓存
        operations.set(redisInDto.getKey(), redisInDto.getValue());
    }

    /**
     * 设置key和value映射
     * @param key key值
     */
    @PostMapping("/getKeyValue")
    public String getKeyValue(@RequestParam("key") String key){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }



}
