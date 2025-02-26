import java.util.ArrayList;


public class Personne {

    String nom;
    int age;

    public Personne(String nom, int age){
        this.nom = nom;
        this.age = age;
    }

    public void afficher(){
        System.out.println(this.nom + " " + this.age);
    }

    @Override
    public String toString(){
        return this.nom + " : " + this.age;
    }

    public static void main(String[] args) {
        ArrayList<Personne> liste = new ArrayList<>();
        liste.add(new Personne("Henry", 25));
        liste.add(new Personne("Roman", 23));
        liste.add(new Personne("Leandro", 35));

        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i));
        }
        

    }
    
    }

