package org.ApLpMpBdKl;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name="SqlConnector",loadOnStartup=1)
public class SQLConnector{
    /* Connexion à la base de données */
    String url = "jdbc:mysql://localhost:3306/";
    String utilisateur = "stupidJavaUser";
    String motDePasse = "jcpjvpiz782098481";
    Connection connexion = null;
    static SQLConnector instance = null;

    public SQLConnector(){
        this.getInstance().connect();
    }

    public static SQLConnector getInstance() {
        if (instance == null) {
            instance = new SQLConnector();
        }
        return instance;
    }


    public void connect() {
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);


            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */

        } catch (SQLException e) {
            System.out.println("Oups il y a eu un problème de connexion");
            /* Gérer les éventuelles erreurs ici */
        } finally {
            if (connexion != null)
                try {
                    /* Fermeture de la connexion */
                    System.out.println("Fermeture de la connexion");
                    connexion.close();
                } catch (SQLException ignore) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
    }
}
