package com.ocean.controller;

import com.github.pagehelper.PageInfo;
import com.ocean.common.domain.BaseController;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import com.ocean.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangjuan
 * @create 2018/8/10
 */
@RestController
@RequestMapping("/identity")
public class IdentityController extends BaseController {

    @Autowired
    private IdentityService identityService;

    @RequestMapping(value = "/queryIdentityPageList", method = RequestMethod.GET)
    public PageInfo<UserIdentityOutDto> queryUserPageList(UserIdentityInDto identityInDto) {
        PageInfo<UserIdentityOutDto> pageInfo = identityService.findPageInfo(identityInDto);
        return pageInfo;
    }

    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    public Integer updateState(@RequestBody UserIdentityInDto identityInDto) {
        return identityService.updateState(identityInDto.getId(), identityInDto.getState(), identityInDto.getRemark(),Long.parseLong(identityInDto.getUserId()));
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public UserIdentityOutDto findByUserId(Long userId) {
        return identityService.findByUserId(userId);
    }


}
