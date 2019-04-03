<%--
  Created by IntelliJ IDEA.
  User: Annaïg
  Date: 01/04/2019
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
   <!-- <link type="text/css" rel="stylesheet" href="form.css" /> -->
</head>
<body>
<form method="post" action="inscription"> <!--début du formulaire, méthode POST-->
    <fieldset> <!-- grand carré avec tout dedans-->
        <legend>Inscription</legend>

        <label for="login">Login <span class="requis">*</span></label>
        <input type="text" id="login" name="login" value="" size="20" maxlength="60" /> <!--fieldtext for login-->
        <br />

        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /> <!--fieldtext for password-->
        <br />

        <input type="submit" value="Inscription" class="sansLabel" /> <!--bouton envoyer-->
        <br />
    </fieldset>
</form>
</body>
</html>