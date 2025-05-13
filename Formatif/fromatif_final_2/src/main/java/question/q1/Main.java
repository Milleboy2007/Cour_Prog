package question.q1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Cuisine cuisine = new Cuisine();

        cuisine.ajouterCommande("Préparer la salade", "Laver et couper les légumes.", (byte) 3, null);
        cuisine.ajouterCommande("Cuire le steak", "Cuisson du steak à point.", (byte) 4, null);
        cuisine.ajouterCommande("Préparer la sauce", "Mélanger les ingrédients.", (byte) 2, null);
        cuisine.ajouterCommande("Toaster le pain", "Toaster le pain pour le burger.", (byte) 1, null);

        // Commande avec prérequis
        cuisine.ajouterCommande("Assembler le burger", "Assembler tous les éléments.", (byte) 5, 1); // steak requis

        // Commandes avec délai
        cuisine.ajouterCommande("Servir la soupe", "Doit être servie chaude.", (byte) 3, null, LocalDateTime.now().plusSeconds(10));
        cuisine.ajouterCommande("Servir les frites", "Chaudes et croustillantes.", (byte) 2, null, LocalDateTime.now().plusSeconds(5));
        
        // Commande expirée
        cuisine.ajouterCommande("Livrer la commande #123", "Client pressé.", (byte) 1, null, LocalDateTime.now().minusSeconds(5));

        cuisine.mettreAJourEtatPriorite();

        System.out.println(cuisine);


        System.out.println("################################################################");


        cuisine.marquerCommeFait(0);
        cuisine.marquerCommeFait(4);

        System.out.println(cuisine);

    }
}

enum EtatCommande {
    EXPIREE,
    EN_COURS,
    SERVIE
}

class Commande {
    private int id;
    private String nom;
    private String description;
    private byte priorite;
    private Commande preRequis;
    private EtatCommande etat;

    Commande(int id, String nom, String description, byte priorite, Commande preRequis, EtatCommande etat){
        setDescription(description);
        setEtat(etat);
        setId(id);
        setNom(nom);
        setPreRequis(preRequis);
        setPriorite(priorite);
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPreRequis(Commande preRequis) {
        this.preRequis = preRequis;
    }
    public void setPriorite(byte priorite) {
        this.priorite = priorite;
    }

    public String getDescription() {
        return description;
    }
    public EtatCommande getEtat() {
        return etat;
    }
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public Commande getPreRequis() {
        return preRequis;
    }
    public byte getPriorite() {
        return priorite;
    }

    void mettreAJourEtatPriorite(){
    }

    void marquerServie(){ 
        if(preRequis == null || preRequis.getEtat() == EtatCommande.SERVIE){
            this.setEtat(EtatCommande.SERVIE);
        }else System.out.println("Impossible de servir #"+ getId() +" : dépendance non terminée → " + preRequis.getNom());
    }

    @Override
    public String toString() {
        /*return "#" + getId() + getNom() + getDescription() + "Priorité: " + getPriorite();*/
        return String.format("""
                #%-6d%-30sPriorité: %d
                \t\t%s
                """, this.id, this.nom,this.priorite,this.description);
    }
}

class CommandeAvecLimite extends Commande{
    private LocalDateTime limite;

    CommandeAvecLimite(int id, String nom, String description, byte priorite, Commande preRequis, EtatCommande etat, LocalDateTime limite){
        super(id, nom, description, priorite, preRequis, etat);
        setLimite(limite);
    }

    public void setLimite(LocalDateTime limite) {
        this.limite = limite;
    }
    public LocalDateTime getLimite() {
        return limite;
    }

    @Override
    void mettreAJourEtatPriorite(){
        if(LocalDateTime.now().isAfter(this.limite)){
            this.setEtat(EtatCommande.EXPIREE);
        }else{
            Duration d = Duration.between(LocalDateTime.now(), limite);
            if(d.toMinutes() < getPriorite()){
                setPriorite((byte) Math.max(1, d.toMinutes()));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("""
                #%-6d%-30sPriorité: %d
                \t\t%s
                A servire avant: %s
                """, this.getId(), this.getNom(),this.getPriorite(),this.getDescription(),this.limite.toString());
    }
}

class Cuisine{
    private ArrayList<Commande> commandes = new ArrayList<>();
    private int prochainId = 0;
    private boolean doitTrier = true;

    void ajouterCommande(String nom, String desc, byte priorite, Integer indexPreRequis){
        commandes.add(new Commande(prochainId, nom, desc, priorite, /*commandes.get(indexPreRequis)*/null, EtatCommande.EN_COURS));
        prochainId++;
    }
    void ajouterCommande(String nom, String desc, byte priorite, Integer indexPreRequis, LocalDateTime limite){
        commandes.add(new CommandeAvecLimite(prochainId, nom, desc, priorite, /*commandes.get(indexPreRequis)*/null, EtatCommande.EN_COURS, limite));
        prochainId++;
    }

    void mettreAJourEtatPriorite(){
        for (Commande commande : commandes){
            commande.mettreAJourEtatPriorite();
        }
    }

    void marquerCommeFait(int id){
        commandes.get(id).marquerServie();
    }

    private int comparer(Commande a, Commande b){
        if(transform(a.getEtat()) > transform(b.getEtat())){

        }

        return 0;
    }

    private int transform(EtatCommande etat){
        switch (etat) {
            case EXPIREE:
                return 1;
            case EN_COURS:
                return 2;
            case SERVIE:
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        Collections.sort(commandes, (Commande a, Commande b) -> comparer(a,b));
        for(int i = 0; i < commandes.size()-1; i++) {
            return commandes.get(i).toString();
        }
        return commandes.get(commandes.size()).toString();
    }

}