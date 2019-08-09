package com.ocean.mapper;

import com.ocean.application.domain.ApplicationInDto;
import com.ocean.application.domain.ApplicationOutDto;

import java.util.List;

public interface AppJoinMapper {
    boolean  addAppJoin(ApplicationInDto applicationInDto);

    List<ApplicationOutDto> findAppList(ApplicationInDto userIdentityInDto);

    boolean modifyAppInfo(ApplicationInDto applicationInDto);
}
