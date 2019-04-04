package org.ApLpMpBdKl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Etudiants extends HttpServlet{
    public static final String VUE = "/WEB-INF/Etudiant.jsp";

    /* méthode GET qui appelle la page connexion.jsp */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        //System.out.println("avant de récupérer le jsp");
        Id id = new Id(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("student", new Etudiant(id.id));
        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        //System.out.println("jsp récupéré");
    }
}
