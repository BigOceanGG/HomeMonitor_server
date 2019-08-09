package com.ocean.redis.controller;

import com.ocean.common.domain.ResponseDto;
import com.ocean.redis.domain.RedisInDto;
import com.ocean.redis.feign.RedisServerFeign;
import io.swagger.annotations.Api;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Redis服务", tags = "Redis服务")
@RequestMapping("/redis")
public class RedisServerFeignController {

    @Autowired
    private RedisServerFeign redisServerFeign;

    @PostMapping("/setKeyValue")
    public boolean setKeyValue(@RequestBody RedisInDto redisInDto){
        try {
            redisServerFeign.setKeyValue(redisInDto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/getKeyValue")
    public String getKeyValue(@RequestParam("key") String key){
        return redisServerFeign.getKeyValue(key);
    }

    @PostMapping("/setKeyValueByTime")
    public boolean setKeyValueByTime(@RequestBody RedisInDto redisInDto) {
        try {
            redisServerFeign.setKeyValueByTime(redisInDto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @PostMapping("/deleteKey")
    public boolean deleteKey(@RequestParam("key") String key){
        try{
            redisServerFeign.deleteKey(key);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    @GetMapping("/getKeyExists")
    public boolean  getKeyExists(@RequestParam("key") String key){
        return redisServerFeign.getKeyExists(key);
    }
}
