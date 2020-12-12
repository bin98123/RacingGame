<%--
  Created by IntelliJ IDEA.
  User: lbk
  Date: 12/12/20
  Time: 6:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Racing</title>
    <script src="js/client.js" defer></script>
    <script src="js/index.js" defer></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
<div id="container-complete" class="d-none">
    <div class="center-body">
        <div class="complete">
            <main>
                <%--                <div class="players">--%>
                <%--                    <div>--%>
                <%--                        <h5>Khang</h5>--%>
                <%--                        <div class="progress">--%>
                <%--                            <div class="progress-bar progress-bar-animated progress-bar-striped" role="progressbar"--%>
                <%--                                 style="width: 50%;"></div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                    <div>--%>
                <%--                        <h5>Khanh</h5>--%>
                <%--                        <div class="progress">--%>
                <%--                            <div class="progress-bar progress-bar-animated progress-bar-striped" role="progressbar"--%>
                <%--                                 style="width: 20%;"></div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                    <div>--%>
                <%--                        <h5>Ngan</h5>--%>
                <%--                        <div class="progress">--%>
                <%--                            <div class="progress-bar progress-bar-animated progress-bar-striped" role="progressbar"--%>
                <%--                                 style="width: 50%;"></div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
            </main>
            <aside>
                <div class="stat">
                    <!-- speed -->
                    <div class="text-warning ">
                        <strong>Speed:
                            <strongc id="speed" class="text-white">20
                        </strong> WPM</strong>
                    </div>
                    <!-- accuary -->
                    <div class="text-warning mt-2">
                        <strong>Acctual:
                            <strongc id="acctual" class="text-white">90
                        </strong> %</strong>
                    </div>
                </div>
                <div class="play-again">
                    <a class="btn btn-primary" href="javascript:window.location.reload();">Race again</a>
                </div>
            </aside>
        </div>
    </div>
</div>


<div id="container-typing" class="center-body">
    <div class="container ">
        <div class="wrapper-players">
            <div id="players" class="container players">
                <div class="d-none">
                    <div class="status">
                        <strong class="name-player">Khang</strong>
                        <strong class="speed">
                            <strong class="speed-value">60</strong>
                            <strong>WPM</strong>
                        </strong>

                    </div>
                    <div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-animated progress-bar-striped" role="progressbar"
                                 style="width: 50%;"></div>
                        </div>
                    </div>
                </div>
                <div class="d-none">
                    <div class="status">
                        <strong class="name-player">Khang</strong>
                        <strong class="speed">
                            <strong class="speed-value">60</strong>
                            <strong>WPM</strong>
                        </strong>

                    </div>
                    <div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-animated progress-bar-striped" role="progressbar"
                                 style="width: 50%;"></div>
                        </div>
                    </div>
                </div>
                <div class="d-none">
                    <div class="status">
                        <strong class="name-player">Khang</strong>
                        <strong class="speed">
                            <strong class="speed-value">60</strong>
                            <strong>WPM</strong>
                        </strong>

                    </div>
                    <div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-animated progress-bar-striped" role="progressbar"
                                 style="width: 50%;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="input">
            <div id="please-wait" class="please-wait text-warning">
                <h1>Please wait one second !!</h1>
            </div>
            <div id="typing" class="container d-none">
                <div id="display-input" class="text"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>