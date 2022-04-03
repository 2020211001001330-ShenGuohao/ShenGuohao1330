<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet-week1</a>--%>
<%--<br/>--%>
<%--<a href="hello">Student Info Servlet-week2</a>--%>
<%--<br/>--%>
<%--<a href="life">Life Cycle Servlet-week3</a>--%>
<%--<br/>--%>
<%--<a href="register.jsp">Register-get-parameters-week3</a>--%>
<%--<br/>--%>
<%--<a href="config">Config-parameters-week4</a>--%>
<%--<br/>--%>
<%--<a href="register.jsp">Register JDBC -week4</a>--%>
<%--<br/>--%>
<%--<a href="MyJsp.jsp"> Include-week5</a>--%>
<%--<br/>--%>
<%--<a href="Login.jsp">Login-week5</a>--%>

<h2>welcome to My Online Shop Home Page</h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
    </select>
    <input type="submit" value="search">
</form>

<%@ include file="footer.jsp"%>