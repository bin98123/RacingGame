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
<form method="POST" action="LoginServlet">

    <h3></h3>
    <h3></h3>
    <h3></h3>
    <h3></h3>
    <h3></h3>
    <b> <t1> Username: </t1>
        <h3 align="center">
            <a><input type="text" size="32" name="uname"></a>
        </h3>
    </b>
    <t1> Password: </t1>
    <h3 align="center">
        <a><input type="text" size="32" name="upass"></a>
    </h3>

    <h3 align="center">
        <input type="submit" value="Log In" name="submit">
        <h3>Need a account?</h3>
        <a href="/RacingGame/signup.jsp">SIGN UP NOW</a>
    </h3>
</form>

</body>
</html>
