package com.ocean.utils;

import com.ocean.common.domain.BaseEnum;
import com.ocean.enums.ENEnum;
import com.ocean.enums.ZHCNEnum;
import org.springframework.stereotype.Component;

@Component
public class EnumUtils {

    public BaseEnum getTipMsg(String type,String name){
        BaseEnum baseEnum = new BaseEnum();
        if("zh-cn".equalsIgnoreCase(type)){
            ZHCNEnum zh =  ZHCNEnum.valueOf(name);
            baseEnum.setMsg(zh.getMsg());
            baseEnum.setCode(zh.getCode());
        }else if("en".equalsIgnoreCase(type)){
            ENEnum en =  ENEnum.valueOf(name);
            baseEnum.setMsg(en.getMsg());
            baseEnum.setCode(en.getCode());
        }
        return baseEnum;
    }
    public static void main(String []args){
        System.out.println(ZHCNEnum.valueOf("GETCOUNTRYSUCCESSFUL").getMsg());
//        int len = ZHCNEnum.values().length;
//        for(int i=0;i<len;i++){
//            if(1==(ZHCNEnum.values())[i].getCode()){
//                System.out.println((ZHCNEnum.values())[i].getMsg());
//            }
//        }
    }
}
