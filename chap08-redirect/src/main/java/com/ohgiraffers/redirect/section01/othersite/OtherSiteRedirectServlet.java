package com.ohgiraffers.redirect.section01.othersite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get 요청 후 naver 사이트로 redirect");
        resp.sendRedirect("https://www.naver.com");
        /*
        * Web Server Port : 80
        * Was Server Port : 8080
        * Https Server Port : 443
        * */
    }
}
