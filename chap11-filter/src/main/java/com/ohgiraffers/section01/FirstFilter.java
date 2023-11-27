package com.ohgiraffers.section01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/first/*")/*first로 시작되는 모든 요청을 받는다*/
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("first Filter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("firstFilter 인스턴스 생성");
    }

    @Override
    public void destroy() {
        System.out.println("filter destory 호출");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter do Filter 호출");

        chain.doFilter(request, response);

        System.out.println("servlet 수행 완료");
    }
}
