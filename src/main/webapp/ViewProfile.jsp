<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="dao.UserDetails"%>
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
    <form action="ProfileServlet" method="post"
          enctype="multipart/form-data">

        <h3>Ảnh mới</h3>
        <a><img src="upload/${profileUser.photo}" width="80" height="70" /></a>
        <h3></h3>
        <button type="submit" class="btn btn-primary btn-sm">Save</button>
        <a class="btn btn-primary btn-sm" href="/RacingGame/edit.jsp">Edit</a>
    </form>
</div>
</body>
</html>