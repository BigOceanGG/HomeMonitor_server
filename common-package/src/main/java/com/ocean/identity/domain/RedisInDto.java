package com.ocean.identity.domain;
import lombok.Data;

@Data
public class RedisInDto {
    private String key;
    private String value;
    private int timeout;
}
