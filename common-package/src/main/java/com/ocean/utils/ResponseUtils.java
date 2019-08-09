package com.ocean.utils;


import com.ocean.common.domain.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {
    public ResponseDto getReturnMessage(Object ... data){//状态:0--- 1-返回信息 2-数据
                                                                 //-1---- 1-错误码 2-错误信息 3-异常信息
        ResponseDto responseDto = new ResponseDto();
                if((Integer)data[0]==0){
                        responseDto.setStatus(0);
                    if(data.length==2){
                        responseDto.setMessage((String)data[1]);
                    }
                    else if(data.length==3){
                        responseDto.setMessage((String)data[1]);
                        responseDto.setData(data[2]);
                    }
                }else{
                    if(data.length==3){
                        responseDto.setStatus(-1);
                        responseDto.setErrorCode((String)data[1]);
                        responseDto.setErrorMessage((String)data[2]);
                    }else{
                    responseDto.setStatus(-1);
                    responseDto.setErrorCode((String)data[1]);
                    responseDto.setErrorMessage((String)data[2]);
                    responseDto.setException(data[3]);}
                }
        return responseDto;
    }
}
