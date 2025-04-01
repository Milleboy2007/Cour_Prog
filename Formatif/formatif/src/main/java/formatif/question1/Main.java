package formatif.question1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
Random random = new Random(1);

        
        Groupe groupe4 = new Groupe(
            "420-210",
            new ArrayList<>(
                Arrays.asList(
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
                    new Etudiant(3267419, "Daniel")
                )
            )
        );
        for(int i = 0; i < groupe4.nbEtudiants() ; i++){
            for(int j = 0 ; j < groupe4.getEtudiant(i).getNbEvaluation() ; j++){
                groupe4.getEtudiant(i).getEvaluation(j).setNoteSur100((byte) (random.nextInt(71) + 30));
            }
        }
        groupe4.afficheResultats();
        System.out.println();
        groupe4.trierParNote();
        groupe4.afficheResultats();
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
    public Evaluation getEvaluation(int index) {
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

        System.out.print( getDa() +" "+ getNomComplet() + " ");
        
        for (int i = 0; i < evaluations.length; i++) {
            System.out.print(evaluations[i].notePonderee() + " ");
        }

        System.out.println("| " + noteFinal());

    }
}

class Groupe{

    private String nomCours;
    private ArrayList<Etudiant> etudiants;

    public Groupe(String nomCours, ArrayList<Etudiant> etudiants ){
        this.setNomCours(nomCours);
        this.etudiants = etudiants;
    }

    public String setNomCours(String nomCours){
        return this.nomCours = nomCours;
    }

    public Etudiant getEtudiant(int index){
        return etudiants.get(index);
    }

    public int nbEtudiants(){
        return etudiants.size();
    }

    public void afficheResultats(){
        for(int i = 0 ; i < this.etudiants.size() ; i++){
            this.etudiants.get(i).afficheResultat();
        }
    }

    public void trierParNote(){
        Collections.sort(this.etudiants, (etudiant1,etudiant2) -> comparerEtudiant(etudiant1, etudiant2));
    }
    public int comparerEtudiant(Etudiant etudiant1,Etudiant etudiant2){
        int result = -1 * Byte.compare(etudiant1.noteFinal(), etudiant2.noteFinal());
        
        if(result == 0){
            result = etudiant1.getNomComplet().compareTo(etudiant2.getNomComplet());
        }

        return result;
    }
}