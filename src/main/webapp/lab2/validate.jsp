<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>

    <jsp:useBean id="login" class="com.ShenGuohao.lab2.Login" scope="request"/>

    <jsp:setProperty name="login" property="username"/>
    <jsp:setProperty name="login" property="password"/>

<%
     if(login.getPassword().equals("admin") && login.getUsername().equals("admin")){
%>
     <jsp:forward page="welcome.jsp"/>

    <%}else {%>

<%
     out.println("username or password error message");

%>
     <jsp:include page="login.jsp"/>

    <%}%>

</body>
</html>