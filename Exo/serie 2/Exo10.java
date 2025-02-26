import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Exo10 {
    public static void main(String[] args) {
        Random random = new Random(1);
        Groupe groupe4 = new Groupe("Prog",
                new ArrayList<>(Arrays.asList(
                        new Etudiant(1832491, "Alice"),
                        new Etudiant(2468103, "Bob"),
                        new Etudiant(3726145, "Charlie"),
                        new Etudiant(4859021, "David"),
                        new Etudiant(5983472, "Eve"),
                        new Etudiant(6129048, "Frank"),
                        new Etudiant(7235146, "Grace"),
                        new Etudiant(8376012, "Hannah"),
                        new Etudiant(9453023, "Isaac"),
                        new Etudiant(1023485, "Jack"),
                        new Etudiant(2135749, "Karen"),
                        new Etudiant(3201854, "Louis"),
                        new Etudiant(4337602, "Mona"),
                        new Etudiant(5498321, "Nathan"),
                        new Etudiant(6571984, "Olivia"),
                        new Etudiant(7612493, "Paul"),
                        new Etudiant(8793461, "Quincy"),
                        new Etudiant(9834527, "Rachel"),
                        new Etudiant(1056743, "Sam"),
                        new Etudiant(2187630, "Tina"),
                        new Etudiant(3265984, "Ursula"),
                        new Etudiant(4306715, "Victor"),
                        new Etudiant(5394120, "Wendy"),
                        new Etudiant(6412309, "Xander"),
                        new Etudiant(7523018, "Yara"),
                        new Etudiant(8654092, "Zane"),
                        new Etudiant(9735084, "Amy"),
                        new Etudiant(1087416, "Ben"),
                        new Etudiant(2158367, "Clara"),
                        new Etudiant(3267419, "Daniel"))));

        // Attribuer des notes aléatoires entre 30 et 100 pour chaque évaluation
        for (int i = 0; i < groupe4.etudiants.size(); i++) {
            for (int j = 0; j < groupe4.etudiants.get(i).evaluations.length; j++) {
                groupe4.etudiants.get(i).evaluations[j].noteSur100 = (byte) (random.nextInt(71) + 30);
            }
        }

        // Afficher les résultats avant le tri
        groupe4.afficheResultats();

        System.out.println("\n--- Après tri par note finale ---");
        // Trier les étudiants par note finale et afficher à nouveau
        groupe4.trierParNote();
        groupe4.afficheResultats();
    }
}

class Etudiant {
    int DA;
    String nomComplet;
    Evaluation[] evaluations = {
            new Evaluation("1", 0.2f),
            new Evaluation("2", 0.3f),
            new Evaluation("3", 0.5f) };

    public Etudiant(int DA, String nomComplet) {
        this.DA = DA;
        this.nomComplet = nomComplet;
    }
    public byte noteFinal() {
        return (byte) (evaluations[0].notePonderee() + evaluations[1].notePonderee() + evaluations[2].notePonderee());
    }

    public void afficheResultat(){
        System.out.println(this.DA + " " + this.nomComplet + " " + evaluations[0].noteSur100 + " " + evaluations[1].noteSur100 + " " + evaluations[2].noteSur100 + " | " + noteFinal());
    }
}

class Groupe {
    String nomCours;
    ArrayList<Etudiant> etudiants;

    public Groupe(String nomCours, ArrayList<Etudiant> etudiants){
        this.nomCours = nomCours;
        this.etudiants = etudiants;
    }

    public void afficheResultats(){
        for (int i = 0; i < this.etudiants.size(); i++) {
            this.etudiants.get(i).afficheResultat();
        }
    }

    public void trierParNote(){
        Collections.sort(this.etudiants, (etudiant1,etudiant2) -> -1 *Byte.compare(etudiant1.noteFinal(),etudiant2.noteFinal()));
    }

}

class Evaluation {
    String nom;
    float ponderation;
    byte noteSur100;

    public Evaluation(String nom, float ponderation) {
        this.nom = nom;
        this.ponderation = ponderation;
        this.noteSur100 = 100;
    }

    public byte notePonderee(/*byte noteSur100, float ponderation*/) {
        return (byte) (noteSur100 * ponderation);
    }
}