package com.ocean.identity.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserIdentityOutDto {

    private Long id;
    private Long userId;
    private String cellphone;
    private String email;
    //身份证正面
    private String positiveImg;
    //身份证反面
    private String backImg;
    //手持照片
    private String holdImg;
    //申请时间
    private Date createTime;
    //审核状态  0 审核中  1 审核成功  2 审核失败
    private Integer state;
    //身份证号码
    private String certNo;
    //真实名称
    private String userName;
    //拒绝原因
    private String remark;
    //来源
    private Integer origin;




}