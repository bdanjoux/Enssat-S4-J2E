<%--
  Created by IntelliJ IDEA.
  User: Annaïg
  Date: 25/03/2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
<form method="post" action="connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire.</p>

        <label for="nom">Login <span class="requis">*</span></label>
        <input type="login" id="login" name="login" value="<c:out value="${utilisateur.login}"/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['email']}</span>
        <br />

        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['motdepasse']}</span>
        <br />

        <input type="submit" value="Connexion" class="sansLabel" />
        <br />

        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
    </fieldset>
</form>
</body>
</html>
