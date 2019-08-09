package com.ocean.identity.feign;

import com.github.pagehelper.PageInfo;
import com.ocean.common.domain.ResponseDto;
import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.domain.UserOutDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@FeignClient("manager-server")
public interface UserClient {


    //    private Long id;
//    private Date startTime;
//    private Date endTime;
//    private Integer enabled;
//    private Integer approveStatus;
//    //来源：1-BTC123 2-LINK-E 3-B91 4-甘肃旅游 5-溯源
//    private Integer origin;
//    private Integer pageNumber;
//    private Integer pageSize;
//
    @RequestMapping(value = "user/queryUserPageList", method = RequestMethod.GET)
    public PageInfo<UserOutDto> queryUserPageList(
            @RequestParam("userId") String userId, @RequestParam("startTime")  String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("enabled") Integer enabled,
            @RequestParam("approveStatus") Integer approveStatus,
            @RequestParam("origin") Integer origin,
            @RequestParam("pageNum") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(value = "user/updateEnabled", method = RequestMethod.POST)
    public Integer updateEnabled(@RequestBody UserInDto userInDto);

}
