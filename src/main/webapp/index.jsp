<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Racing Typing</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        *{
            box-sizing: border-box;
        }
        body, html{
            margin: 0;
            padding: 0;
            height: 100%;
        }

        .bg{
            height: 100%;
            background-image: url('./img/background.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }

        .button1 {

            left: 880px;
            font-size: 16px;

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
            font-size: 16px;

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

<body>
<div class="bg">
    <button class="button1" onclick="window.location.href='login.jsp'">Log In</button>
    <button class="button2">Sign Up</button>
    <button class="button3">Trial</button>
    <a class="button4" href="<c:url value="/race"/>">Race as a Guest</a>
    <button class="button5">Sign Up For Free</button>

    <h1>Worldwide Real-Time </h1>
    <h2>Typing Competition</h2>
    <t1>Improve your typing skills while competing in fast-paced races with</t1>
    <t2>up to 5 typers from around the world. Compete against your friends,</t2>
    <t3>earn new cars, track your scores, and so much more... all for free!</t3>
</div>
</body>
</html>