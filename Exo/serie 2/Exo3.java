public class Exo3 {
    public static void main(String[] args) {
        CompteBancaire un = new CompteBancaire("Sacha", 0);
        un.deposer(100);
        un.retirer(100);
        un.afficherInfo();
    }
}

class CompteBancaire{
    String titulaire;
    double solde;

    public CompteBancaire(String titulaire,double solde){
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public void deposer (double n){
        this.solde += n;
    }

    public void retirer (double n){
        if(solde >= n){
            this.solde -= n;
        }else{
           System.out.println("Pas assez d'argent"); 
        }
    }

    public void afficherSolde(){
        System.out.println(this.solde);
    }

    public void afficherInfo(){
        System.out.println(this.titulaire + " : " + this.solde);
    }
}
