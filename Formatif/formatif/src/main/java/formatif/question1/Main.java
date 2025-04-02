package formatif.question1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Evaluation {
    private String nom;
    private float ponderation;
    private byte noteSur100 = 0;

    public Evaluation(String nom, float ponderation) {
        this.nom = nom;
        this.ponderation = ponderation;
    }

    public byte notePonderee() {
        return (byte) (this.ponderation * this.noteSur100);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPonderation() {
        return ponderation;
    }

    public void setPonderation(float ponderation) {
        this.ponderation = ponderation;
    }

    public byte getNoteSur100() {
        return noteSur100;
    }

    public void setNoteSur100(byte noteSur100) {
        this.noteSur100 = noteSur100;
    }
}

class Etudiant{
    private int da;
    private String nomComplet;
    private Evaluation[] evaluations = {
        new Evaluation("Examen1",0.2f),
        new Evaluation("Examen2", 0.3f),
        new Evaluation("Examen Final", 0.5f)};

    public Etudiant(int da, String nomComplet){
        setDa(da);
        setNomComplet(nomComplet);
    }

    public void setDa(int da) {
        this.da = da;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public int getDa() {
        return da;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public Evaluation getEvaluations(int index) {
        try{
            return evaluations[index];
        }catch(IndexOutOfBoundsException e){
            System.out.println("Pas assez d'éval");
            return null;
        }
    }
    public int getNbEvaluation(){
        return evaluations.length;
    }
    
    public byte noteFinal(){
        byte noteFinal = 0;
        for (int i = 0; i < evaluations.length; i++) {
            noteFinal += evaluations[i].notePonderee();
        }
        return noteFinal;
    }

    public void afficheResultat(){
       
        

        noteFinal();

        System.out.println( getDa() +" "+ getNomComplet() +" "+ evaluations[0].notePonderee() );

    }
}