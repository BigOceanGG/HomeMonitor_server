package com.ocean.identity.controller;

import com.github.pagehelper.PageInfo;
import com.ocean.application.domain.ApplicationInDto;
import com.ocean.application.domain.ApplicationOutDto;
import com.ocean.common.domain.BaseController;
import com.ocean.common.domain.ResponseDto;
import com.ocean.identity.feign.AppJoinClient;
import com.ocean.redis.domain.RedisInDto;
import com.ocean.redis.feign.RedisServerFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "应用接入", tags = "应用接入")
@RequestMapping("/app")
public class AppJoinController extends BaseController {
    @Autowired
    private AppJoinClient appJoinClient;
    @Autowired
    private RedisServerFeign redisServerFeign;

    @PostMapping("/addAppJoin")
    @ApiOperation(value = "新增应用",notes = "新增应用")
    public ResponseDto addAppJoin(@RequestBody ApplicationInDto applicationInDto){
        try {
            appJoinClient.addAppJoin(applicationInDto);
            return  responseUtils.getReturnMessage(0,enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "ADD_APP_STATE_SUCCESSFUL").getMsg(),applicationInDto);
        }catch (Exception e) {
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "ADD_APP_STATE_FAILED").getCode(),enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "ADD_APP_STATE_FAILED").getMsg(),e);
        }
    }

    @GetMapping("/findAppInfo")
    @ApiOperation(value = "查询应用",notes = "查询应用")
    public ResponseDto findAppInfo(ApplicationInDto applicationInDto){
        try {
            RedisInDto redis = new RedisInDto();
            redis.setKey("123");
            redis.setValue("456");
            redisServerFeign.setKeyValue(redis);
            String value = redisServerFeign.getKeyValue("123");
            PageInfo<ApplicationOutDto> appPageInfo = appJoinClient.findAppInfo(applicationInDto);
            return  responseUtils.getReturnMessage(0,enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "FIND_APP_STATE_SUCCESSFUL").getMsg(),appPageInfo);
        }catch (Exception e) {
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "FIND_APP_STATE_FAILED").getCode(),enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "FIND_APP_STATE_FAILED").getMsg(),e);
        }

    }

    @PostMapping("/modifyAppInfo")
    @ApiOperation(value = "修改应用",notes = "修改应用")
    public ResponseDto modifyAppInfo(@RequestBody ApplicationInDto applicationInDto){
        try {
            appJoinClient.modifyAppInfo(applicationInDto);
            return  responseUtils.getReturnMessage(0,enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "UPDATE_APP_STATE_SUCCESSFUL").getMsg(),applicationInDto);
        }catch (Exception e) {
            return responseUtils.getReturnMessage(-1,enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "UPDATE_APP_STATE_FAILED").getCode(),enumUtils.getTipMsg(applicationInDto.getTypeCode(),
                    "UPDATE_APP_STATE_FAILED").getMsg(),e);
        }
    }
}
