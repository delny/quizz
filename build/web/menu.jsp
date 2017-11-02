<%--
    Document   : menu
    Created on : 25 oct. 2017, 15:42:24
    Author     : a.delgado
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
<nav id="menu" class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="http://www.dta-ingenierie.fr/" rel="home" target="_Blank">
        <img src="http://www.dta-ingenierie.fr/wp-content/uploads/2017/06/Logo_DTA_ingenierie_250x50.svg" alt="DTA Ingénierie">
    </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="Validate">Jouer !</a>
      </li>
      <c:if test="${Auth==null}">
          <li class="nav-item">
            <a class="nav-link" href="Login">Se connecter</a>
          </li>
      </c:if>
      <c:if test="${Auth!=null && Auth.equals("check")}">
          <li class="nav-item">
            <a class="nav-link" href="Draw">Voir les participations</a>
          </li>
      </c:if>
    </ul>
  </div>
</nav>
    </div>