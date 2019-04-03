package org.ApLpMpBdKl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {
    public static final String VUE = "/WEB-INF/Inscription.jsp";

    /* méthode GET qui appelle la page inscription.jsp */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /* méthode POST */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        // il va falloir envoyer les réponses du formulaire dans la BDD
        //forwarding vers la page accueil (garde les paramètres)
        this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp" ).forward( request, response ); //TODO attente adresse accueil
    }
}