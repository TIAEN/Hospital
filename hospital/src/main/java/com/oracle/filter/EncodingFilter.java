package com.oracle.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/*
* 过滤器不能直接被请求
* 仅在请求响应时作出处理
* 执行过滤器的执行处理操作
* /abc
*
*
* */


//这里需要说明过滤器针对谁生效，这里表示对所有请求
@WebFilter("/*")
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        //在过滤器中执行完处理后需要进行页面导航
        //执行正确的导航77777
        filterChain.doFilter(servletRequest,servletResponse);   //放行
    }

    @Override
    public void destroy() {

    }
}
