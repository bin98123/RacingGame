<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02/01/2021
  Time: 02:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*"%>
<%
    ResourceBundle messages = (ResourceBundle) session.getAttribute("messages");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Sign Up</title>
    <style type="text/css">
        a {
            color: red;
            border: true;
            font-size: 30px;
        }

        h2 {
            color: red;
        }

        t1 {
            left: 400px;
            down: 320px;
            position: fixed;
            color: black;
            font-size: 20px;
        }

        submit {
            left: 320 position: fixed;
        }
    </style>
</head>

<body background="background.jpg">
<h1><%=messages.getString("StartSU")%></h1>
<form method="POST" action="SignUpServlet">
    <table>
        <tr>
                <%
				String userName = (String) request.getAttribute("userNameError");
				//             String userName = "fss";
				if (userName == null)
					userName = "";
				%>

        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
        <tr>
            <td width="42%" align="right"><h2><%=messages.getString("user")%></h2></td>
            <td><h2>
                <input type="text" size="32" name="userName"
                       value="${registeredUser.userName}"><%=userName%></h2></td>
        </tr>
        <%
            String nameIG = (String) request.getAttribute("nameIGError");
            if (nameIG == null)
                nameIG = "";
        %>
        <tr>
            <td width="42%" align="right"><h2><%=messages.getString("userIG")%></h2></td>
            <td><h2>
                <input type="text" size="32" name="userNameIG"
                       value="${registeredUser.userNameIG}">
                <%=nameIG%></h2></td>
        </tr>
        <%
            String password = (String) request.getAttribute("passwordError");
            if (password == null)
                password = "";
        %>
        <tr>
            <td width="42%" align="right">
                <h2><%=messages.getString("pass")%></h2>
            </td>
            <td><h2>
                <input type="password" size="32" name="userPassword"
                       value="${registeredUser.userPassword}"><%=password%><h2></td>
        </tr>
        <%
            String emailInput = (String) request.getAttribute("emailError");
            String emailEcho = (String) request.getParameter("emailError");
            String email = request.getParameter("email");
            if (emailInput == null)
                emailInput = "";
            if (emailEcho == null)
                emailEcho = "";
        %>
        <tr>
            <td width="42%" align="right">
                <h2>
                        <%=messages.getString("email")%>
                    <h2>
            </td>
            <td><h2>
                <input type="text" size="32" name="userEmail"
                       value="${registeredUser.userEmail}"><%=emailInput%></h2></td>
        </tr>
        <tr>
            <td>
            <td><input type="submit" value="<%=messages.getString("ca")%>"
                       name="submit"></td>
    </table>
    <h3><%=messages.getString("login?")%></h3>
    <a href="/RacingGame/login.jsp"><%=messages.getString("login_index?")%></a>
</form>

</body>
</html>
