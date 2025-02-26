public class Exo8{


    public static void main(String[] args) {
        Evaluation uno = new Evaluation("onu",0.2f);
        uno.noteSur100 = 100;
        uno.afficherEvaluation();
        
    }
}

class Evaluation{
    String nom;
    float ponderation;
    byte noteSur100;


    public Evaluation(String nom, float ponderation){
        this.nom = nom;
        this.ponderation = ponderation;
        this.noteSur100 = 0;
    }

    public byte notePonderee(byte noteSur100, float ponderation){
        return (byte) (noteSur100 * ponderation);
    }

    public void afficherEvaluation(){
        System.out.println("Nom: " + nom);
        System.out.println("Ponderation: " + ponderation);
        System.out.println("Note: " + notePonderee(noteSur100, ponderation));
    }

}