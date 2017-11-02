<%-- 
    Document   : draw
    Created on : 25 oct. 2017, 11:06:11
    Author     : a.delgado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quizz</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <h1>Liste des participants</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Pr&eacute;nom</th>
                        <th>Email</th>
                        <th>T&eacute;l&eacute;phone</th>
                        <th>% r&eacute;ussite</th>
                        <th>Comment connait DTA</th>
                        <th>pourquoi DTA</th>
                        <th>Voir dossier</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${players}" var="player">
                        <tr>
                            <td><c:out value="${player.getLastName()}"/></td>
                            <td><c:out value="${player.getFirstName()}"/></td>
                            <td> <c:out value="${player.getEmail()}" /></td>
                            <td><c:out value="${player.getPhone()}" /></td>
                            <td>
                                <div>
                                    <c:if test="${player.getNbGoodAnswers()>4}">
                                        <div class="progress">
                                            <div class="progress-bar winner" role="progressbar" aria-valuenow="<c:out value="${player.getNbGoodAnswers()*10}"/>" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${player.getNbGoodAnswers()*10}"/>%;">
                                                <c:out value="${player.getNbGoodAnswers()*10}"/>%
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${player.getNbGoodAnswers()<=4}">
                                        <div class="progress">
                                            <div class="progress-bar looser" role="progressbar" aria-valuenow="<c:out value="${player.getNbGoodAnswers()*10}"/>" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${player.getNbGoodAnswers()*10}"/>%;">
                                                
                                            </div>
                                            <c:out value="${player.getNbGoodAnswers()*10}"/>%
                                        </div>
                                    </c:if>
                                </div>
                            </td>
                            <td><pre><c:out value="${player.getHowKnow()}"/></pre></td>
                            <td><pre><c:out value="${player.getWhy()}"/></pre></td>
                            <td>
                                <a href="tmp/<c:out value="${player.getDocName()}" />">
                                    Voir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!--Debut Pagination -->
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item <c:if test="${page==1}">disabled</c:if>">
                    <a class="page-link" href="Draw?page=1" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
                    <c:forEach var="i" begin="1" end="${nbpages}" step="1">
                        <li class="page-item"><a class="page-link" href="Draw?page=<c:out value="${i}" />"><c:out value="${i}" /></a></li>
                    </c:forEach>
                  <li class="page-item <c:if test="${page==nbpages}">disabled</c:if>">
                    <a class="page-link" href="Draw?page=<c:out value="${nbpages}" />" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
                </ul>
              </nav>
            <!--Fin Pagination -->
        </div>
    </body>
</html>
