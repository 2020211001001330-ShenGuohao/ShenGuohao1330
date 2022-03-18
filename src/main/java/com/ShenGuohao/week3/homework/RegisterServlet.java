package com.ShenGuohao.week3.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement sql=null;
    ResultSet res=null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("Id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        String birthday=request.getParameter("birthday");

        PrintWriter out=response.getWriter();
        response.setContentType("text/html");

        try {
            sql=con.prepareStatement("INSERT INTO usertable values (?,?,?,?,?,?)");
            sql.setString(1,Id);
            sql.setString(2,username);
            sql.setString(3,password);
            sql.setString(4,Email);
            sql.setString(5,Gender);
            sql.setString(6,birthday);
            sql.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            sql=con.prepareStatement("SELECT * FROM usertable");
            res= sql.executeQuery();

            out.println  ("<html><body>\n" +
                    "        <table width=\"600\" border=\"1\">\n" +
                    "            <tr>\n" +
                    "                 <td>ID</td>\n" +
                    "                 <td>Username</td>\n" +
                    "                 <td>Password</td>\n" +
                    "                 <td>Email</td>\n" +
                    "                 <td>Gender</td>\n" +
                    "                 <td>Birthday</td>\n" +
                    "            </tr>\n" );

            while (res.next()){
                Id=res.getString("Id");
                username=res.getString("username");
                password=res.getString("password");
                Email=res.getString("Email");
                Gender=res.getString("Gender");
                birthday=res.getString("birthday");

                out.println("<tr>");
                out.println("<td>"+Id+"</td>");
                out.println("<td>"+username+"</td>");
                out.println("<td>"+password+"</td>");
                out.println("<td>"+Email+"</td>");
                out.println("<td>"+Gender+"</td>");
                out.println("<td>"+birthday+"</td>");
                out.println("</tr>");
            }
            out.println("        </table>\n" +
                    "</body></html>");
            out.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//--------        week3  Code  ------------------------
//        PrintWriter writer=response.getWriter();
//        writer.println("<br> username: "+username);
//        writer.println("<br> password: "+password);
//        writer.println("<br> Email: "+Email);
//        writer.println("<br> Gender: "+Gender);
//        writer.println("<br> Date: "+Date);
//        writer.close();
//-----------------------------------------------------

}

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context=getServletContext();
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        String url=context.getInitParameter("url");
        String driver=context.getInitParameter("driver");


        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("register:init()-->con:"+con);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }



    }
}
