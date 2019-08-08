package com.pulsar.identity.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by shining on 2018/9/25.
 */
@Data
public class UserInDto {
    //id
    private Long id;
    //用户id
    private String userId;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //锁定状态
    private Integer enabled;
    //认证状态
    private Integer approveStatus;
    //来源：1-BTC123 2-LINK-E 3-B91 4-甘肃旅游 5-溯源
    private Integer origin;
    private Integer pageNum=1;
    private Integer pageSize=10;
    private String typeCode="zh-cn";



}
