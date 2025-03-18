/*import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        depense bouf = new depense("banane", 1.50f, Categorie.nourriture);
        System.out.println(bouf);
    }
}

enum Categorie{
    voyage, 
    santé, 
    habitation, 
    nourriture, 
    éducation, 
    loisir, 
    diver
}

class depense {
private String nom = "";
private float cout;
private Categorie categorie = Categorie.diver;

public depense(String nom, float cout, Categorie categorie){
    this.nom = nom;
    this.cout = cout;
    this.categorie = categorie;
}

public void setNom(String nom){
    if(nom != ""){
        this.nom = nom;
    }else System.out.println("Nom invalide");
}

public void setCout(float cout){
    this.cout = cout;
}

public String getNom() {
    return this.nom;
}

public float getCout() {
    return this.cout;
}

public Categorie getCategorie() {
    return categorie;
}

@Override
    public String toString(){
        return String.format("%d. %-39s%-10s%10.2f$", nom, cout);
    }
}

class budget {
    private double montant_total = 0;
    private double montant_utilisé;
    private ArrayList<depense> depenses = new ArrayList<>();

    public budget(double montant_total){

    }

    public void setMontant_total(double montant_total){
        this.montant_total = montant_total;
    }

    public void setMontant_utilisé(double montant_utilisé){
        this.montant_utilisé = montant_utilisé;
    }

    public void setDepense(ArrayList<depense> depenses){
        this.depenses = depenses;
    }

    public double getMontant_total() {
        return montant_total;
    }

    public double getMontant_utilisé() {
        return montant_utilisé;
    }

    public ArrayList<depense> getDepense() {
        return this.depenses;
    }

    
    public void ajouterDepense(depense depense){
        this.depenses.add(depense);
        this.montant_utilisé += depense.getCout();
    }
    public void modifierDepense(int i, depense depense){
        int men = this.depenses.get(i).getCout();
        this.depenses.get(i).setDepense(depense);
        this.montant_utilisé = (this.depenses.get(i).getCout() - men) + this.montant_utilisé;
    }
    public void retirerDepense(int i){
        
    }
    public depense getOneDepense(int i){
        return this.depenses.get(i);
    }
}*/

import java.util.ArrayList;
public class main {
    public static void main(String[] args) {
        Depense bouf = new Depense("banane", 1.50, Categorie.nourriture);
        System.out.println(bouf);
        Budget budget = new Budget(100);
        budget.getDepenses().add(new Depense("lol je suis un pirate", 100000, Categorie.diver));
        System.out.println(budget.getMontantUtilise());
        budget.ajouterDepense(bouf);
        System.out.println(budget.getMontantUtilise());
        
    }
}
 
enum Categorie{
    voyage,
    santé,
    habitation,
    nourriture,
    éducation,
    loisir,
    diver
}
 
class Depense{
    private String nom = "";
    private double cout;
    private Categorie categorie = Categorie.diver;
 
    public Depense(String nom, double cout, Categorie categorie){
        this.nom = nom;
        this.cout = cout;
        this.categorie = categorie;
    }
 
    public double getCout(){
        return this.cout;
    }
 
    @Override
    public String toString(){  
        return String.format("%-39s%-10s%10.2f$", this.nom, this.categorie, this.cout);
    }
 
}
class Budget{
    private double montantTotal = 0;
    private double montantUtilise= 0;
    private ArrayList<Depense> depenses = new ArrayList<>();
 
    public void setMontantTotal(double montantTotal){
        this.montantTotal = montantTotal;
    }
    public double getMontantTotal(){
        return this.montantTotal;
    }
 
    public void setMontantUtilise(double montantUtilise){
        this.montantUtilise = montantUtilise;
    }
    public double getMontantUtilise(){
        return this.montantUtilise;
    }
 
    public void setDepense(ArrayList<Depense> depenses){
        this.depenses = depenses;
    }
    public ArrayList<Depense> getDepenses(){
        return this.depenses;
    }
 
    
    public Budget(double montantTotal){
        
    }
    public void ajouterDepense(Depense depense){
        this.depenses.add(depense);
        this.montantUtilise += depense.getCout();
    }
    public void modifierDepense(int indice, Depense depense){
        double mem = this.depenses.get(indice).getCout();
        this.depenses.set(indice,depense);
        this.montantUtilise = (this.depenses.get(indice).getCout() - mem) + this.montantUtilise;
    }
    public void retirerDepense(int indice){
        double men = this.depenses.get(indice).getCout();
        this.depenses.remove(indice);
        this.montantUtilise -= men;
    }
    public Depense getOneDepense(int indice){
        return this.depenses.get(indice);
    }
}
