public class Exo28 {
    public static void main(String[] args) {
        Personne personne = new Personne("Jean", 40, "10 rue des Lilas");
        Etudiant etudiant = new Etudiant("Marie", 22, "15 rue de la Paix", "Informatique", "E123");
        Professeur professeur = new Professeur("Mr. Dupont", 45, "12 avenue des Champs", "Mathématiques", 2500.00);

        personne.sePresenter();
        etudiant.seDecrire();
        etudiant.etudier();
        professeur.seDecrire();
        professeur.enseigner();

    }
}

class Personne {
    private String nom;
    private int age;
    private String adresse;

    public Personne(String nom, int age, String adresse) {
        this.setNom(nom);
        this.setAge(age);
        this.setAdresse(adresse);
    }



    private void setNom(String nom) {
        this.nom = nom;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void sePresenter(){
        System.out.println("Je suis " + getNom() + ", j'ai " + getAge() + " ans et mon adresse est "  + getAdresse());
    }
}

class Etudiant extends Personne {
    private String filiere;
    private String numEtudiant;

    public Etudiant(String nom, int age, String adresse, String filiere, String numEtudiant) {
        super(nom, age, adresse);
        this.setFiliere(filiere);
        this.setNumEtudiant(numEtudiant);
    }

    private void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    private void setNumEtudiant(String numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getNumEtudiant() {
        return numEtudiant;
    }

    public void seDecrire(){
        super.sePresenter();
    }
    public void etudier(){
        System.out.println("Je suis en filière " + getFiliere() + ", Numéro étudiant: " + getNumEtudiant());
    }
}

class Professeur extends Personne {
    private String matiere;
    private double salaire;

    public Professeur(String nom, int age, String adresse, String matiere, double salaire) {
        super(nom, age, adresse);
        this.setMatiere(matiere);
        this.setSalaire(salaire);
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getMatiere() {
        return matiere;
    }

    public double getSalaire() {
        return salaire;
    }

    public void seDecrire(){
        super.sePresenter();
    }
    public void enseigner(){
        System.out.println("Le professeur " + getNom() + " eneigne " + getMatiere());
    }
}