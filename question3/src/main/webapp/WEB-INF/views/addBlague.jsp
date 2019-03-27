<%-- 
    Document   : addBlague
    Created on : Mar 25, 2019, 1:43:19 AM
    Author     : fadou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Ajouter une blague</title>

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
    <h1 class="display-4 text-center mb-3"> Ajouter une blague</h1>
    <f:form method="POST" class="was-validated my-2" action="/blague/add" modelAttribute="blague">
        <div class="form-group">
            <label for="question">Question</label>
            <f:textarea path="question" rows="3" id="question" required="true" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="reponse">Réponse</label>
            <f:textarea path="reponse" rows="3" id="reponse" required="true" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Valider</button>
    </f:form>

    <c:if test="${not empty message}">
        <div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
            ${message}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script type="text/javascript">
        var formElements = document.getElementById("blague").elements;
        var fieldType = "";
        for (i = 0; i < formElements.length; i++)
        {
            fieldType = formElements[i].type.toLowerCase();
            switch (fieldType)
            {
                case "text":
                case "password":
                case "textarea":
                case "hidden":
                    formElements[i].value = "";
                    break;
                case "radio":
                case "checkbox":
                    if (formElements[i].checked)
                    {
                        formElements[i].checked = false;
                    }
                    break;
                default:
                    break;
            }
        }
    </script>
</body>
</html>
