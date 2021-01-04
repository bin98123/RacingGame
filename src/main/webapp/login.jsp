<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Login Here</h1>
<form action="UserProfile" method="post" style='float: left;'>
		<pre>
UserName: <input type="text" name="uname">
Password: <input type="password" name="upass">
    <input type="submit" value="Login">
</pre>

</form>
<form action="UserRegister" method="post">

    <input type="submit" value="Regist">
</form>
</body>
</html>