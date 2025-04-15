package exo.exo10;

public class Main {
    
}

interface Personne {
    abstract void afficheInfo();
}

interface Employer extends Personne {
    abstract void paie();
    default void showImplemention(){
        System.out.println("Je suis un employer");
    }

}

interface Etudiant extends Personne{
    abstract boolean presence();
    default void showImplemention(){
        System.out.println("Je suis un etudiant");
    }
}

class Prof implements Employer{
    protected String nom;
    protected int banque = 0;

    public Prof(String nom){
        this.nom = nom;
    }

    public void paie(){
        this.banque += 2000;
    }

    public void afficheInfo(){
        System.out.println("Je suis le professeur " + this.nom + " : Banque -> " + this.banque);
    }
}

class Tuteur implements Employer, Etudiant{
    protected String nom;
    protected int banque = 0;

    public Tuteur(String nom){
        this.nom = nom;
    }

    public void afficheInfo(){
        System.out.println("Je suis l'étudiant " + this.nom + " : Banque -> " + this.banque);
    }

    public void paie(){
        this.banque += 200;
    }

    public boolean presence(){
        int rand = (int) (Math.random()*100);
        return rand <= 90;
    }

    @Override
    public void showImplemention(){
        System.out.println("Je suis un etudiant et un prof");
    }
}

class EtudiantInformatique implements Etudiant{
    protected String nom;

    public EtudiantInformatique(String nom){
        this.nom = nom;
    }

    public boolean presence(){
        int rand = (int) (Math.random()*100);
        return rand <= 60;
    }

    public void afficheInfo(){
        System.out.println("Je suis l'étudiant " + this.nom);
    }
}