<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%--
if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")){
    String url="welcome.jsp?username="+request.getParameter("username");
    response.sendRedirect(url);
}else{
    request.setAttribute("message","Username Password Error");
    request.getRequestDispatcher("login.jsp").include(request,response);
}
--%>

<c:choose>
    <c:when test="${param.username.equals('admin')&& param.password.equals('admin')}">
         <c:url var="u" value="welcome.jsp" scope="request">
            <c:param name="username" value="admin"/>
        </c:url>
        <c:redirect url="${u}"/>
    </c:when>

<c:otherwise>
    <c:set var="message" value="username password error" scope="request"/>
    <c:import url="login.jsp"/>
</c:otherwise>
    </c:choose>
</body>
</html>
