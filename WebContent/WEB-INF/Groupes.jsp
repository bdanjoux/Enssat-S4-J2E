<%@ page import="org.ApLpMpBdKl.GroupeEtu" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Annaïg
  Date: 04/04/2019
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des groupes</title>
</head>
<body>
<p>
    <a href="/accueil">Accueil</a>
    <a href="/inscription">Inscription</a>
    <a href="/etudiants">Liste des étudiants</a>
    <a href="/groupes">Liste des groupes</a>
</p>

<%  ArrayList<GroupeEtu> grps = (ArrayList<GroupeEtu>) request.getAttribute("groupes");
    Iterator<GroupeEtu> it = grps.iterator();
%>

<table border ="1" width="1200" align="center">
    <tr bgcolor="00FF7F">
        <td><b>Nom du groupe</b></td>
    </tr>
 <% while(it.hasNext()){
     GroupeEtu grp = it.next();%>
    <tr>
        <td><a href="groupe?id=<%=grp.getSelfId().id%>">
            <%=grp.getSelfId().id%></a></td>
    </tr>
    <% }%>
<!-- Fonctions de rafraichissement des données
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Refresh" CONTENT="15"> -->

</body>
</html>
