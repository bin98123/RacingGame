<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02/01/2021
  Time: 02:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style type="text/css">
    
     t1{
            left:  400px;

            bottom:320px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
        submit{
        left:320;
          position: fixed;
        }
    </style>
</head>

<body background="background.png">
<h1>Sign Up Now, It's Free!</h1>
<form method="POST" action="SignUp">
<t1>
Username:
</t1>
<h3 align="center">
<a><input type="text" size="32" name="name"></a>
</h3>
<t1>
UsernameIG:
</t1>
<h3 align="center">
<a><input type="text" size="32" name="nameIG"></a>
</h3>
<t1>
Password:
</t1>
<h3 align="center">
<a><input type="text" size="32" name="password"></a>
</h3>
<t1>
Email:
</t1>
<h3 align="center">
<a><input type="text" size="32" name="email"></a>
</h3>
<h3 align="center">
<input type="submit" value="Create Account"
					name="submit"><h3>Have a account? </h3><a href="/RacingGame/login.jsp">LOG IN NOW</a>
	</h3>
					</form>

</body>
</html>
