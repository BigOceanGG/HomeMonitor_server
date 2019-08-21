package com.ocean.login.domain;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class SysUserInDto {
    private String typeCode;
    private int id;
    private String account;
    private String password;
    private String cellphone;
    private String userName;
    private String nickName;
    private String email;
    private String avatar;
    private int sex;
    private String salt;
    private String confirmPassword;
    private int enabled;//链接是否已经被调用
}
