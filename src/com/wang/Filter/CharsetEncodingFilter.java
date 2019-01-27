package com.wang.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import java.io.IOException;

/**
 * @author Rose
 * @create 2019/1/26
 * @since 1.0.0
 */
@WebFilter(filterName="Servlet3Filter",urlPatterns="/*",initParams={
        @WebInitParam(name = "encoder", value = "utf-8"),
        @WebInitParam(name = "contentype", value = "text/html;charset=utf-8")
})
public class CharsetEncodingFilter implements Filter {
    String encoder = null;

    String contentype = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoder = filterConfig.getInitParameter("encoder");

        contentype = filterConfig.getInitParameter("contentype");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置请求和回应编码
        //servletRequest.setCharacterEncoding("utf-8");
        servletRequest.setCharacterEncoding(encoder);

        //resp.setContentType("text/html;charset=utf-8");
        servletResponse.setContentType(contentype);

        //放行...
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}