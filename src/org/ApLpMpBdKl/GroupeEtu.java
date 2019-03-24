package org.ApLpMpBdKl;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupeEtu implements EtuInterface{

    private String nomGroupe;
    private String nomProprio;
    private Date dateCrea;
    HashSet<EtuInterface> listeEtu = new HashSet<EtuInterface>();

    //Constructeur
    public GroupeEtu(){

    }

    //Getters et Setters
    public String getNomGroupe() {
        return nomGroupe;
    }

    @Override
    public Set<Id> getId() {
        HashSet<Id> ret = new HashSet<Id>();
        int i=0;
        Iterator<EtuInterface> it = listeEtu.iterator();
        while (it.hasNext() && i<listeEtu.size()){
            ret.addAll(it.next().getId());
        }
        return ret;
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
        HashSet<Etudiant> ret = new HashSet<Etudiant>();
        Iterator<EtuInterface> it = listeEtu.iterator();
        while (it.hasNext()){
            EtuInterface current=it.next();
            if(current instanceof Etudiant){
                ret.add((Etudiant) current);
            }else if(current instanceof GroupeEtu){
                ret.addAll(((GroupeEtu) current).getListeEtu());
            }
        }
        return ret;
    }

    public void setListeEtu(HashSet<Etudiant> listeEtu) {
        this.listeEtu = new HashSet<EtuInterface>();
        Iterator<Etudiant> it =listeEtu.iterator();
        while (it.hasNext()){
            this.listeEtu.add(it.next());
        }
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
