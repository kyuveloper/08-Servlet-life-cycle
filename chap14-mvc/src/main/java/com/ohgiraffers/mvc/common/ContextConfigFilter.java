package com.ohgiraffers.mvc.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터가 호출됨.");
        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null){
            String root = request.getServletContext().getRealPath("/");
            String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");

            System.out.println("db 접속 경로 설정");
            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
            System.out.println(ConfigLocation.CONNECTION_CONFIG_LOCATION);
        }

        chain.doFilter(request, response);
    }
}