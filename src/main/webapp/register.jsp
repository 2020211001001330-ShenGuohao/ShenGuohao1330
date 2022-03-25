<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/3/6
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
       <form method="post" action="register">
           <input name="Id" type="text" value="Id"><br/>
           <input name="username" type="text" value="username"/> <br/>
           <input name="password" type="password"minlength="8" value="password"> <br/>
           <input name="Email" type="email" value="Email"/> <br/>

           <label>Gender</label><input name="Gender" type="radio" value="Man"/>Man
                  <input name="Gender" type="radio" value="Femail"/>Female <br/>
           <input name="birthday" type="date" value="Date of Birth(yyyy-mm-dd)"/> <br/>

           <input name="register" type="submit" value="register" />
       </form>
<%@ include file="footer.jsp"%>
