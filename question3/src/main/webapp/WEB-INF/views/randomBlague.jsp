<%-- 
    Document   : randomBlague
    Created on : Mar 24, 2019, 6:29:10 PM
    Author     : fadou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Blague aléatoire</title>

        <spring:url var="css" value="/resources/css"/>
        <spring:url var="js" value="/resources/js"/>

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <link href="${css}/style.css" rel="stylesheet">
    </head>

    <body>
        <header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar">
            <a class="btn btn-outline-primary btn-lg mb-3" href="/" role="button">
                Accueil
            </a>
        </header>
        <div class="container">
            <h1 class="display-4 text-center mb-3">Blague aléatoire</h1>
            <div class="row justify-content-center">
                <a class="btn btn-outline-primary btn-lg my-2" href="/blague/random" role="button">
                    Relancer
                </a>
            </div>
            <div class="row my-5">
                <div class="col-md-4 offset-md-4">
                    <!-- Rotating card -->
                    <div class="card-container">
                        <div class="card text-center">
                            <div class="front">
                                <div class="card-header">
                                    <h3>Question</h3>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">${blague.question}</p>
                                </div>
                                <div class="card-footer text-muted">
                                    <i class="far fa-share-square"></i> Voir la réponse
                                </div>
                            </div> <!-- end front panel -->
                            <div class="back">
                                <div class="card-header">
                                    <h3>Réponse</h3>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">${blague.reponse}</p>
                                </div>
                            </div> <!-- end back panel -->
                        </div> <!-- end card -->
                    </div> <!-- end card-container -->
                    <!-- Rotating card -->
                </div>
            </div>
        </div>




        <!-- JQuery -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

