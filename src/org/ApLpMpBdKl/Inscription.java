package org.ApLpMpBdKl;

import java.beans.beancontext.*;
import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        String log = request.getParameter("login");
        String mdp = request.getParameter("motdepasse");
        String que = request.getParameter("question");
        String rep = request.getParameter("reponse");
        String strInsert = "INSERT INTO sys.users(login,mdp,question,reponse) VALUES (' "+log+"','"+mdp+"','"+que+"','"+rep+"')";

        Statement st = null;
        try {
            st = DBManager.getConnection().createStatement();
        // On exécute la requête
            System.out.println(st);
            st.executeUpdate(strInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //forwarding vers la page accueil (garde les paramètres)
        this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
    }
}