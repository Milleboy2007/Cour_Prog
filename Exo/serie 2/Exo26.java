public class Exo26 {
    public static void main(String[] args) {
        Chien chien = new Chien("Rex", 3, "Berger Allemand");
        Chat chat = new Chat("Matou", 12, "Sphinx");
        
    
        chien.sePresenter();
        chien.parler();
    
        chat.sePresenter();
        chat.parler();
    }
}

class Animal{
    private String nom;
    private int age;
    private String race;

    public Animal(String nom, int age, String race){
        this.setAge(age);
        this.setNom(nom);
        this.setRace(race);
    }

    public void setNom(String nom){
        this.nom = nom;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setRace(String race){
        this.race = race;
    }

    public int getAge() {
        return age;
    }
    public String getNom() {
        return nom;
    }
    public String getRace() {
        return race;
    }

}

class Chien extends Animal{
    public Chien(String nom, int age, String race){
        super(nom,age,race);
    }

    public void parler(){
        System.out.println("Woof!");
    }

    public void sePresenter(){
        System.out.println("Je suis un " + getRace() + ", mon nom est " + getNom() + ", j'ai " + getAge() + " ans Woof!");
    }
}

class Chat extends Animal{
    public Chat(String nom, int age, String race){
        super(nom,age,race);
    }
    public void parler(){
        System.out.println("Meow!");
    }

    public void sePresenter(){
        System.out.println("Je suis un " + getRace() + ", mon nom est " + getNom() + ", j'ai " + getAge() + " ans Meow!");
    }
}