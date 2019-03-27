<%-- 
    Document   : allBlagues
    Created on : Mar 25, 2019, 12:50:56 AM
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
        <title>Blagues</title>

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
    <header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar">
        <a class="btn btn-outline-primary btn-lg mb-3" href="/" role="button">
            Accueil
        </a>
    </header>

        <div class="container">
            <h1 class="display-4 text-center"> Toutes les blagues</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Question</th>
                        <th scope="col">Réponse</th>
                    </tr>
                </thead>
                <tbody>
                    <f:forEach var="blague" items="${blagues}">
                        <tr>
                            <th scope="row">${blague.id}</th>
                            <td>${blague.question}</td>
                            <td>${blague.reponse}</td>
                        </tr>
                    </f:forEach>
                </tbody>
            </table>
        </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>