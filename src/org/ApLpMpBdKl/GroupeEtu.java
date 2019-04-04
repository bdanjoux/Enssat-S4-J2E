package org.ApLpMpBdKl;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class GroupeEtu {

    private String nomGroupe;
    private String nomProprio;
    private Date dateCrea;
    HashSet<Etudiant> listeEtu = new HashSet<Etudiant>();

    //Constructeur
    public GroupeEtu(){

    }

    //Getters et Setters
    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomProprio() {
        return nomProprio;
    }

    public void setNomProprio(String nomProprio) {
        this.nomProprio = nomProprio;
    }

    public Date getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    public HashSet<Etudiant> getListeEtu() {
        return listeEtu;
    }

    public void setListeEtu(HashSet<Etudiant> listeEtu) {
        this.listeEtu = listeEtu;
    }

    //Méthodes de classe
    public void ajoutEtu(Etudiant e)
    {
        boolean err;
        err = this.listeEtu.add(e);
        if(err == false)
        {
            System.out.println("L'étudiant est déjà dans le groupe");
        }
    }

    public void supprEtu(Etudiant e)
    {
        boolean err;
        err = this.listeEtu.remove(e);
        if(err != true)
        {
            System.out.println("L'étudiant n'était pas dans le groupe");
        }
    }


}
