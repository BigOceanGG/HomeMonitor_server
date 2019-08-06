package com.ocean.domain;

import lombok.Data;

@Data
public class ResponseDto {
    private String message;
    private Object data;
    private Integer status;
    private String errorCode;
    private String errorMessage;
    private Object exception;
}
