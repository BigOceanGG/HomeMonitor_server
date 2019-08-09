package com.ocean.identity.feign;

import com.github.pagehelper.PageInfo;
import com.ocean.application.domain.ApplicationInDto;
import com.ocean.application.domain.ApplicationOutDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("manager-server")
public interface AppJoinClient {

    @RequestMapping("/app/addAppJoin")
    public boolean  addAppJoin(@RequestBody ApplicationInDto applicationInDto);

    @RequestMapping("/app/findAppInfo")
    public PageInfo<ApplicationOutDto> findAppInfo(@RequestBody ApplicationInDto applicationInDto);

    @RequestMapping("/app/modifyAppInfo")
    public boolean modifyAppInfo(@RequestBody ApplicationInDto applicationInDto);
}
