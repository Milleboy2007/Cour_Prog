public class Etudiant{
    String nom;
    int age;
    
    public Etudiant(String nom, int age){
        this.nom = nom;
        this.age = age;
    }

    public void afficher(){
        System.out.println(this.nom + " a " + this.age);
    }

    public static void afficher2(){
        System.out.println("afficher2");
    }

    public static void main(String[] args) {
        Etudiant maxi = new Etudiant("Bob", 15);
        Etudiant yassin = new Etudiant("Yassin", 35);
        maxi.afficher();
        yassin.afficher();
        afficher2();
        Etudiant.afficher2();
       

    }
}