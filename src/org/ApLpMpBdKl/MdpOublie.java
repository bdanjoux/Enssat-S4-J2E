package org.ApLpMpBdKl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class MdpOublie extends HttpServlet {
    public static final String VUE = "/WEB-INF/MdpOublie.jsp";

    /* méthode GET pour récupérer le login*/
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /* méthode POST pour afficher la question */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        String log = request.getParameter("login");
        // String que = request.getParameter("question");
        // String rep = request.getParameter("reponse");
        String question = "SELECT question FROM sys.users WHERE login='"+request.getParameter("login")+"')";
        System.out.println(question);
        // String strInsert = "SELECT * FROM sys.users WHERE login='"+request.getParameter("login")+"' AND reponse='"+request.getParameter("question")+"'";

    }
}
