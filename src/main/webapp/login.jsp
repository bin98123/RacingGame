<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Sign Up</title>
    <style type="text/css">
    t1 {
        left: 400px;
        bottom:  320px;
        position: fixed;
        color: black;
        font-size: 20px;
    }
    
  
    
    submit {
        left: 320; position: fixed;
    }
    
    .top_pic {
        align-self: top;
    }
    </style>
    </head>
    <body background="background.png">
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
    