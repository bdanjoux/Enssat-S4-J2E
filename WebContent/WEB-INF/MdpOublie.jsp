<%--
  Created by IntelliJ IDEA.
  User: Annaïg
  Date: 04/04/2019
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mot de passe oublié ?</title>
</head>
<body>
<form method="post" action="mdpOublie"> <!--début du formulaire, méthode POST-->
    <fieldset> <!-- grand carré avec tout dedans-->
        <legend>Mot de passe oublié ?</legend>

        <label for="login">Login <span class="requis">*</span></label>
        <input type="text" id="login" name="login" value="" size="20" maxlength="60" /> <!--fieldtext for login-->
        <br />

        <label for="question">Question pour récupérer le mot de passe <span class="requis">*</span></label>
        <input type="text" id="question" name="question" value="" size="20" maxlength="60" /> <!--fieldtext for question-->
        <br />

        <label for="reponse">Réponse à la question précédente<span class="requis">*</span></label>
        <input type="password" id="reponse" name="reponse" value="" size="20" maxlength="20" /> <!--fieldtext for reponse-->
        <br />

        <input type="submit" value="Reset password" class="sansLabel" /> <!--bouton envoyer-->
        <br />
        <p>Déjà inscrit ? Rendez-vous <a href="connexion">ici</a></p>
    </fieldset>
</form>
</body>
</html>
