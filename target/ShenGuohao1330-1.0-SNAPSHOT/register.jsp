<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/3/6
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
       <form method="post" a>
           <input name="username" type="text" value="username"/> <br/>
           <input name="password" type="password"minlength="8" value="password"> <br/>
           <input name="Email" type="email" value="Email"/> <br/>

           <label>Gender</label><input name="sex" type="radio" value="Man"/>Man
                  <input name="sex" type="radio" value="Femail"/>Female <br/>
           <input name="Date" type="date" value="Date of Birth(yyyy-mm-dd)"/> <br/>

           <input name="register" type="submit" value="register" />
       </form>
</body>
</html>
