package com.ocean.service;

import com.github.pagehelper.PageInfo;
import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.domain.UserOutDto;

/**
 * Created by shining on 2018/9/25.
 */
public interface UserService {
    PageInfo<UserOutDto> findPageInfo(UserInDto userInDto);

    Integer updateEnabled(Long userId,Integer enabled);

}
