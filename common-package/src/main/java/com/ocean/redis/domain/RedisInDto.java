package com.ocean.redis.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RedisInDto {
    @ApiModelProperty(value = "key值")
    private String key;
    @ApiModelProperty(value = "对应值")
    private String value;
    @ApiModelProperty(value = "设置秒数")
    private int second;
}
