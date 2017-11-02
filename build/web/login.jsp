<%-- 
    Document   : login
    Created on : 25 oct. 2017, 14:03:38
    Author     : a.delgado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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
            <h1>Cette partie du site est réservée au personnel autorisé, veuillez vous identifier</h1>
            <c:if test="${formLoginError!=null}" >
                <div class="alert alert-danger" role="alert">
                    <c:out value="${formLoginError}" />
                </div>  
            </c:if>
            <c:if test="${formLoginSuccess!=null}" >
                <div class="alert alert-success" role="alert">
                    <c:out value="${formLoginSuccess}" />
                </div>  
            </c:if>
            <form method="post" action="Login">
                <div class="form-group">
                <label for="login">Login</label>
                <input type="login" class="form-control" id="login" name="login" placeholder="Votre login">
              </div>
              <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
              </div>
              <button type="submit" class="btn btn-primary">Se connecter</button>
            </form>
        </div>
    </body>
</html>
