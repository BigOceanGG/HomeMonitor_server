package com.ocean.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.domain.UserOutDto;
import com.ocean.mapper.UserMapper;
import com.ocean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shining on 2018/9/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<UserOutDto> findPageInfo(UserInDto userInDto) {
        PageHelper.startPage(userInDto.getPageNum(), userInDto.getPageSize());
        List<UserOutDto> userList = userMapper.findUserList(userInDto);
        PageInfo<UserOutDto> userOutDtoPageInfo = new PageInfo<>(userList);
        return userOutDtoPageInfo;
    }

    @Override
    @Transactional
    public Integer updateEnabled(Long userId, Integer enabled) {
       return userMapper.updateUserEnabled(userId,enabled);
    }
}
