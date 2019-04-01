package org.ApLpMpBdKl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;



@Singleton
@Startup
public class SQLConnector{
    /* Connexion à la base de données */
    private final String url = "jdbc:mysql://localhost:3306/?characterEncoding=latin1";
    private final String utilisateur = "stupidJavaUser";
    private final String motDePasse = "kfpafpez7882kpfez";
    Connection connexion = null;
    @PostConstruct
    public void connect() {
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        }
        catch(java.sql.SQLException exception){
            System.out.println("Oups");
        }
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);


            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */

        } catch (SQLException e) {
            System.out.println("Oups il y a eu un problème de connexion");
            e.printStackTrace();
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
