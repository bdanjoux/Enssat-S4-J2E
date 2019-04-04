package org.ApLpMpBdKl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class Accueil extends HttpServlet {
    public static final String VUE = "/WEB-INF/Accueil.jsp";
    private String log ="marche pas";

    /* méthode GET pour afficher le questionnaire*/
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        System.out.println("\n NORMALEMENT login =  " + request.getParameter("login") + "\n");
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /* méthode POST */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        System.out.println("mdp avant \n ");
        String mdp = request.getParameter("motdepasse");
        System.out.println("mdp après  : " + mdp  );
        System.out.println("\n que anvant \n ");
        String que = request.getParameter("question");
        System.out.println("\n que après :   " + que );
        System.out.println("\n rep avant \n ");
        String rep = request.getParameter("reponse");
        System.out.println("\n rep après :   " + rep);
        System.out.println("login : "+(String)request.getSession().getAttribute("login") +"\n");
        String strInsert = "UPDATE sys.users SET mdp= '"+mdp+"', question = '"+que+"', reponse='"+rep+"' WHERE login ='"+(String)request.getSession().getAttribute("login")+"'";
        Statement st = null;
        try {
            st = DBManager.getConnection().createStatement();
            st.executeUpdate(strInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
