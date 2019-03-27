<%-- 
    Document   : index
    Created on : Mar 24, 2019, 6:29:20 PM
    Author     : fadou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns:th="http://www.thymeleaf.org" lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Générateur de blagues</title>

        <spring:url var="css" value="/resources/css"/>
        <spring:url var="js" value="/resources/js"/>

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <!--Material Design Bootstrap-->
        <link href="${css}/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="jumbotron bg-white">
                <h1 class="display-4 text-center">Générateur de blagues</h1>
                <div class="row mt-5">
                    <a class="btn btn-primary btn-lg btn-block" href="/blague/random" role="button">
                        Blague aléatoire
                    </a>
                </div>
                <div class="row mt-3">
                    <a class="btn btn-primary btn-lg btn-block" href="/blague/all" role="button">
                        Voir toutes les blagues
                    </a>
                </div>
                <div class="row mt-3">
                    <a class="btn btn-primary btn-lg btn-block" href="/blague/add" role="button">
                        Faire une contribution
                    </a>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>  
</html>