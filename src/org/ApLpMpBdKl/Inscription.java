package org.ApLpMpBdKl;

import java.beans.beancontext.BeanContext;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class Inscription extends HttpServlet {
    public static final String VUE = "/WEB-INF/Inscription.jsp";

    /* méthode GET qui appelle la page inscription.jsp */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /* méthode POST */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        // On crée une chaine de caractère contenant la requête SQL servant à insérer le nouvel utilisateur dans la BDD
        String strInsert = "INSERT INTO users(login,mdp) VALUES ("+request.getParameter("login")+","+request.getParameter("motdepasse")+")";
        Statement st = null;
        try {
            st = ((SQLConnector) BeanContext.globalHierarchyLock).getConnection().createStatement();

        // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //forwarding vers la page accueil (garde les paramètres)
        this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp" ).forward( request, response ); //TODO attente adresse accueil
    }
}