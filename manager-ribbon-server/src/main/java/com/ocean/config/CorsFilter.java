package com.ocean.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域支持
 * @author wangyi
 * @TODO 需要缩小范围，并且需要增加鉴权
 */
@Component
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        //response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Headers", "*");
        //response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        //response.setHeader("Access-Control-Allow-Headers", "*");
        //Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization
        //response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        chain.doFilter(req, res);
    }
    

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}