class Personne {
    private byte age;
    private float taille;
    private String nomComplet;
 
    private double banque;
 
    public void setAge(byte age){
        if(age >= 0){
            this.age = age;
        }else System.out.println("Age impossible");
    }

    public void setTaille(float taille){
        if(taille >= 0.0f){
            this.taille = taille;
        }else System.out.println("Taille impossible");
    }

    public void setNomComplet(String nomComplet){
        if(nomComplet != ""){
            this.nomComplet = nomComplet;
        }else System.out.println("Nom invalide");
    }

    public void setBanque(double banque){
        this.banque = banque;
    }
 
    public byte getAge(){
        return this.age;
    }

    public float getTaille(){
        return this.taille;
    }

    public String getNomComplet(){
        return this.nomComplet;
    }

    public double getBanque(){
        return this.banque;
    }
 
 
 
    public Personne(byte age, float taille, String nomComplet, double banque){
        this.setAge(age);
        this.setTaille(taille);
        this.setNomComplet(nomComplet);
        this.setBanque(banque);
    }
 
    public double calculInteret(){
        return 0.02 * banque;
    }
 
}