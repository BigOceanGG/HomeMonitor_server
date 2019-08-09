package com.ocean.controller;

import com.github.pagehelper.PageInfo;
import com.ocean.application.domain.ApplicationInDto;
import com.ocean.application.domain.ApplicationOutDto;
import com.ocean.common.domain.BaseController;
import com.ocean.service.AppJoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/app")
@Api(value = "接入应用", tags = "接入应用")
public class AppJoinController extends BaseController {
    @Autowired
    private AppJoinService appJoinService;

    @PostMapping("/addAppJoin")
    @ApiOperation(value = "新增应用",notes = "新增应用")
    public boolean  addAppJoin(@RequestBody ApplicationInDto applicationInDto){
        if(applicationInDto.getApplicationId() == null || applicationInDto.getApplicationId().isEmpty()) {
            applicationInDto.setApplicationId(createClientId());
        }
        if(applicationInDto.getApplicationKey() == null || applicationInDto.getApplicationKey().isEmpty()) {
            applicationInDto.setApplicationKey(createClentSecret(32));
        }
       return  appJoinService.addAppJoin(applicationInDto);
    }

    @PostMapping("/findAppInfo")
    @ApiOperation(value = "查询应用",notes = "查询应用")
    public PageInfo<ApplicationOutDto> findAppInfo(@RequestBody ApplicationInDto applicationInDto){
        return appJoinService.findAppInfo(applicationInDto);
    }

    @PostMapping("/modifyAppInfo")
    @ApiOperation(value = "修改应用",notes = "修改应用")
    public boolean modifyAppInfo(@RequestBody ApplicationInDto applicationInDto){
        return appJoinService.modifyAppInfo(applicationInDto);
    }

    public String createClientId() {
        StringBuffer strClientId = new StringBuffer();
        strClientId.append("pulsar_");
        long id = (long) ((Math.random() * 9 + 1) * 100000);
        String num = String.format("%06d", id);
        strClientId.append(num);
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmm");
        strClientId.append(df.format(new Date()));
        Random random = new Random();
        strClientId.append(random.nextInt(100) + 10);
        return strClientId.toString();
    }

    public String createClentSecret(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
