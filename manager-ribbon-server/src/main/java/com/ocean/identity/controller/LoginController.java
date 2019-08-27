package com.ocean.identity.controller;

import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.feign.UserClient;
import com.ocean.common.domain.BaseController;
import com.ocean.common.domain.ResponseDto;
import com.ocean.login.domain.SysUserInDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

@RestController
@Api(value = "系统用户", tags = "系统用户")
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private UserClient userClient;

    @PostMapping("/loginSysUser")
    @ApiOperation(value = "系统用户登录",notes = "系统用户登录")
    public ResponseDto loginSysUser(@RequestBody SysUserInDto userInDto) {
        String cellphone = userInDto.getCellphone();
        String password = userInDto.getPassword();
        String typeCode = userInDto.getTypeCode();
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("avatar",userInDto.getAvatar());
        retMap.put("userId",userInDto.getId());
        retMap.put("userName",userInDto.getUserName());
        map.put("user",retMap);
        map.put("token","aabbcc");
        map.put("roleList","admin");
        return responseUtils.getReturnMessage(0, enumUtils.getTipMsg(userInDto.getTypeCode(), "LOGIN_SUCCESSFUL").getMsg(),map);
    }
}