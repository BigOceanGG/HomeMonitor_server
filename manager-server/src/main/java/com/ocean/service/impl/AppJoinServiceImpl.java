package com.ocean.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ocean.application.domain.ApplicationInDto;
import com.ocean.application.domain.ApplicationOutDto;
import com.ocean.mapper.AppJoinMapper;
import com.ocean.mapper.OauthClientMapper;
import com.ocean.service.AppJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppJoinServiceImpl  implements AppJoinService {
    @Autowired
    private AppJoinMapper appJoinMapper;

    @Autowired
    private OauthClientMapper oauthClientMapper;

    @Override
    public boolean  addAppJoin(ApplicationInDto applicationInDto){
        if(appJoinMapper.addAppJoin(applicationInDto)){
            return oauthClientMapper.insertOauthClient(applicationInDto);
        }
        return false;
    }

    @Override
    public PageInfo<ApplicationOutDto> findAppInfo(ApplicationInDto applicationInDto){
        PageHelper.startPage(applicationInDto.getPageNum(),applicationInDto.getPageSize());
        List<ApplicationOutDto> identityList = appJoinMapper.findAppList(applicationInDto);
        PageInfo<ApplicationOutDto> appOutDtoPageInfo = new PageInfo<>(identityList);
        return appOutDtoPageInfo;
    }

    @Override
    public boolean modifyAppInfo(ApplicationInDto applicationInDto){
        if(appJoinMapper.modifyAppInfo(applicationInDto)){
            return oauthClientMapper.updateOauthClient(applicationInDto);
        }
        return false;
    }
}
