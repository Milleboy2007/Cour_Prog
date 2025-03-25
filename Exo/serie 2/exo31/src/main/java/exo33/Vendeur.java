package exo33;

public class Vendeur{
    private String nom;
    private double salaireDeBase;
    private double tauxCommission;
    private double ventes;

    public void setNom(String nom){
        this.nom = nom;
    }
    public void setSalaireDeBase(double salaireDeBase){
        if(salaireDeBase >= 0) 
        {
            this.salaireDeBase = salaireDeBase;
        }else System.out.println(salaireDeBase + " invalide il doit être superieur ou égale a 0");
    }
    public void setTauxCommission(double tauxCommission){
        if(tauxCommission >= 0){
            this.tauxCommission = tauxCommission;
        }else System.out.println(tauxCommission + " invalide il doit être superieur ou égale a 0");
    }
    public void setVentes(double ventes){
        this.ventes = ventes;
    }


    public String getNom() {
        return nom;
    }
    public double getSalaireDeBase() {
        return salaireDeBase;
    }
    public double getTauxCommission() {
        return tauxCommission;
    }
    public double getVentes() {
        return ventes;
    }

    public Vendeur(String nom, double salaireDeBase, double tauxCommission, double ventes){
        setNom(nom);
        setSalaireDeBase(salaireDeBase);
        setTauxCommission(tauxCommission);
        setVentes(ventes);
    }   

    @Override
    public String toString() {
        System.out.println("Nom: " + this.nom + 
        '\n' + "Salaire de base: " + this.salaireDeBase + 
        '\n' + "Taux de commission: " + this.tauxCommission + 
        '\n' + "Ventes: " + this.ventes + 
        '\n' + "Commission: " + this.ventes * this.tauxCommission);
        return super.toString();
    }
}

//NON FINI