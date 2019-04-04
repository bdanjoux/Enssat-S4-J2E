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
import java.util.ArrayList;
import java.util.List;

public class GestionUsers extends HttpServlet{
    public static final String VUE = "/WEB-INF/GestionUsers.jsp";
    String priv = (String) "";

    /* méthode GET qui appelle la page connexion.jsp */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        String strInsert = "SELECT login, droits FROM sys.users";

        Statement st = null;
        try {
            st = DBManager.getConnection().createStatement();
            if (st == null) {
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);

            //On récupère les résultats dans des listes qu'on affichera sur la page
            List<String> log=new ArrayList<String>();
            List<String> drt=new ArrayList<String>();
            while (rs.next()) {
                log.add(rs.getString("login"));
                drt.add(rs.getString("droits"));
            }
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* méthode POST */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    }
    String priv = (String) "";
}
