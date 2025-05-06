package exam.question1;

import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) {
        Prof maxime = new Prof("Maxime");

    Tuteur tuteur1 = new Tuteur("Léa");
    Tuteur tuteur2 = new Tuteur("Julien");
    Tuteur tuteur3 = new Tuteur("Sophie");
    
    EtudiantInformatique etudiant1 = new EtudiantInformatique("Lucas");
    EtudiantInformatique etudiant2 = new EtudiantInformatique("Emma");
    EtudiantInformatique etudiant3 = new EtudiantInformatique("Hugo");
    EtudiantInformatique etudiant4 = new EtudiantInformatique("Chloé");
    EtudiantInformatique etudiant5 = new EtudiantInformatique("Nathan");
    EtudiantInformatique etudiant6 = new EtudiantInformatique("Jade");
    EtudiantInformatique etudiant7 = new EtudiantInformatique("Noah");
    EtudiantInformatique etudiant8 = new EtudiantInformatique("Inès");
    
    
    Personne[] tous = {
        maxime,
        tuteur1,
        tuteur2,
        tuteur3,
        etudiant1,
        etudiant2,
        etudiant3,
        etudiant4,
        etudiant5,
        etudiant6,
        etudiant7,
        etudiant8,
    };
    Employer[] listeEmployer = {
        maxime,
        tuteur1,
        tuteur2,
        tuteur3
    };
    
    
    Etudiant[] listeEtudiant = {
        etudiant1,
        etudiant2,
        etudiant3,
        etudiant4,
        etudiant5,
        etudiant6,
        etudiant7,
        etudiant8,
        tuteur1,
        tuteur2,
        tuteur3
    };
    for(Personne personne : tous){
        personne.afficheInfo();
    }

    System.out.println("---------------------------");
    for(Employer employe : listeEmployer){
        employe.showImplementation();
    }
    System.out.println("---------------------------");
    for(Etudiant etudiant : listeEtudiant){
        etudiant.showImplementation();
    }
    System.out.println("---------------------------");        
    
    for(Employer employe : listeEmployer){
        employe.paie();
    }
    
    System.out.println("---------------------------");



    //-----trier ici-----
    Arrays.sort(tous, new Comparator<Personne>() {
        @Override
        public int compare(Personne personne1, Personne personne2){
            return personne1.getNom().compareTo(personne2.getNom());
        }
    });
    //-------------------


    for(Personne personne : tous){
        personne.afficheInfo();
    }      
    }
}

interface Employer {
    abstract void paie();
    default void showImplementation(){
        System.out.println("Je suis un employé");
    }
}

interface Etudiant {    
    abstract boolean presence();
    default void showImplementation(){
        System.out.println("Je suis un étudiant");
    }
}

abstract class Personne{
    private String nom;

    public Personne(String nom){
        setNom(nom);
    }

    abstract void afficheInfo();

    void setNom(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}

class Prof extends Personne implements Employer{
    int banque = 0;

    public Prof(String nom){
        super(nom);
    }

    public void paie(){
        this.banque += 2000;
    }

    void afficheInfo(){
        System.out.println("Je suis le professeur " + this.getNom() + " : Banque -> " + this.banque);
    }
}

class Tuteur extends Personne implements Employer, Etudiant{
    int banque = 0;

    public Tuteur(String nom){
        super(nom);
    }

    void afficheInfo(){
        System.out.println("Je suis " + this.getNom() + "(Étudiant) : Banque -> " + this.banque);
    }

    public void paie(){
        this.banque += 200;
    }

    public boolean presence(){
        return (int) (Math.random() * 101) < 90;
    }

    @Override
    public void showImplementation(){
        System.out.println("Je suis un employé et un étudiant");
    }
}

class EtudiantInformatique extends Personne implements Etudiant{
    public EtudiantInformatique(String nom){
        super(nom);
    }

    public boolean presence(){
        return (int) (Math.random() * 101) < 60;
    }

    @Override
    void afficheInfo() {
        System.out.println("Je suis " + this.getNom() + "(Étudiant)");
    }
}