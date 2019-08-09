package com.ocean.identity.feign;

import com.github.pagehelper.PageInfo;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by shining on 2018/9/25.
 */
@FeignClient("manager-server")
public interface IdentityClient {
    @RequestMapping(value = "identity/queryIdentityPageList", method = RequestMethod.GET)

    public PageInfo<UserIdentityOutDto> queryUserPageList(
            @RequestParam("userId") String userId,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("state") Integer state,
            @RequestParam("origin") Integer origin,
            @RequestParam("pageNum") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(value = "identity/updateState", method = RequestMethod.POST)
    public Integer updateState(@RequestBody UserIdentityInDto userIdentityInDto);


    @RequestMapping(value = "identity/findByUserId", method = RequestMethod.GET)
    public UserIdentityOutDto findByUserId(@RequestParam("userId") Long userId);

}
