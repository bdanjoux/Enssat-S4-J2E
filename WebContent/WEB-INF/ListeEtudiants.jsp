<%@ page import="org.ApLpMpBdKl.Etudiant" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: utilisateur
  Date: 04/04/2019
  Time: 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des étudiants</title>
</head>
<body>

<h1>Liste des étudiants</h1>
<%
    List<Etudiant> listEtu = request.getAttibute("listEtu");
for (Etudiant e:listEtu) {
    int id = e.getId();
    String nom = e.getNom();
    String prenom = e.getPrenom();
%>
<tr>
    <td><%=id %></td>
    <td><%=nom %></td>
    <td><%=prenom %></td>
</tr>
<%
    }
%>
</body>
</html>
