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



}
