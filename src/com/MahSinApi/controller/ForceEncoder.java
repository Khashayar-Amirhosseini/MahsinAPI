package com.MahSinApi.controller;

import javax.servlet.*;
import java.io.IOException;

public class ForceEncoder implements Filter {
    private String encoding = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        //  response.setContentType("text/html;charset=UTF-8");
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
