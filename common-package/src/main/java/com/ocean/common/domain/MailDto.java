package com.ocean.common.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MailDto extends BaseDto {
    @ApiModelProperty(value = "接收人邮箱，必传")
    private String email;
    @ApiModelProperty(value = "发件人邮箱")
    private String from;
    @ApiModelProperty(value = "邮箱标题")
    private String subject;
    @ApiModelProperty(value = "内容")
    private String text;
    @ApiModelProperty(value = "发件人名称")
    private String personal;

}
