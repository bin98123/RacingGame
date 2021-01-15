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
        userName {
            left: 520px;
            down: 320px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        userName1 {
            left: 820px;
            down: 320px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        nameIG {
            left: 520px;
            down: 280px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        nameIG1 {
            left: 820px;
            down: 280px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        password {
            left: 520px;
            down: 240px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        password1 {
            left: 820px;
            down: 240px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        emailInput {
            left: 520px;
            down: 200px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        emailInput1 {
            left: 820px;
            down: 200px;
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
    <table>
        <tr>
                <%
		String userName = (String) request.getAttribute("userNameError");
		//             String userName = "fss";
		if (userName == null)
			userName = "";
		%>

        <tr>
            <td width="30%" align="right">Username:</td>
            <td><input type="text" size="32" name="userName"
                       value="${registeredUser.userName}"><%=userName%></td>
        </tr>
        <%

            String nameIG = (String) request.getAttribute("nameIGError");
            if (nameIG == null)
                nameIG = "";
        %>
        <tr>
            <td width="30%" align="right">UsernameIG:</td>
            <td><input type="text" size="32" name="userNameIG"
                       value="${registeredUser.userNameIG}"> <%=nameIG%></td>
        </tr>
        <%
            String password = (String) request.getAttribute("passwordError");
            if (password == null)
                password = "";
        %>
        <tr>
            <td width="30%" align="right"> Password:</td>
            <td><input  type="text" size="32" name="userPassword"
                        value="${registeredUser.userPassword}"><%=password%></td>
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
            <td width="30%" align="right"> Email:</td>
            <td><input type="text" size="32" name="userEmail"
                       value="${registeredUser.userEmail}"><%=emailInput%></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create Account" name="submit"></td>
    </table>
    <h3>Have a account?</h3>
    <a href="/RacingGame/login.jsp">LOG IN NOW</a>
</form>

</body>
</html>
