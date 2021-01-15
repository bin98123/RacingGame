<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02/01/2021
  Time: 02:05 PM
  To change this template use File | Settings | File Templates.
--%>
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
<h1>Sign Up Now, It's Free!</h1>
<form method="POST" action="SignUpServlet">
    <t1> Username: <%
        String userName = (String) request.getAttribute("userNameError");
        //             String userName = "fss";
        if (userName == null)
            userName = "";
    %> </t1>
    <h3 align="center">
        <u1><input type="text" size="32" name="userName"
                   value="${registeredUser.userName}"> <%=userName%></u1>
    </h3>
    <t1> UsernameIG: <%
        String nameIG = (String) request.getAttribute("nameIGError");
        if (nameIG == null)
            nameIG = "";
    %> </t1>
    <h3 align="center">
        <u1><input type="text" size="32" name="userNameIG"
                   value="${registeredUser.userNameIG}"> <%=nameIG%></u1>
    </h3>
    <t1> Password: <%
        String password = (String) request.getAttribute("passwordError");
        if (password == null)
            password = "";
    %> </t1>
    <h3 align="center">
        <u1><input type="text" size="32" name="userPassword"
                   value="${registeredUser.userPassword}"><%=password%></u1>
    </h3>
    <t1> Email: <%
        String emailInput = (String) request.getAttribute("emailError");
        String emailEcho = (String) request.getParameter("emailError");
        String email = request.getParameter("email");
        if (emailInput == null)
            emailInput = "";
        if (emailEcho == null)
            emailEcho = "";
    %> </t1>
    <h3 align="center">
        <u1><input type="text" size="32" name="userEmail"
                   value="${registeredUser.userEmail}"> <%=emailInput%></u1>
    </h3>
    <h3 align="center">
        <input type="submit" value="Create Account" name="submit">
        <h3>Have a account?</h3>
        <a href="/RacingGame/login.jsp">LOG IN NOW</a>
    </h3>
</form>

</body>
</html>
