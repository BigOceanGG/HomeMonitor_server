package com.ocean.identity.controller;

import com.github.pagehelper.PageInfo;
import com.ocean.common.domain.BaseController;
import com.ocean.common.domain.ResponseDto;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.feign.IdentityClient;
import com.ocean.identity.feign.UserClient;
//import com.ocean.identity.domain.ProjectInDto;
//import com.ocean.identity.domain.ProjectOutDto;
//import com.ocean.identity.domain.ShelfStatusOutDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api(value = "实名认证", tags = "实名认证")
@RequestMapping("/identity")
public class IdentityController extends BaseController {
    @Autowired
    private IdentityClient identityClient;

    /**
     * 查询项目类型列表
     *
     * @return 返回项目类型列表
     */
    @GetMapping("/getIdentity")
    @ApiOperation(value = "查询用户列实名认证列表", notes = "查询用户实名认证列表")
    public ResponseDto getIdentity(UserIdentityInDto identityInDto) {
        try {
            PageInfo<UserIdentityOutDto> userIdentityOutDtoPageInfo = identityClient.queryUserPageList(identityInDto.getUserId(),
                    identityInDto.getStartTime(),identityInDto.getEndTime(),
                    identityInDto.getState(),identityInDto.getOrigin(),identityInDto.getPageNum(),identityInDto.getPageSize());
            return responseUtils.getReturnMessage(0, enumUtils.getTipMsg(identityInDto.getTypeCode(),
                    "GET_USER_IDENTITY_LIST_SUCCESSFUL").getMsg(),userIdentityOutDtoPageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(identityInDto.getTypeCode(),
                    "GET_USER_IDENTITY_LIST_FAILED").getCode(),enumUtils.getTipMsg(identityInDto.getTypeCode(),
                    "GET_USER_IDENTITY_LIST_FAILED").getMsg(),e);
        }
    }




    /**
     * 保存项目信息
     * @param identityInDto 输入条件
     * @return 返回结果
     */
    @PostMapping("/updateState")
    @ApiOperation(value = "修改用户审核状态", notes = "修改用户审核状态")
    public ResponseDto updateState(@RequestBody UserIdentityInDto identityInDto){
        try {
            identityClient.updateState(identityInDto);
            return responseUtils.getReturnMessage(0,enumUtils.getTipMsg(identityInDto.getTypeCode(),
                    "UPDATE_IDENTITY_STATE_SUCCESSFUL").getMsg());
        }catch(Exception e){
            e.printStackTrace();
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(identityInDto.getTypeCode(),"UPDATE_IDENTITY_STATE_FAILED").getCode(),
                    enumUtils.getTipMsg(identityInDto.getTypeCode(),"UPDATE_IDENTITY_STATE_FAILED").getMsg(),e);
        }
    }
}
