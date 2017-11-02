<%-- 
    Document   : validate
    Created on : 25 oct. 2017, 14:57:00
    Author     : a.delgado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="FR-fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quizz</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>

<body>
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h1>Votre participation a &eacute;t&eacute; prise en compte</h1>
        <p>
            Merci d'avoir particip&eacute; au jeu concours 4LTrophy de 
            <strong><span style="color: #F00">DTA</span> Ingénierie</strong>!
        </p>
        <p>Un tirage au sort aura lieu parmi les bonnes r&eacute;ponses pour déterminer l'&eacute;quipe qui sera sponsoris&eacute; par 
            <strong><span style="color: #F00">DTA</span> Ingénierie</strong>
        </p>
        <p>En attendant de connaître le r&eacute;sultat, rien ne vous emp&ecirc;che d'aller faire un tour le site de 
            <a href="http://www.dta-ingenierie.fr"><strong><span style="color: #F00">DTA</span> Ingénierie</strong></a>
        </p>
    </div>
</body>
</html>
