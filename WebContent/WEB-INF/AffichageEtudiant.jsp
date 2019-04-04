<%--
  Created by IntelliJ IDEA.
  User: utilisateur
  Date: 04/04/2019
  Time: 01:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List,org.tutorial.Book"%>

<html>
<head>
<%
Etudiant e = request.getAttribute("etudiant");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Etudiant n°<%=id%></title>
</head>
<body>
<h1>Bienvenue <%=prenom%></h1>
<p>
    ID : <%=e.id%>
    Nom : <%=e.getNom()%>, Prénom : <%=e.getPrenom()%>
    Date de Naissance : <%=e.getDateNaissance()%>
    Courriel Professionnel : <%=e.getCourrielPro()%>, Courriel Personnel : <%=e.getCourrielPerso()%>
    Série pour le BAC : <%=e.getSerieBac()%>, Date d'obtention du diplôme : <%=e.getDateBac()%>, Mention : <%=e.getMention()%>
    Diplôme : <%=e.getDiplome()%>, Date d'obtention du diplôme : <%=e.getDateDiplome()%>, Ville d'obtention du diplôme : <%=e.getVilleDiplome()%>
</p>
</body>
</html>
