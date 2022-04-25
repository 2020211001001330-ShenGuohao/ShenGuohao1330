package com.ShenGuohao.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in Authfilter->init()");
    }

    public void destroy() {
        System.out.println("i am in Authfilter->destory()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("i am in Authfilter->dofilter()- before request come here");
        chain.doFilter(request, response);
        System.out.println("i am in Authfilter->dofilter()- after response come here");
    }
}
