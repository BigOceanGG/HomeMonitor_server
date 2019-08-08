package com.ocean.identity.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by shining on 2018/9/25.
 */
@Data
public class UserIdentityInDto {
    //id
    private Long id;
    //用户Id
    private String userId;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //审核状态  0 审核中  1 审核成功  2 审核失败
    private Integer state;
    //拒绝原因
    private String remark;
    //来源
    private Integer origin;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String typeCode = "zh-cn";




}
