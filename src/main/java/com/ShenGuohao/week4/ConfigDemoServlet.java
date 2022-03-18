package com.ShenGuohao.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet",
           urlPatterns = {"/config"},
           initParams = {
               @WebInitParam(name = "username",value ="ShenGuohao" ),
               @WebInitParam(name = "studentId",value = "2020211001001330")
           }

)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           ServletConfig config=getServletConfig();
           String username=config.getInitParameter("username");
           String studentId=config.getInitParameter("studentId");
           PrintWriter writer = response.getWriter();

           writer.println("username: "+username);
           writer.println("studentId: "+studentId);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
