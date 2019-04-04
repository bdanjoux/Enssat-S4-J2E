package org.ApLpMpBdKl;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

enum SerieBac {S,L,ES}
enum MentionBac {AssezBien,Bien,TresBien}
enum Diplome {Brevet,Bac,L1,L2,L3,M1,M2}

public class Etudiant implements EtuInterface{


    private Id id=null;
    private String nom=null;
    private String prenom=null;
    private Date dateNaissance=null;
    private URL courrielPro=null;
    private URL courrielPerso=null;
    private SerieBac serieBac=null;
    private Date dateBac=null;
    private MentionBac mentionBac=null;
    private Diplome diplome=null;
    private Date dateDiplome=null;
    private String villeDiplome=null;

    public Etudiant(int id){
        this.setId(id);
        String strInsert = "SELECT * FROM table_name WHERE id='"+id+"'";
    }



    public Etudiant(){
        String strInsert = "INSERT INTO table_name (nom,prenom,dateNaissance) VALUES ('nom','prenom','2000/01/01')";

        Statement st = null;
        try {
            st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        strInsert = "SELECT MAX(id) FROM table_name WHERE nom='nom' AND prenom='prenom'";

        try {
            st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            this.setId(rs.getInt(1));
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
        String strInsert = "SELECT "+strName+" FROM table_name WHERE id='"+this.id+"'";
        String retString="null";
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            retString=rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retString;
    }

    private int getIntFromId(String intName){
        String strInsert = "SELECT "+intName+" FROM table_name WHERE id='"+this.id+"'";
        int retInt=0;
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            retInt=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retInt;
    }

    private Date getDateFromId(String dateName){
        String strInsert = "SELECT "+dateName+" FROM table_name WHERE id='"+this.id+"'";
        Date retDate=null;
        try {
            Statement st = DBManager.getConnection().createStatement();
            if(st==null){
                System.out.println("Erreur de connexion BDD");
            }
            // On exécute la requête
            ResultSet rs = st.executeQuery(strInsert);
            retDate=rs.getDate(1);
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
            this.setNom(this.getStringFromId("nom"));
        }
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        if(this.prenom==null && this.id!=null) {
            this.setPrenom(this.getStringFromId("prenom"));
        }
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        if(this.dateNaissance==null && this.id!=null){
            this.setDateNaissance(this.getDateFromId("dateNaissance"));
        }
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public URL getCourrielPro() {
        if(this.courrielPro==null && this.id!=null){
            try {
                this.setCourrielPro(new URL(this.getStringFromId("courrielPro")));
            }catch (MalformedURLException e){
                e.printStackTrace();
            }
        }
        return courrielPro;
    }

    public void setCourrielPro(URL courrielPro) {
        this.courrielPro = courrielPro;
    }

    public URL getCourrielPerso() {
        if(this.courrielPerso==null && this.id!=null){
            try {
                this.setCourrielPerso(new URL(this.getStringFromId("courrielPerso")));
            }catch (MalformedURLException e){
                e.printStackTrace();
            }
        }
        return courrielPerso;
    }

    public void setCourrielPerso(URL courrielPerso) {
        this.courrielPerso = courrielPerso;
    }

    public SerieBac getSerieBac() {
        if(this.serieBac==null && this.id!=null) {
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
            this.setDateBac(this.getDateFromId("dateBac"));
        }
        return dateBac;
    }

    public void setDateBac(Date dateBac) {
        this.dateBac = dateBac;
    }

    public MentionBac getMentionBac() {
        if(this.mentionBac==null && this.id!=null) {
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
            this.setDateDiplome(this.getDateFromId("dateDiplome"));
        }
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    public String getVilleDiplome() {
        if(this.villeDiplome==null && this.id!=null) {
            this.setVilleDiplome(this.getStringFromId("villeDipome"));
        }
        return villeDiplome;
    }

    public void setVilleDiplome(String villeDiplome) {
        this.villeDiplome = villeDiplome;
    }
}
