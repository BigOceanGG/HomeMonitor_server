package com.ocean.controller;

import com.github.pagehelper.PageInfo;
import com.ocean.common.domain.BaseController;
import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.domain.UserOutDto;
import com.ocean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by shining on 2018/9/25.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserPageList",method = RequestMethod.GET)
    public PageInfo<UserOutDto> queryUserPageList(UserInDto userInDto){
        PageInfo<UserOutDto> pageInfo = userService.findPageInfo(userInDto);
        return pageInfo;
    }

    @RequestMapping(value = "/updateEnabled",method = RequestMethod.POST)
    public Integer updateEnabled(@RequestBody UserInDto userInDto){
        return userService.updateEnabled(userInDto.getId(),userInDto.getEnabled());
    }




}
