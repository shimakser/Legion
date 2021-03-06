<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sign up in the Legion</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <style>
        /* stylelint-disable selector-list-comma-newline-after */
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .center{
            display: block;
            margin: 0 auto;
        }

        .btnsign {
            font-size: 20px}

        .blog-header {
            line-height: 1;
            border-bottom: 1px solid #e5e5e5;
        }

        .blog-header-logo {
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
            font-size: 2.25rem;
        }

        .blog-header-logo:hover {
            text-decoration: none;
        }

        h1, h2, h3, h4, h5, h6 {
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
        }

        .display-4 {
            font-size: 2.5rem;
        }
        @media (min-width: 768px) {
            .display-4 {
                font-size: 3rem;
            }
        }

        .card-img-right {
            height: 100%;
            border-radius: 0 3px 3px 0;
        }

        .flex-auto {
            -ms-flex: 0 0 auto;
            flex: 0 0 auto;
        }

        .h-250 { height: 250px; }
        @media (min-width: 768px) {
            .h-md-250 { height: 250px; }
        }

        /* Blog posts*/
        .blog-post {
            margin-bottom: 4rem;
        }
        .blog-post-title {
            margin-bottom: .25rem;
            font-size: 2.5rem;
        }
        .blog-post-meta {
            margin-bottom: 1.25rem;
            color: #999;
        }

        /* Footer*/
        .blog-footer {
            padding: 2.5rem 0;
            color: #999;
            text-align: center;
            background-color: #f9f9f9;
            border-top: .05rem solid #e5e5e5;
        }
        .blog-footer p:last-child {
            margin-bottom: 0;
        }

        *, *:before, *:after {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        ul {
            display: block;
            margin: 0;
            padding: 0;
            list-style: none;
        }
        ul:after {
            display: block;
            content: ' ';
            clear: both;
            float: none;
        }
        ul.menu > li {
            float: right;
            position: relative;
        }
        ul.menu > li > a {
            display: block;
            padding: 10px;
            text-decoration: none;
        }
        ul.submenu {
            display: none;
            position: absolute;
            width: 120px;
            top: 37px;
            left: 0;
            background-color: white;
            border: 1px solid #1E90FF;
        }
        ul.submenu > li {
            display: block;
        }
        ul.submenu > li > a {
            display: block;
            padding: 10px;
            text-decoration: none;
        }
        ul.submenu > li > a:hover {
            background-color: #1E90FF;
        }

        ul.menu > li:hover > ul.submenu {
            display: block;
        }

        input {
            font-size: 1em;
            line-height: 1.5;
        }
        input {
            display: block;
            margin-bottom: 1.5em;
        }
        .l {
            background-color: rgba(0,0,0,0.7);
            border-radius: 0.75em;
            box-shadow: 0.125em 0.125em 0 0.125em rgba(0,0,0,0.3) inset;
            color: #fdea7b;
            display: inline-flex;
            align-items: center;
            margin: auto;
            padding: 0.15em;
            width: 3em;
            height: 1.5em;
            transition: background-color 0.1s 0.3s ease-out, box-shadow 0.1s 0.3s ease-out;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
        }
        .l:before, .l:after {
            content: "";
            display: block;
        }
        .l:before {
            background-color: #d7d7d7;
            border-radius: 50%;
            width: 1.2em;
            height: 1.2em;
            transition: background-color 0.1s 0.3s ease-out, transform 0.3s ease-out;
            z-index: 1;
        }
        .l:after {
            background:
                    linear-gradient(transparent 50%, rgba(0,0,0,0.15) 0) 0 50% / 50% 100%,
                    repeating-linear-gradient(90deg,#bbb 0,#bbb,#bbb 20%,#999 20%,#999 40%) 0 50% / 50% 100%,
                    radial-gradient(circle at 50% 50%,#888 25%, transparent 26%);
            background-repeat: no-repeat;
            border: 0.25em solid transparent;
            border-left: 0.4em solid #d8d8d8;
            border-right: 0 solid transparent;
            transition: border-left-color 0.1s 0.3s ease-out, transform 0.3s ease-out;
            transform: translateX(-22.5%);
            transform-origin: 25% 50%;
            width: 1.2em;
            height: 1em;
        }
        /* Checked */
        .l:checked {
            background-color: rgba(0,0,0,0.45);
            box-shadow: 0.125em 0.125em 0 0.125em rgba(0,0,0,0.1) inset;
        }
        .l:checked:before {
            background-color: currentColor;
            transform: translateX(125%)
        }
        .l:checked:after {
            border-left-color: currentColor;
            transform: translateX(-2.5%) rotateY(180deg);
        }
        /* Other States */
        .l:focus {
            /* Usually an anti-A11Y practice but set to remove an annoyance just for this demo */
            outline: 0;
        }
    </style>
</head>

<body>
<div class="container">
    <header class="blog-header py-3">
        <div class=" row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
                <a class="btn btn-sm btn-outline-primary" href="/main">Главная</a>
            </div>
            <div class="col-4 text-center">
                <a class="blog-header-logo text-dark" href="#">Legion</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <div class="col-3 pt-1">
                    <ul class="menu">
                        <li><a class="btn btn-sm btn-outline-primary" href=#>Настройки</a>
                            <ul class="submenu">
                                <li><br><input class="l" type="checkbox"></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="col-4 pt-1">
                    <a class="btn btn-sm btn-outline-primary" href="#">Войти</a>
                </div>
            </div>
        </div>
        <hr>
    </header>

    <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark">
        <div class="col-md-6 px-0" style="margin:0 auto;">
            <p class="lead mb-0 text-white font-weight-bold" align="center">имя нам</p>
            <h1 class="display-4 font-weight-bold" align="center">Легион</h1>
            <hr style="background-color: white;">
            <p class="lead my-3">Веб-сайт, главной идей которого является возможность свободного размещения постов.</p>
            <p class="lead my-3">Новости, общение, поиск и обмен информацией.</p>
            <hr style="background-color: white;">
            <p class="lead mb-0" align="center"><a class="btnsign btn btn-sm btn-outline-secondary text-white font-weight-bold" href="#">Войти</a></p>
        </div>
    </div>
</div>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <h3 class="pb-4 mb-4 font-italic border-bottom"></h3>
            <div class="blog-post">
                <!--<h4 class="blog-post-title">1.</h4>
                <p class="blog-post-meta"><font class="text-primary">HTML/CSS, SQL</font></p>-->
                <p>Веб-приложени написсано на Java с использованием Spring Framework.</p>
                <p>А также сборщика проектов Maven, системы управления базами данных PostgreSQL, а в основу HTML/CSS части проекта лёгли ресурсы Bootstapap'a.</p>
            </div><!-- /.blog-post | блок поста-->

        </div><!-- /.blog-main | блок ленты-->

        <aside class="col-md-4 blog-sidebar">
            <div class="p-4 mb-3 bg-light rounded">
                <h4 class="font-italic"><u>About</u></h4>
                <p>В планах реализовать систему размещения постов, авторизацию пользователей, чат на сайте и возможность начинать видео-трансляции.</p>
            </div>
            <div class="p-4 bg-light">
                <h4 class="font-italic"><u>Contacts</u></h4>
                <ol class="list-unstyled">
                    <li><a href="#">Telegram</a></li>
                    <li><a href="#">Discord</a></li>
                </ol>
            </div>
        </aside>

    </div><!-- /.row -->
    <!-- <button type="button" class="btn btn-outline-primary center"><a href="#">Back to top</a></button>-->
</main><!-- /.container -->

<br><footer class="blog-footer">
    <p>Belarus, Vitebsk, 2020-2021</p>
    <p>by Shimakser</p>
</footer>
</body>
</html>

