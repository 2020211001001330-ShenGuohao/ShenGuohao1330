<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/3/25
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
<%
       if(!(request.getAttribute("message")==null)){
           out.println(request.getAttribute("message"));
       }
%>

<h1>Login</h1>
<form method="post" action="login">
    username: <input name="username" type="text"> <br/>
    password: <input name="password" type="password"> <br/>
    <input name="login" type="submit" value="Login">
</form>

<%@ include file="footer.jsp"%>
