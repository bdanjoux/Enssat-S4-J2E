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
<p>
    <a href="/Enssat/etudiants">Liste des étudiants</a>
    <a href="/Enssat/groupes">Liste des groupes</a>
</p>

<%  Etudiant std = (Etudiant) request.getAttribute("student");
%>
<table border ="1" width="1200" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Nom</b></th>
        <th><b>Prenom</b></th>
        <th><b>date de Naissance</b></th>
        <th><b>courriel pro</b></th>
        <th><b>courriel perso</b></th>
        <th><b>serie Bac</b></th>
        <th><b>date Bac</b></th>
        <th><b>mention Bac</b></th>
        <th><b>diplome</b></th>
        <th><b>date diplome</b></th>
        <th><b>ville diplome</b></th>
    </tr>
    <tr>
        <td><%=std.getNom()%></td>
        <td><%=std.getPrenom()%></td>
        <td><%=std.getDateNaissance()%></td>
        <td><%=std.getCourrielPro()%></td>
        <td><%=std.getCourrielPerso()%></td>
        <td><%=std.getSerieBac()%></td>
        <td><%=std.getDateBac()%></td>
        <td><%=std.getMentionBac()%></td>
        <td><%=std.getDiplome()%></td>
        <td><%=std.getDateDiplome()%></td>
        <td><%=std.getVilleDiplome()%></td>
    </tr>
<!-- Fonctions de rafraichissement des données
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Refresh" CONTENT="15"> -->

</body>
</html>
