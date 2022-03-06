package com.ShenGuohao.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        writer.println("Name: ShenGuohao");
        writer.println("ID: 2020211001001330");
        writer.println("Date and Time :Sun, 06 Mar 2022 11:30:40 GMT");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
