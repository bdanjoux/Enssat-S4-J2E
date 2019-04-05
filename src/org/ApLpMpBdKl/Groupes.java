package org.ApLpMpBdKl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Groupes extends HttpServlet{
    public static final String VUE = "/WEB-INF/Groupes.jsp";

    /* méthode GET qui appelle la page connexion.jsp */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        //System.out.println("avant de récupérer le jsp");

        Statement st = null;
        String strInsert = "SELECT DISTINCT IdGroupePere FROM etudiants.groupes";
        ArrayList<GroupeEtu> grps = new ArrayList<GroupeEtu>();
        try {
            st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête

            ResultSet rs = st.executeQuery(strInsert);
            while(rs.next()){
                if(rs.getString(1)!=null){
                    grps.add(new GroupeEtu(rs.getInt(1)));
                }
            }
            System.out.println("Number of Groups "+grps.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("groupes",grps);
        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        //System.out.println("jsp récupéré");
    }
}
