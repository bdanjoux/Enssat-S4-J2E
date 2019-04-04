<%@ page import="org.ApLpMpBdKl.Etudiant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
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
    <a href="/etudiants">Liste des étudiants</a>
    <a href="/groupes">Liste des groupes</a>
</p>

<%  ArrayList<Etudiant> stds = (ArrayList<Etudiant>) request.getAttribute("students");
    Iterator<Etudiant> it = stds.iterator();
%>
    <table border ="1" width="1200" align="center">
        <tr bgcolor="00FF7F">
            <th><b>Id</b></th>
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
<% while(it.hasNext()){
Etudiant std=it.next();%>
        <tr>
            <%int id=1;
            if(std.getId().iterator().hasNext()){
                id = std.getId().iterator().next().id;
            %><td><%=id%></td>
            <%}else{id=1;%>
            <td>null</td>
            <%}%>
            <td><a href="etudiant?id=<%=id%>">
                <%=std.getNom()%></a></td>
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
<%}%>
</body>
</html>
