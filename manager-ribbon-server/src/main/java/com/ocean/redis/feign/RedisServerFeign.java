package com.ocean.redis.feign;

import com.ocean.redis.domain.RedisInDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("redis-server")
public interface RedisServerFeign {
    @PostMapping("/redis/setKeyValue")
    void setKeyValue(@RequestBody RedisInDto redisInDto);

    @PostMapping("/redis/getKeyValue")
    String getKeyValue(@RequestParam("key") String key);

    @PostMapping("/redis/setKeyValueByTime")
    void  setKeyValueByTime(@RequestBody RedisInDto redisInDto);

    @PostMapping("/redis/deleteKey")
    void  deleteKey(@RequestParam("key") String key);

    @PostMapping("/redis/getKeyExists")
    boolean  getKeyExists(@RequestParam("key") String key);

}
