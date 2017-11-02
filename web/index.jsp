<%-- 
    Document   : index
    Created on : 25 oct. 2017, 14:55:23
    Author     : a.delgado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="FR-fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
        <c:if test="${formError!=null}" >
            <div class="alert alert-danger" role="alert">
                <c:out value="${formError}" />
                <p>Attention! les réponses aux questions ont été réinitialisées !</p>
            </div>  
        </c:if>
        <form method="post" action="Validate" enctype="multipart/form-data">
            <h2>Questions</h2>
            <h3>Questions sur le 4LTrophy</h3>
            <div class="form-group">
            <label for="question1">Question n°1 : Quand débute la course du 4LTrophy ?</label>
            <select class="form-control" name="question1" id="question1">
              <option value="1">Vendredi 9 Mars 2018</option>
              <option value="2">Mardi 6 Février 2018</option>
              <option value="3">Jeudi 15 Février 2018</option>
              <option value="4">Dimanche 1<sup>er</sup> Avril 2018</option>
              <option value="5">Lundi 19 Février 2018</option>
            </select>
          </div>
            <div class="form-group">
            <label for="question2">Question n°2 : Quand se termine la course du 4LTrophy ?</label>
            <select class="form-control" name="question2" id="question2">
              <option value="1">Vendredi 2 Avril 2018</option>
              <option value="2">Mardi 13 Février 2018</option>
              <option value="3">Jeudi 22 Février 2018</option>
              <option value="4">Dimanche 25 Février 2018</option>
              <option value="5">Lundi 26 Février 2018</option>
            </select>
          </div>
            <h3>Questions sur la voiture 4L</h3>
            <div class="form-group">
            <label for="question3">Question n°3 :De quelle marque est la voiture 4L</label>
            <select class="form-control" name="question3" id="question3">
              <option value="1">Peugeot</option>
              <option value="2">Renault</option>
              <option value="3">BMW</option>
              <option value="4">Citro&euml;n</option>
              <option value="5">Skoda</option>
            </select>
          </div>
            <div class="form-group">
            <label for="question4">Question n°4 : Quand a été mise en circulation la voiture "4L" ?</label>
            <select class="form-control" name="question4" id="question4">
              <option value="1">1956</option>
              <option value="2">1989</option>
              <option value="3">1961</option>
              <option value="4">1925</option>
              <option value="5">1945</option>
            </select>
          </div>
            <h3>Questions sur DTA</h3>
            <div class="form-group">
            <label for="question5">Question n°5 : Quand a été crée DTA ingénierie ?</label>
            <select class="form-control" name="question5" id="question5">
              <option value="1">Janvier 1996</option>
              <option value="2">Avril 2008</option>
              <option value="3">Septembre 2017</option>
              <option value="4">Octobre 2014</option>
              <option value="5">Mai 2012</option>
            </select>
          </div>
            <div class="form-group">
            <label for="question6">Question n°6 : Où se situe le siège de DTA ingénierie ?</label>
            <select class="form-control" name="question6" id="question6">
              <option value="1">Paris</option>
              <option value="2">Nantes</option>
              <option value="3">Montpellier</option>
              <option value="4">Perpignan</option>
              <option value="5">Bordeaux</option>
            </select>
          </div>
            <div class="form-group">
            <label for="question7">Question n°7 : Quelle formation n'est pas proposée par DTA ingénierie</label>
            <select class="form-control" name="question7" id="question7">
              <option value="1">Développeur PHP</option>
              <option value="2">Développeur .NET</option>
              <option value="3">Développeur Mobile</option>
              <option value="4">Développeur JAVA EE</option>
                <option value="5">Développeur Flash</option>
              <option value="6">Développeur BI</option>
            </select>
          </div>
            <div class="form-group">
            <label for="question8">Question n°8 : Combien de jours dure les formations proposées par DTA ingénierie ?</label>
            <input type="number" class="form-control" name="question8" id="question8">
          </div>
            <div class="form-group">
            <label for="question9">Question n°9 : Quelles sont les 3 responsabilités de DTA ingénierie ?</label>
            <select class="form-control" name="question9" id="question9">
              <option value="1">Sociale, Sociétale et Environnementale</option>
              <option value="2">Economique, Sociale et Sociétale</option>
              <option value="3">Financière, Economique et Sociale</option>
              <option value="4">Sociale, Environnementale et Economique</option>
              <option value="5">Sociétale, Financière et Sociale</option>
            </select>
          </div>
            <div class="form-group">
            <label for="question10">Question n°10 : Quelle est la devise de DTA ingénierie ?</label>
            <select class="form-control" name="question10" id="question10">
              <option value="1">Des Tortues Aquatiques</option>
              <option value="2">Du Temps Aménagé</option>
              <option value="3">Des Travailleurs Autonomes</option>
              <option value="4">Des Talents Audacieux</option>
              <option value="5">Des Terroristes Anonymes</option>
            </select>
          </div>
            <h2>Informations sur vous</h2>
            <c:if test="${player==null}" >
                <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" class="form-control" name="lastname" id="nom" placeholder="Dupont">
                </div>
                <div class="form-group">
                    <label for="prenom">Pr&eacute;nom</label>
                <input type="text" class="form-control" name="firstname" id="prenom" placeholder="Jean">
              </div>
              <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="jean@dupont.fr">
              </div>
                <div class="form-group">
                <label for="phone">Téléphone</label>
                <input type="tel" class="form-control" name="phone" id="phone" placeholder="0102030405">
              </div>
                <div class="form-group">
                <label for="doc">Dossier 4LTrophy</label>
                <input type="file" class="form-control" name="doc" id="doc">
              </div>
              <div class="form-group">
                <label for="exampleFormControlTextarea1">Comment avez-vous connu DTA ?</label>
                <textarea class="form-control" name="howknow" id="exampleFormControlTextarea1" rows="3"></textarea>
              </div>
                <div class="form-group">
                <label for="exampleFormControlTextarea1">Pourquoi vouloir DTA comme sponsor ?</label>
                <textarea class="form-control" name="why" id="exampleFormControlTextarea1" rows="3"></textarea>
              </div>
            </c:if>
            <c:if test="${player!=null}" >
                <%-- formulaire avec informations prérempli si formulaire dejà soumis --%>
                <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" class="form-control" name="lastname" id="nom" value="<c:out value="${player.getLastName()}"/>">
                </div>
                <div class="form-group">
                    <label for="prenom">Pr&eacute;nom</label>
                <input type="text" class="form-control" name="firstname" id="prenom" value="<c:out value="${player.getFirstName()}"/>">
              </div>
              <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" id="email" value="<c:out value="${player.getEmail()}"/>">
              </div>
                <div class="form-group">
                <label for="phone">Téléphone</label>
                <input type="tel" class="form-control" name="phone" id="phone" value="<c:out value="${player.getPhone()}"/>">
              </div>
                <div class="form-group">
                <label for="doc">Dossier 4LTrophy</label>
                <input type="file" class="form-control" name="doc" id="doc">
              </div>
              <div class="form-group">
                <label for="exampleFormControlTextarea1">Comment avez-vous connu DTA ?</label>
                <textarea class="form-control" name="howknow" id="exampleFormControlTextarea1" rows="3"><%--
                    --%><c:if test="${player.getHowKnow()!=null}"><c:out value="${player.getHowKnow()}"/></c:if><%--
                --%></textarea>
              </div>
                <div class="form-group">
                <label for="exampleFormControlTextarea1">Pourquoi vouloir DTA comme sponsor ?</label>
                <textarea class="form-control" name="why" id="exampleFormControlTextarea1" rows="3"><%--
                    --%><c:if test="${player.getWhy()!=null}"><c:out value="${player.getWhy()}"/></c:if><%--
                --%></textarea>
              </div>
            </c:if>
            
            <button type="submit" class="btn btn-primary">Envoyer !</button>
        </form>
    </div>
</body>
</html>