package org.ApLpMpBdKl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@WebServlet( name="Connexion", urlPatterns = "/connexion" )
public class Connexion extends HttpServlet{
    public static final String VUE = "/WEB-INF/Connexion.jsp";

    /* méthode GET qui appelle la page connexion.jsp */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        //System.out.println("avant de récupérer le jsp");
        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        //System.out.println("jsp récupéré");
    }

    /* méthode POST */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        //récupérer les réponses du formulaire et comparer à la BDD
        String strInsert = "SELECT * FROM sys.users WHERE login='"+request.getParameter("login")+"' AND mdp='"+request.getParameter("motdepasse")+"'";

        Statement st = null;
        try {
            st = DBManager.getConnection().createStatement();
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //redirection vers la page accueil si le compte est enregistré
        //response.sendRedirect(accueil.jsp); //TODO attente adresse accueil
    }
}
