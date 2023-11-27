package com.ohgiraffers.section02;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if("POST".equals(httpServletRequest.getMethod())){
            httpServletRequest.setCharacterEncoding(encodingType);
            System.out.println("변경된 인코딩 타입: " + httpServletRequest.getCharacterEncoding());
        }
        chain.doFilter(request, response);

    }
}