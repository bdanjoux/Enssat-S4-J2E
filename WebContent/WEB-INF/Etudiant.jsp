<%@ page import="org.ApLpMpBdKl.Etudiant" %><%--
  Created by IntelliJ IDEA.
  User: Annaïg
  Date: 04/04/2019
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  Etudiant std = (Etudiant) request.getAttribute("student");
%>
<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Nom</b></th>
        <th><b>Prenom</b></th>
    </tr>
    <tr>
        <td><%=std.getNom()%></td>
        <td><%=std.getPrenom()%></td>
    </tr>
<!-- Fonctions de rafraichissement des données
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Refresh" CONTENT="15"> -->

</body>
</html>
