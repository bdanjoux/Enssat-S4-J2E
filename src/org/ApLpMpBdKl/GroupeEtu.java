package org.ApLpMpBdKl;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupeEtu extends HttpServlet implements EtuInterface{
    public static final String VUE = "/WEB-INF/Groupe.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        //System.out.println("avant de récupérer le jsp");
        GroupeEtu ngru = new GroupeEtu(Integer.parseInt(request.getParameter("id")));
        HashSet<Etudiant> hashEtu= new HashSet<Etudiant>();
        HashSet<Id> hashId=(HashSet<Id>) ngru.getId();
        Iterator<Id> itid = hashId.iterator();
        while (itid.hasNext()){
            hashEtu.add(new Etudiant(itid.next().id));
        }
        request.setAttribute("childs", hashEtu);
        request.setAttribute("SubGroups", ngru.getSubGroups());
        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        //System.out.println("jsp récupéré");
    }

    private Id id=null;
    private String nomGroupe=null;
    private String nomProprio=null;
    private Date dateCrea=null;
    HashSet<EtuInterface> listeEtu = new HashSet<EtuInterface>();

    //Constructeur
    public GroupeEtu(){

    }

    public GroupeEtu(int id){
        this.id=new Id(id);
        System.out.println("Hey i'm a new group with the id: "+id);
        this.pullAllFromDatabase();
    }

    //Getters et Setters


    public String getNomGroupe() {
        return nomGroupe;
    }

    public void pullAllFromDatabase(){
        if(id!=null){
            String strInsert = "SELECT * FROM etudiants.groupes WHERE IdGroupePere="+this.id.id;
            try {
                Statement st = DBManager.getConnection().createStatement();
                if(st==null){
                    System.out.println("Erreur de connexion BDD");
                }
                // On exécute la requête
                ResultSet rs = st.executeQuery(strInsert);
                while (rs.next()){
                    System.out.println("New Line in the group");
                    // if the child is a student
                    if(rs.getInt(4)!=0){
                        System.out.println("It's a student");
                        listeEtu.add(new Etudiant(rs.getInt(4)));
                    // if the child is a group
                    }else if(rs.getInt(3)!=0){
                        System.out.println("It's another group");
                        listeEtu.add(new GroupeEtu(rs.getInt(3)));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

    public Set<GroupeEtu> getSubGroups() {
        HashSet<GroupeEtu> ret = new HashSet<GroupeEtu>();
        int i=0;
        Iterator<EtuInterface> it = listeEtu.iterator();
        while (it.hasNext() && i<listeEtu.size()){
            EtuInterface et=it.next();
            if(et instanceof GroupeEtu){
                ret.add((GroupeEtu)et);
            }
        }
        return ret;
    }

    public Id getSelfId() {
        return id;
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
