public class Exo9 {

    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant(1234567, "Jean Dupont");
        etudiant.evaluation[0].noteSur100 = 50;
        etudiant.evaluation[1].noteSur100 = 67;
        etudiant.evaluation[2].noteSur100 = 100;

        etudiant.afficheResultat();
    }
}

    class Etudiant {
        int DA;
        String nomComplet;
        Evaluation[] evaluation = {
                new Evaluation("1", 0.2f),
                 new Evaluation("2", 0.3f),
                  new Evaluation("3", 0.5f) };

        public Etudiant(int DA, String nomComplet) {
            this.DA = DA;
            this.nomComplet = nomComplet;
        }

        public byte noteFinal() {
            return (byte) (evaluation[0].notePonderee() + evaluation[1].notePonderee() + evaluation[2].notePonderee());
        }

        public void afficheResultat(){
            System.out.println(this.DA + " " + this.nomComplet + " " + evaluation[0].noteSur100 + " " + evaluation[1].noteSur100 + " " + evaluation[2].noteSur100 + "|" + noteFinal());
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

