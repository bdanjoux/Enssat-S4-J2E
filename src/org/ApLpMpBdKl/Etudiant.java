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
    private String serieBac=null;
    private Date dateBac=null;
    private String mentionBac=null;
    private String diplome=null;
    private Date dateDiplome=null;
    private String villeDiplome=null;

    public Etudiant(int id){
        this.setId(id);
        System.out.println("Hey i'm a new student with the id: "+id);
        this.pullAllFromDatabase();
    }

    public Etudiant(String id, String nom, String prenom, Date dateNaissance, String courrielPro, String courrielPerso, String SerieBac, Date dateBac, String mentionBac, String diplome, Date dateDiplome, String villeDiplome){
        this.setId(Integer.parseInt(id));
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);

        try {
            this.setCourrielPro(new InternetAddress(courrielPro));
            this.setCourrielPerso(new InternetAddress(courrielPerso));
        }catch (AddressException e){
            e.printStackTrace();
        }
        this.setSerieBac(SerieBac);
        this.setDateBac(dateBac);
        this.setMentionBac(mentionBac);
        this.setDiplome(diplome);
        this.setDateDiplome(dateDiplome);
        this.setVilleDiplome(villeDiplome);
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
                this.setSerieBac(rs.getString(7));

                this.setDateBac(rs.getDate(8));
                this.setMentionBac(rs.getString(9));
                this.setDiplome(rs.getString(10));
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

    public String getSerieBac() {
        return serieBac;
    }

    public void setSerieBac(String serieBac) {
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

    public String getMentionBac() {
        return mentionBac;
    }

    public void setMentionBac(String mentionBac) {
        this.mentionBac = mentionBac;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
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
            this.setVilleDiplome(this.getStringFromId("villeDiplome"));
        }
        return villeDiplome;
    }

    public void setVilleDiplome(String villeDiplome) {
        this.villeDiplome = villeDiplome;
    }
}
