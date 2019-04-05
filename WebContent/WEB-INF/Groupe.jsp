<%@ page import="java.util.HashSet" %>
<%@ page import="org.ApLpMpBdKl.EtuInterface" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.ApLpMpBdKl.Etudiant" %>
<%@ page import="org.ApLpMpBdKl.GroupeEtu" %><%--
  Created by IntelliJ IDEA.
  User: benja
  Date: 05/04/2019
  Time: 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groupe</title>
</head>
<body>

<p>
    <a href="/etudiants">Liste des étudiants</a>
    <a href="/groupes">Liste des groupes</a>
</p>

<%  HashSet<EtuInterface> stds = (HashSet<EtuInterface>) request.getAttribute("childs");
    Iterator<EtuInterface> it = stds.iterator();
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
EtuInterface std=it.next();%>
    <tr>
        <%if(std instanceof Etudiant){

        }%>
            <%int id=1;
                if(std.getId().iterator().hasNext()){
                    id = std.getId().iterator().next().id;
            %><td><%=id%></td>
            <%}else{id=1;%>
            <td>null</td>
            <%}%>
            <td><a href="etudiant?id=<%=id%>">
                <%=((Etudiant)std).getNom()%></a></td>
            <td><%=((Etudiant)std).getPrenom()%></td>
            <td><%=((Etudiant)std).getDateNaissance()%></td>
            <td><%=((Etudiant)std).getCourrielPro()%></td>
            <td><%=((Etudiant)std).getCourrielPerso()%></td>
            <td><%=((Etudiant)std).getSerieBac()%></td>
            <td><%=((Etudiant)std).getDateBac()%></td>
            <td><%=((Etudiant)std).getMentionBac()%></td>
            <td><%=((Etudiant)std).getDiplome()%></td>
            <td><%=((Etudiant)std).getDateDiplome()%></td>
            <td><%=((Etudiant)std).getVilleDiplome()%></td>
        <%}else if(std instanceof GroupeEtu){%>
            <%int id=1;
                if(std.getId().iterator().hasNext()){
                    id = std.getId().iterator().next().id;
            %><td><%=id%></td>
            <%}else{id=1;%>
            <td>null</td>
            <%}%>

            <td><a href="groupe?id=<%=id%>">
                <%=std.getNom()%></a></td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
            <td>/</td>
    </tr>
        <%}%>

</body>
</html>
