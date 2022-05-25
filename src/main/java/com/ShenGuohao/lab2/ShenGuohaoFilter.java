package com.ShenGuohao.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "ShenGuohaoFilter")
public class ShenGuohaoFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println(" i am in ShenGuohaoFilter-->doFilter(), request before chain");
        chain.doFilter(request, response);
        System.out.println(" i am in ShenGuohaoFilter-->doFilter(), response after chain");
    }
}
