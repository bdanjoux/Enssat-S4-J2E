package org.ApLpMpBdKl;

import java.net.URL;
import java.util.Date;

enum SerieBac {S,L,ES}
enum MentionBac {AssezBien,Bien,TresBien}
enum Diplome {Brevet,Bac,L1,L2,L3,M1,M2}

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private URL courrielPro;
    private URL courrielPerso;
    private SerieBac serieBac;
    private Date dateBac;
    private MentionBac mentionBac;
    private Diplome diplome;
    private Date dateDiplome;
    private String villeDiplome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public URL getCourrielPro() {
        return courrielPro;
    }

    public void setCourrielPro(URL courrielPro) {
        this.courrielPro = courrielPro;
    }

    public URL getCourrielPerso() {
        return courrielPerso;
    }

    public void setCourrielPerso(URL courrielPerso) {
        this.courrielPerso = courrielPerso;
    }

    public SerieBac getSerieBac() {
        return serieBac;
    }

    public void setSerieBac(SerieBac serieBac) {
        this.serieBac = serieBac;
    }

    public Date getDateBac() {
        return dateBac;
    }

    public void setDateBac(Date dateBac) {
        this.dateBac = dateBac;
    }

    public MentionBac getMentionBac() {
        return mentionBac;
    }

    public void setMentionBac(MentionBac mentionBac) {
        this.mentionBac = mentionBac;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    public String getVilleDiplome() {
        return villeDiplome;
    }

    public void setVilleDiplome(String villeDiplome) {
        this.villeDiplome = villeDiplome;
    }





}
