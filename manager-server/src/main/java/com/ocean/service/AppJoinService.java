package com.ocean.service;

import com.github.pagehelper.PageInfo;
import com.ocean.application.domain.ApplicationInDto;
import com.ocean.application.domain.ApplicationOutDto;

public interface AppJoinService {
    /**
     *  新增接入应用
     * @param applicationInDto 输入对象
     * @return 操作结果
     */
    boolean  addAppJoin(ApplicationInDto applicationInDto);

    /**
     *  查询接入应用
     * @param applicationInDto 输入对象
     * @return 操作结果
     */
    PageInfo<ApplicationOutDto> findAppInfo(ApplicationInDto applicationInDto);

    /**
     *  修改接入应用
     * @param applicationInDto 输入对象
     * @return 操作结果
     */
    boolean modifyAppInfo(ApplicationInDto applicationInDto);
}
