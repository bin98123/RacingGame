<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>AVATAR</h2>
		<form action="ProfileServlet" method="post">

			<!-- 			<table class="table table-bordered"> -->
			<!-- 			<thead> -->
			<!-- 					<tr> -->
			<h3>Photo</h3>

			<!-- 					</tr> -->
			<!-- 			</thead> -->
			<!-- 			<tbody> -->
			<!-- 					<tr> -->
			<!-- 						<td width="10"> -->
			<a><img src="upload/${namePic}" width="80" height="70" /></a>
			<!-- 							</td> -->

			<!-- 					</tr> -->

			<!-- 			</tbody> -->
			<!-- 			</table> -->
			<h3></h3>
			<a class="btn btn-primary btn-sm" href="/Project/edit.jsp">Edit</a>
		</form>
	</div>
</body>
</html>