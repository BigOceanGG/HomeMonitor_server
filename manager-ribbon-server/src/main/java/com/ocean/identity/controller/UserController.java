package com.ocean.identity.controller;

import com.github.pagehelper.PageInfo;
import com.ocean.common.domain.BaseController;
import com.ocean.common.domain.ResponseDto;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.domain.UserOutDto;
import com.ocean.identity.feign.IdentityClient;
import com.ocean.identity.feign.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by shining on 2018/9/25.
 */
@RestController
@Api(value = "用户信息", tags = "用户信息")
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserClient userClient;
    @Autowired
    private IdentityClient identityClient;

    /**
     * 查询项目类型列表
     *
     * @return 返回项目类型列表
     */
    @GetMapping("/getUsers")
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    public ResponseDto getUsers(UserInDto userInDto) {
        try {
            PageInfo<UserOutDto> userOutDtoPageInfo = userClient.queryUserPageList(userInDto.getUserId(),
                    userInDto.getStartTime(),userInDto.getEndTime(),
                    userInDto.getEnabled(),userInDto.getApproveStatus(),userInDto.getOrigin(),userInDto.getPageNum(),userInDto.getPageSize());
            return responseUtils.getReturnMessage(0, enumUtils.getTipMsg(userInDto.getTypeCode(),
                    "GET_USER_LIST_SUCCESSFUL").getMsg(),userOutDtoPageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(userInDto.getTypeCode(),
                    "GET_USER_LIST_FAILED").getCode(),enumUtils.getTipMsg(userInDto.getTypeCode(),
                    "GET_USER_LIST_FAILED").getMsg(),e);
        }
    }


    @GetMapping("/getIdentityByUserId")
    @ApiOperation(value = "通过用户Id查询用户实名认证", notes = "通过用户Id查询用户实名认证")
    public ResponseDto getIdentityByUserId(Long id) {
        try {
            UserIdentityOutDto userIdentityOutDto = identityClient.findByUserId(id);
            return responseUtils.getReturnMessage(0, enumUtils.getTipMsg("zh-cn",
                    "GET_USER_IDENTITY_SUCCESSFUL").getMsg(),userIdentityOutDto);
        }catch (Exception e){
            e.printStackTrace();
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg("zh-cn",
                    "GET_USER_IDENTITY_FAILED").getCode(),enumUtils.getTipMsg("zh-cn",
                    "GET_USER_IDENTITY_FAILED").getMsg(),e);
        }
    }


    /**
     * 保存项目信息
     * @param userInDto 输入条件
     * @return 返回结果
     */
    @PostMapping("/updateEnabled")
    @ApiOperation(value = "禁用，启用用户", notes = "禁用，启用用户")
    public ResponseDto updateEnabled(@RequestBody UserInDto userInDto){
        try {
            userClient.updateEnabled(userInDto);
            return responseUtils.getReturnMessage(0,enumUtils.getTipMsg(userInDto.getTypeCode(),
                    "UPDATE_USER_ENABLED_SUCCESSFUL").getMsg());
        }catch(Exception e){
            e.printStackTrace();
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(userInDto.getTypeCode(),"UPDATE_USER_ENABLED_FAILED").getCode(),
                    enumUtils.getTipMsg(userInDto.getTypeCode(),"UPDATE_USER_ENABLED_FAILED").getMsg(),e);
        }
    }
}
