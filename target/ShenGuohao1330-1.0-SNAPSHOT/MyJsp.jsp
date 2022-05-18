<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/5/18
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab1</title>
</head>
<body>
       <h2>i am in MyJsp.jsp</h2>
       <form method="post" action="MyDearJsp.jsp">
           <input name="name" type="text" value="name"/> <br/>
           <input name="Class" type="text" value="Class"/> <br/>
           <input name="id" type="text" value="id"/> <br/>
           <input name="send" type="submit" value="send data to server" />
       </form>
</body>
</html>
