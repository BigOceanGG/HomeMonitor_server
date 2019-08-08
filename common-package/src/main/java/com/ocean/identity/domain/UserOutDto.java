package com.ocean.identity.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by shining on 2018/9/25.
 */
@Data
@ToString
public class UserOutDto {

    private Long id;
    //用户id
    private String userId;
    //手机号
    private String cellphone;
    //真实姓名
    private String userName;
//昵称
    private String nickName;
//邮件
    private String email;
    //生日
    private Date birthday;
    //头像
    private String avatar;
    //性别
    private Integer sex;
    //微信号
    private String wechatNo;
    //注册时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //是否禁用，1开启，2禁用
    private Integer enabled;
    //来源：1-BTC123 2-LINK-E 3-B91 4-甘肃旅游 5-溯源
    private Integer origin;
    //认证状态
    private Integer approveStatus;
//    //身份证号码
//    private String certNo;
//
//    private UserIdentityOutDto userIdentityOutDto;


}
