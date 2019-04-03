package org.ApLpMpBdKl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;


@Singleton
@Startup
public class SQLConnector{
    /* Connexion à la base de données */
    private final String url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=latin1";
    private final String utilisateur = "stupidJavaUser";
    private final String motDePasse = "kfpafpez7882kpfez";
    private Connection connexion = null;

    public Connection getConnection(){
        return this.connexion;
    }

    @PostConstruct
    public void connect() {
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
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
                System.out.println("Connexion Ouverte");
        }
    }

    @PreDestroy
    public void deconnexion(){
        if(connexion!=null){
            System.out.println("Fermeture de la connexion");
            try {
                /* Fermeture de la connexion */
                connexion.close();
            } catch (SQLException ignore) {
                /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
            }
            System.out.println("Connexion fermée");
        }
    }

}
