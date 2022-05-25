package com.ShenGuohao.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println(" i am in LoginFilter-->init()");
    }

    public void destroy() {
        System.out.println(" i am in LoginFilter-->destory()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println(" i am in LoginFilter-->doFilter(), request before chain");

        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;
        if(req.getSession().isNew()){
            req.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else {
            res.sendRedirect("login.jsp");
        }

        chain.doFilter(request, response);

        System.out.println(" i am in LoginFilter-->doFilter(), response after chain");
    }
}
