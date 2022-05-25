<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/5/18
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab1</title>
</head>
<body>
             <%--
         <%
             String id=request.getParameter("id");
             String name=request.getParameter("name");
             String Class=request.getParameter("Class");

             out.println("name: "+name+"<br/>");
             out.println("class: "+Class+"<br/>");
             out.println("id: "+id);

         %>
                --%>

               name: ${param.name}  <br/>
               id: ${param.id}      <br/>
               Class: ${param.Class}


</body>
</html>
