package com.ocean.common.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SMSInDto {
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "短信内容")
    private String content;
    @ApiModelProperty(value = "语言类型")
    private String typeCode;
    @ApiModelProperty(value = "短信类型：1-注册短信 2-修改密码短信")
    private String smsType;
    @ApiModelProperty(value = "来源")
    private String origin;
    @ApiModelProperty(value = "IP地址")
    private String ipAddress;
}
