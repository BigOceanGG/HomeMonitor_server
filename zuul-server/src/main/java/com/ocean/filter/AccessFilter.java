package com.ocean.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.ocean.domain.ResponseDto;
import com.ocean.utils.JWTUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@CrossOrigin
public class AccessFilter extends ZuulFilter  {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private JWTUtil jWTUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private  RestTemplate restTemplate;
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response=ctx.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String  requestURI=request.getRequestURI();
           String token =  "";
            ResponseDto rs = new ResponseDto();
            logger.info("获取token："+token);
            if(requestURI.indexOf("login/")>0
                    ||  requestURI.indexOf("common/") > 0
                    ||  requestURI.indexOf("/auth") > 0
                    ||  requestURI.indexOf("/geetest") > 0
            ){
                logger.info("requestURI："+requestURI);
//                addLogInfo(request);
            }
            else{
                logger.info("开始调用应用服务");
                if (token == null) {//token为空
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(401);
                    logger.info("获取token为空");
                    rs.setStatus(0);
                    rs.setMessage("获取token为空");
                    ctx.setResponseBody(JSONObject.fromObject(rs).toString());
                    return "token is empty";
                } else {//token验证通过
                    token = request.getHeader("token");
                    boolean ret = jWTUtil.verify(token);
                    if (ret) {
                          logger.info("获取token验证通过");
                        return "access token ok";
                    } else {
                        ctx.setSendZuulResponse(false);
                        ctx.setResponseStatusCode(401);
                        logger.info("获取token验证失败");
                        rs.setStatus(-1);
                        rs.setMessage("获取token验证失败");
                        String retStr = JSONObject.fromObject(rs).toString();
                        ctx.setResponseBody(retStr);
                        return "access token error";
                    }

                }
            }

        return "success";
    }

    public String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;
    }


//    public void addLogInfo(HttpServletRequest request) {
//        try{
//        HttpHeaders headers = new HttpHeaders();
//        ServiceInstance instance = client.getLocalServiceInstance();
//        String serviceId = instance.getServiceId();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        LogInfoInDto logInfoInDto = new LogInfoInDto();
//        String ipAddress = request.getHeader("ipAddress");
//        logInfoInDto.setIpAddress(ipAddress);
//        String account = request.getHeader("account");
//        logInfoInDto.setOperator(account);
//        String origin = request.getHeader("origin");
//        logInfoInDto.setOrigin(origin);
//        logInfoInDto.setRequestBusiness(request.getRequestURI());
//        logInfoInDto.setRequestMethod(request.getMethod());
//        logInfoInDto.setServiceId(serviceId);
//        HttpEntity<LogInfoInDto> entity = new HttpEntity<>(logInfoInDto, headers);
//        restTemplate.postForObject("http://RIBBON-SERVER/common/addLogInfo",entity,String.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


}
