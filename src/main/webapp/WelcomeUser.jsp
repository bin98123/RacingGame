<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15/01/2021
  Time: 07:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.UserDetails"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Trang chủ</title>

</head>
<body>
<%
    UserDetails user = (UserDetails) request.getAttribute("registeredUser");
    // 	String role = user.getRoleString();
    if (user.getUserName() == null) {
        response.sendRedirect("/RacingGame/index.jsp");
    }
%>
<%-- 	<h3>${userPro.userID}</h3> --%>
<h1>Chúc mừng, chào mừng đến với RacingGame</h1>
<form action="InfoServlet" method="post">
    <a><img src="upload/${requestScope.pic}" width=" 80" height="70" /></a>
    <a type="submit" class="btn btn-primary btn-sm"
       href="/RacingGame/edit.jsp">Update Avatar</a>
</form>

</body>
</html>
