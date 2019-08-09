package com.ocean.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import com.ocean.mapper.IdentityMapper;
import com.ocean.mapper.UserMapper;
import com.ocean.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IdentityServiceImpl implements IdentityService {
    @Autowired
    private IdentityMapper identityMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<UserIdentityOutDto> findPageInfo(UserIdentityInDto identityInDto) {
        PageHelper.startPage(identityInDto.getPageNum(),identityInDto.getPageSize());
        List<UserIdentityOutDto> identityList = identityMapper.findIdentityList(identityInDto);
        PageInfo<UserIdentityOutDto> userIdentityOutDtoPageInfo = new PageInfo<>(identityList);
        return userIdentityOutDtoPageInfo;
    }

    @Override
    @Transactional
    public Integer updateState(Long id, Integer state, String remark,Long userId) {
        Integer status = identityMapper.auditUserIdentity(state, id, remark);
        if (status == 1 && state == 1){
            userMapper.updateUserApproveStatus(userId,2);
        }
       return status;
    }

    @Override
    public UserIdentityOutDto findByUserId(Long userId) {
        return identityMapper.findByUserId(userId);
    }
}