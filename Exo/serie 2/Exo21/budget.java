public class budget {
    private float montant_total;
    private float montant_utilisé;
    private String[] depense;

    public void setMontant_total(float montant_total){
        this.montant_total = montant_total;
    }

    public void setMontant_utilisé(float montant_utilisé){
        this.montant_utilisé = montant_utilisé;
    }

    public float getMontant_total() {
        return montant_total;
    }

    public float getMontant_utilisé() {
        return montant_utilisé;
    }

    public String[] getDepense() {
        return depense;
    }
}
