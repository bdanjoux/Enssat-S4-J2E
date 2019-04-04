<%--
  Created by IntelliJ IDEA.
  User: Annaïg
  Date: 04/04/2019
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>

<p>
    <a href="/etudiants">Liste des étudiants</a>
    <a href="/groupes">Liste des groupes</a>
</p>

<!-- methode Obi wan -->
<p>
<form method="post" action="accueil">
    <fieldset>
        <legend>Changer les paramètres du compte</legend>

        <label for="motdepasse">Nouveau mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /> <!--textfield for password-->
        <br />

        <label for="question">Nouvelle question pour récupérer le mot de passe <span class="requis">*</span></label>
        <input type="text" id="question" name="question" value="" size="20" maxlength="60" /> <!--fieldtext for question-->
        <br />

        <label for="reponse">Réponse à la question précédente<span class="requis">*</span></label>
        <input type="password" id="reponse" name="reponse" value="" size="20" maxlength="20" /> <!--fieldtext for reponse-->
        <br />

        <input type="submit" value="Accueil" class="sansLabel" /> <!--bouton connexion-->
        <br />
    </fieldset>
</form>

<p><%= (String)request.getAttribute("login") %> </p>

</body>
</html>
