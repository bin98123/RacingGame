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
    <title>Log In</title>
    <style type="text/css">
        t1 {
            left: 400px;
            down: 320px;
            position: fixed;
            color: black;
            font-size: 20px;
        }

        a {
            color: red;
            border: true;
            font-size: 30px;

        }

        submit {
            left: 320 position: fixed;
        }

        .top_pic {
            align-self: top;
        }
    </style>
</head>
<body background="background.jpg">
<!-- 	<div class="top_pic">  -->
<!-- 	<img src="top_background.png" width="1350"> -->
<!-- 	</div> -->
<h1>Login</h1>
<form method="POST" action="SigInServlet">

    <h3></h3>
    <h3></h3>
    <h3></h3>
    <h3></h3>
    <h3></h3>
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
            String password = (String) request.getAttribute("passwordError");
            if (password == null)
                password = "";
        %>
        <tr>
            <td width="30%" align="right"> Password:</td>
            <td><input  type="password" size="32" name="userPassword"
                        value="${registeredUser.userPassword}"><%=password%></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Log In" name="submit"></td>
    </table>
    <h3>Need a account?</h3>
    <a href="/RacingGame/signup.jsp">SIGN UP NOW</a>
    </h3>
</form>

</body>
</html>
