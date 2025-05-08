package question.un;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
    // -------- Compte ÉPARGNE --------
    System.out.println("=== TEST COMPTE ÉPARGNE ===");
    CompteEpargne compteEpargne = new CompteEpargne("CE001", 0.03f);

    compteEpargne.deposer(1000, LocalDateTime.of(2025, 1, 15, 10, 0));  // 1
    compteEpargne.deposer(500, LocalDateTime.of(2025, 2, 10, 9, 0));    // 2
    compteEpargne.deposer(300, LocalDateTime.of(2025, 3, 5, 16, 30));   // 3 + frais
    compteEpargne.retirer(200, LocalDateTime.of(2025, 4, 1, 11, 0));    // 4 + frais
    compteEpargne.retirer(100, LocalDateTime.of(2025, 5, 20, 15, 0));   // 5 + frais
    compteEpargne.retirer(50, LocalDateTime.of(2025, 6, 15, 17, 45));   // 6 + frais
    compteEpargne.retirer(5000, LocalDateTime.of(2025, 7, 1, 12, 0));   // Échec attendu
    compteEpargne.deposer(5000, LocalDateTime.of(2025, 12, 1, 10, 0));    // 7 + frais

    System.out.println("\n--- Historique Compte Épargne ---");
    compteEpargne.afficheHistoriqueDesTransactions();

    System.out.println("\n--- Fin d'année - Compte Épargne ---");
    compteEpargne.terminerAnnee();

    System.out.printf("\nSolde final Compte Épargne : %.2f$\n", compteEpargne.getEncaisse());

    // -------- Compte NORMAL --------
    System.out.println("\n=== TEST COMPTE NORMAL ===");
    Compte compteNormal = new Compte("CN001");

    compteNormal.deposer(800, LocalDateTime.of(2025, 1, 5, 9, 0));      // 1
    compteNormal.deposer(400, LocalDateTime.of(2025, 1, 20, 11, 0));    // 2
    compteNormal.retirer(100, LocalDateTime.of(2025, 2, 15, 14, 0));    // 3
    compteNormal.retirer(200, LocalDateTime.of(2025, 3, 10, 16, 30));   // 4
    compteNormal.retirer(150, LocalDateTime.of(2025, 4, 25, 10, 0));    // 5
    compteNormal.retirer(100, LocalDateTime.of(2025, 6, 1, 13, 0));     // 6 + frais
    compteNormal.deposer(5000, LocalDateTime.of(2025, 12, 10, 10, 0));    // 7 + frais

    System.out.println("\n--- Historique Compte Normal ---");
    compteNormal.afficheHistoriqueDesTransactions();

    System.out.println("\n--- Fin d'année - Compte Normal ---");
    compteNormal.terminerAnnee();  // Pas d’intérêts

    System.out.printf("\nSolde final Compte Normal : %.2f$\n", compteNormal.getEncaisse());
    }
}

class Transaction{
    private String idTransaction;
    private LocalDateTime dateTransaction;
    private double montant;
    private double soldeCourant;

    Transaction(String idTransaction, LocalDateTime dateTransaction, double montant, double soldeCourant){
        setDateTransaction(dateTransaction);
        setIdTransaction(idTransaction);
        setMontant(montant);
        setSoldeCourant(soldeCourant);
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public void setSoldeCourant(double soldeCourant) {
        this.soldeCourant = soldeCourant;
    }

    public String getIdTransaction() {
        return idTransaction;
    }
    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }
    public double getMontant() {
        return montant;
    }
    public double getSoldeCourant() {
        return soldeCourant;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

class Compte{
    private String idCompte;
    private double encaisse;
    private ArrayList<Transaction> transactions;
    private int compteurTransaction;
    private int nbTransactionGratuite;
    private final float COUT_TRANSACTION = 5f;

    Compte(String idCompte){
        setIdCompte(idCompte);
        nbTransactionGratuite = 5;
        transactions = new ArrayList<>();
    }

    public void setIdCompte(String idCompte) {
        this.idCompte = idCompte;
    }
    public void setEncaisse(double encaisse) {
        this.encaisse = encaisse;
    }
    public void setNbTransactionGratuite(int nbTransactionGratuite) {
        this.nbTransactionGratuite = nbTransactionGratuite;
    }

    public String getIdCompte() {
        return idCompte;
    }
    public double getEncaisse() {
        return encaisse;
    }

    void deposer(double montant, LocalDateTime date){
        if(montant > 0){
            setEncaisse(getEncaisse() + montant);
            this.compteurTransaction++;
            transactions.add(new Transaction(idCompte, date, montant, encaisse));

            if(compteurTransaction > nbTransactionGratuite){
                transactions.add(new Transaction(idCompte, date, COUT_TRANSACTION, encaisse));
                setEncaisse(getEncaisse() - COUT_TRANSACTION);
            }
        }else System.out.println("Montant Invalide!!!");
    }

    void retirer(double montant, LocalDateTime date){
        if(encaisse > montant){
            setEncaisse(getEncaisse() - montant);
            this.compteurTransaction++;
            transactions.add(new Transaction(idCompte, date, montant, encaisse));

            if(compteurTransaction > nbTransactionGratuite){
                transactions.add(new Transaction(idCompte, date, COUT_TRANSACTION, encaisse));
                setEncaisse(getEncaisse() - COUT_TRANSACTION);
            }
        }else System.out.println("Fonds Insuffisants!!!");
    }

    void afficheHistoriqueDesTransactions(){

    }

    void terminerAnnee(){

    }
}

class CompteEpargne extends Compte{
    private float tauxInteret;
    

    CompteEpargne(String idCompte, float tauxInteret){
        super(idCompte);
        this.tauxInteret = tauxInteret;
        setNbTransactionGratuite(2);
    }

    void terminerAnnee(){

    }

    public float calculInteretTransaction(Transaction transaction){
        LocalDateTime finAnnee = LocalDateTime.of(LocalDate.of(transaction.getDateTransaction().getYear(),12,31),LocalTime.of(23, 59));
        int nbJour = finAnnee.getDayOfYear() - transaction.getDateTransaction().getDayOfYear();
    
        int nbJourTotal = finAnnee.getDayOfYear();
    
        return (float) (transaction.getMontant() * this.tauxInteret * nbJour / nbJourTotal);
    }
}