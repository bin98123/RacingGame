<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02/01/2021
  Time: 02:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*"%>
<%	ResourceBundle messages = (ResourceBundle) session.getAttribute("messages"); %>
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

		b {
			color: red;
			border: true;
			top: 30;
			font-size: 30px;
			right: 200 font-size: 30px;
			left: 400px;
			position: fixed;
		}

		submit {
			left: 320 position: fixed;
		}
		h2{
			color:red;
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
<h1><%=messages.getString("Start")%></h1>
<form method="POST" action="SigInServlet">

	<h3></h3>
	<h3></h3>
	<h3></h3>
	<h3></h3>
	<h3></h3>

	<b>User name or password is incorrect</b>
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
			<td width="68%" align="right"><h2><%=messages.getString("user")%></h2></td>
			<td><h2><input type="text" size="32" name="userName"
						   value="${registeredUser.userName}"><%=userName%></h2></td>
		</tr>
		<%
			String password = (String) request.getAttribute("passwordError");
			if (password == null)
				password = "";
		%>
		<tr>
			<td width="68%" align="right"><h2><%=messages.getString("pass")%></h2></td>
			<td><h2><input type="password" size="32" name="userPassword"
						   value="${registeredUser.userPassword}"><%=password%></h2></td>
		</tr>
		<tr>
			<td>

			<td width="68%"><input type="submit" value="<%=messages.getString("login_index")%>" name="submit"></td>
	</table>
	<h3><%=messages.getString("account?")%></h3>
	<a href="/RacingGame/signup.jsp"><%=messages.getString("Signup_index?")%></a>
	</h3>
</form>

</body>
</html>
