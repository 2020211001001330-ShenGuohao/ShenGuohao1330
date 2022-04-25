package com.ShenGuohao.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter")
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter->init()");
    }

    public void destroy() {
        System.out.println("i am in HelloFilter->destory()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter->dofilter()- before request come here");
        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter->dofilter()- after response come here");
    }
}
