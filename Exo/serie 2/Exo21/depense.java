enum Categorie{
        voyage, 
        santé, 
        habitation, 
        nourriture, 
        éducation, 
        loisir, 
        diver
}

public class depense {
    private String nom = "";
    private float cout;
    private Categorie categorie = Categorie.diver;

    public depense(String nom, float cout, Categorie categorie){
        this.nom = nom;
        this.cout = cout;
        this.categorie = categorie;
    }

    /*public void setNom(String nom){
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
    }*/

    @Override
        public String toString(){
            return String.format("%d. %-40s %10.2fs", nom, cout);
        }
}
