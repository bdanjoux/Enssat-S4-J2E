package org.ApLpMpBdKl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Connexion extends HttpServlet{
    public static final String VUE = "/WEB-INF/Connexion.jsp";

    /* méthode GET qui appelle la page connexion.jsp */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /* méthode POST */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        //récupérer les réponses du formulaire et comparer à la BDD
        //redirection vers la page accueil
        //response.sendRedirect(accueil.jsp); //TODO attente adresse accueil
    }
}
