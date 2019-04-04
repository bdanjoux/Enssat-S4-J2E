package org.ApLpMpBdKl;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

enum SerieBac {S,L,ES}
enum MentionBac {AssezBien,Bien,TresBien}
enum Diplome {Brevet,Bac,L1,L2,L3,M1,M2}

public class Etudiant extends HttpServlet implements EtuInterface{
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
    private Id id=null;
    private String nom=null;
    private String prenom=null;
    private Date dateNaissance=null;
    private InternetAddress courrielPro=null;
    private InternetAddress  courrielPerso=null;
    private SerieBac serieBac=null;
    private Date dateBac=null;
    private MentionBac mentionBac=null;
    private Diplome diplome=null;
    private Date dateDiplome=null;
    private String villeDiplome=null;

    public Etudiant(int id){
        this.setId(id);
        this.pullAllFromDatabase();
    }

    public Etudiant(){

    }

    public void newEtudiant(){
        String strInsert = "INSERT INTO etudiants.table_name (nom,prenom,dateNaissance) VALUES ('nom','prenom','2000/01/01')";
        Statement st = null;
        try {
            st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            st.executeUpdate(strInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        strInsert = "SELECT MAX(id) FROM etudiants.table_name WHERE nom='nom' AND prenom='prenom'";

        try {
            st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            if(rs.next()){
                this.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public HashSet<Id> getId() {
        HashSet<Id> ret = new HashSet<Id>();
        ret.add(id);
        return ret;
    }


    private String getStringFromId(String strName){
        System.out.println("getStringFromId was called");
        String strInsert = "SELECT "+strName+" FROM etudiants.table_name WHERE id="+this.id.id;
        String retString="null";
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            if(rs.next()){
                retString=rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retString;
    }

    private int getIntFromId(String intName){
        String strInsert = "SELECT "+intName+" FROM etudiants.table_name WHERE id="+this.id.id;
        int retInt=0;
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            if(rs.next()){
                retInt=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retInt;
    }

    private void pullAllFromDatabase(){
        String strInsert = "SELECT * FROM etudiants.table_name WHERE id="+this.id.id;
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            if(rs.next()){
                this.setNom(rs.getString(2));
                this.setPrenom(rs.getString(3));
                this.setDateNaissance(rs.getDate(4));
                try {
                    this.setCourrielPro(new InternetAddress(rs.getString(5)));
                    this.setCourrielPerso(new InternetAddress(rs.getString(6)));
                }catch (AddressException e){
                    e.printStackTrace();
                }
                String serie = rs.getString(7);
                if(serie!=null){
                    switch (serie){
                        case "S" : this.setSerieBac(SerieBac.S);break;
                        case "L" : this.setSerieBac(SerieBac.L);break;
                        case "ES" : this.setSerieBac(SerieBac.ES);break;
                    }
                }
                this.setDateBac(rs.getDate(8));
                String mention = rs.getString(9);
                if(mention!=null){
                    switch (mention){
                        case "AssezBien" : this.setMentionBac(MentionBac.AssezBien);break;
                        case "Bien" : this.setMentionBac(MentionBac.Bien);break;
                        case "TresBien" : this.setMentionBac(MentionBac.TresBien);break;
                    }
                }
                String diplome = rs.getString(10);
                if(diplome!=null){
                    switch (diplome){
                        case "Bac" : this.setDiplome(Diplome.Bac);break;
                        case "Brevet" : this.setDiplome(Diplome.Brevet);break;
                        case "L1" : this.setDiplome(Diplome.L1);break;
                        case "M1" : this.setDiplome(Diplome.M1);break;
                        case "L2" : this.setDiplome(Diplome.L2);break;
                        case "M2" : this.setDiplome(Diplome.M2);break;
                        case "L3" : this.setDiplome(Diplome.L3);break;
                    }
                }
                this.setDateDiplome(rs.getDate(11));
                this.setVilleDiplome(rs.getString(12));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Date getDateFromId(String dateName){
        String strInsert = "SELECT "+dateName+" FROM etudiants.table_name WHERE id="+this.id.id;
        Date retDate=null;
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            if(rs.next()){
                retDate=rs.getDate(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retDate;
    }


    public void setId(int id) {
        this.id = new Id(id);
    }

    public String getNom() {
        if(this.nom==null && this.id!=null){
            System.out.println("had to pull individual data from the database");
            this.setNom(this.getStringFromId("nom"));
        }
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        if(this.prenom==null && this.id!=null) {
            System.out.println("had to pull individual data from the database");
            this.setPrenom(this.getStringFromId("prenom"));
        }
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        if(this.dateNaissance==null && this.id!=null){
            System.out.println("had to pull individual data from the database");
            this.setDateNaissance(this.getDateFromId("dateNaissance"));
        }
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public InternetAddress getCourrielPro() {
        if(this.courrielPro==null && this.id!=null){
            System.out.println("had to pull individual data from the database");
            try {
                this.setCourrielPro(new InternetAddress(this.getStringFromId("courrielPro")));
            }catch (AddressException e){
                e.printStackTrace();
            }
        }
        return courrielPro;
    }

    public void setCourrielPro(InternetAddress courrielPro) {
        this.courrielPro = courrielPro;
    }

    public InternetAddress getCourrielPerso() {
        if(this.courrielPerso==null && this.id!=null){
            System.out.println("had to pull individual data from the database");
            try {
                this.setCourrielPerso(new InternetAddress(this.getStringFromId("courrielPerso")));
            }catch (AddressException e){
                e.printStackTrace();
            }
        }
        return courrielPerso;
    }

    public void setCourrielPerso(InternetAddress courrielPerso) {
        this.courrielPerso = courrielPerso;
    }

    public SerieBac getSerieBac() {
        if(this.serieBac==null && this.id!=null) {
            System.out.println("had to pull individual data from the database");
            String serie = this.getStringFromId("serieBac");
            switch (serie){
                case "S" : this.setSerieBac(SerieBac.S);break;
                case "L" : this.setSerieBac(SerieBac.L);break;
                case "ES" : this.setSerieBac(SerieBac.ES);break;
            }
        }
        return serieBac;
    }

    public void setSerieBac(SerieBac serieBac) {
        this.serieBac = serieBac;
    }

    public Date getDateBac() {
        if(this.dateBac==null && this.id!=null){
            System.out.println("had to pull individual data from the database");
            this.setDateBac(this.getDateFromId("dateBac"));
        }
        return dateBac;
    }

    public void setDateBac(Date dateBac) {
        this.dateBac = dateBac;
    }

    public MentionBac getMentionBac() {
        if(this.mentionBac==null && this.id!=null) {
            System.out.println("had to pull individual data from the database");
            String mention = this.getStringFromId("mentionBac");
            switch (mention){
                case "AssezBien" : this.setMentionBac(MentionBac.AssezBien);break;
                case "Bien" : this.setMentionBac(MentionBac.Bien);break;
                case "TresBien" : this.setMentionBac(MentionBac.TresBien);break;
            }
        }
        return mentionBac;
    }

    public void setMentionBac(MentionBac mentionBac) {
        this.mentionBac = mentionBac;
    }

    public Diplome getDiplome() {
        if(this.diplome==null && this.id!=null) {
            System.out.println("had to pull individual data from the database");
            String diplome = this.getStringFromId("diplome");
            switch (diplome){
                case "Bac" : this.setDiplome(Diplome.Bac);break;
                case "Brevet" : this.setDiplome(Diplome.Brevet);break;
                case "L1" : this.setDiplome(Diplome.L1);break;
                case "M1" : this.setDiplome(Diplome.M1);break;
                case "L2" : this.setDiplome(Diplome.L2);break;
                case "M2" : this.setDiplome(Diplome.M2);break;
                case "L3" : this.setDiplome(Diplome.L3);break;
            }
        }
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public Date getDateDiplome() {
        if(this.dateDiplome==null && this.id!=null){
            System.out.println("had to pull individual data from the database");
            this.setDateDiplome(this.getDateFromId("dateDiplome"));
        }
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    public String getVilleDiplome() {
        if(this.villeDiplome==null && this.id!=null) {
            System.out.println("had to pull individual data from the database");
            this.setVilleDiplome(this.getStringFromId("villeDipome"));
        }
        return villeDiplome;
    }

    public void setVilleDiplome(String villeDiplome) {
        this.villeDiplome = villeDiplome;
    }
}
