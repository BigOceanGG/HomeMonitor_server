package com.ocean.service;

import com.github.pagehelper.PageInfo;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;

public interface IdentityService {
    PageInfo<UserIdentityOutDto> findPageInfo(UserIdentityInDto identityInDto);

    Integer updateState(Long id,Integer state,String remark,Long userId);


    UserIdentityOutDto findByUserId(Long userId);

}
