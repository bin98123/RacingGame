
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         session="true"%>
<%@ page import="java.util.*"%>
<%
    ResourceBundle messages = (ResourceBundle) session.getAttribute("messages");
    if (messages == null) {
        Locale locale = request.getLocale();
        messages = ResourceBundle.getBundle("messages.BookstoreMessages", locale);
        session.setAttribute("messages", messages);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Racing Typing</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        * {
            box-sizing: border-box;
        }

        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
        }

        .bg {
            height: 100%;
            background-image: url('./img/background.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }

        .button1 {
            left: 840px;
            font-size: 12px;
            padding: 15px 32px;
            position: fixed;
            color: rgb(2, 1, 1);
            cursor: pointer;
        }

        .button1:hover {
            background-color: rgb(248, 236, 64);
            color: black;
        }

        .button2:hover {
            background-color: crimson;
            color: black;
        }

        .button2 {
            background-color: rgb(28, 179, 48);
            left: 1000px;
            font-size: 12px;
            padding: 15px 32px;
            position: fixed;
            color: rgb(2, 1, 1);
            cursor: pointer;
        }

        .button3:hover {
            background-color: rgb(238, 8, 54);
            color: black;
        }

        .button4:hover {
            background-color: rgb(238, 8, 54);
            color: black;
        }

        .button5:hover {
            background-color: rgb(65, 39, 179);
            color: black;
        }

        .button3 {
            background-color: rgb(179, 28, 28);
            right: 1100px;
            font-size: 16px;
            top: 140px;
            padding: 10px 50px;
            position: fixed;
            color: rgb(2, 1, 1);
            cursor: pointer;
        }

        .button4 {
            background-color: rgb(179, 28, 28);
            right: 950px;
            font-size: 16px;
            top: 460px;
            padding: 10px 50px;
            position: fixed;
            color: rgb(2, 1, 1);
            cursor: pointer;
        }

        .button5 {
            background-color: blue;
            right: 700px;
            font-size: 16px;
            top: 460px;
            padding: 10px 50px;
            position: fixed;
            font-family: times new roman;
            color: rgb(2, 1, 1);
            cursor: pointer;
        }

        h1 {
            right: 800px;
            top: 210px;
            position: fixed;
            color: white;
        }

        h2 {
            right: 820px;
            top: 260px;
            position: fixed;
            color: white;
            font-size: 40px;
        }

        tt1 {
            left: 220px;
            top: 210px;
            position: fixed;
            color: black;
            font-size: 35px;
        }

        tt2 {
            left: 220px;
            top: 264px;
            position: fixed;
            color: black;
            font-size: 35px;
        }

        t1 {
            left: 130px;
            top: 320px;
            position: fixed;
            color: black;
            font-size: 20px;
        }

        t2 {
            left: 130px;
            top: 360px;
            position: fixed;
            color: black;
            font-size: 20px;
        }

        t3 {
            left: 130px;
            top: 400px;
            position: fixed;
            color: black;
            font-size: 20px;
        }
    </style>
</head>

<body background="background.jpg">
<div class="bg">
    <select name="language" id="language" class="combobox">
        <option value="1">Vietnamese</option>
        <option value="2">English</option>

    </select>
    <button class="button1" onclick="window.location.href='login.jsp'"><%=messages.getString("login_index")%></button>
    <button class="button2" onclick="window.location.href='signup.jsp'"><%=messages.getString("Signup_index")%></button>
    <button class="button3"><%=messages.getString("trial")%></button>
    <a class="button4" href="<c:url value="/race"/>"><%=messages.getString("Race_index")%></a>
    <button class="button5" onclick="window.location.href='signup.jsp'"><%=messages.getString("Free_Signup_index")%></button>


    <tt1><%=messages.getString("Title1")%></tt1>
    <tt2><%=messages.getString("Title2")%></tt2>
    <t1><%=messages.getString("Detiles1")%></t1>
    <t2><%=messages.getString("Detiles2")%></t2>
    <t3><%=messages.getString("Detiles3")%></t3>
</div>
</body>
</html>