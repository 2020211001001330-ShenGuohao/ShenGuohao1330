package com.ShenGuohao.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
    private int count=0;
    public  LifeCycleServlet(){
        System.out.println("i am in defalut constructor()");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("i am in init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        count++;
        System.out.println("i am in doGet()");

        out.println("Since loading ,this servlet has been accessed "+count+" times");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doPost()");

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("i am in destory()");
    }

}
