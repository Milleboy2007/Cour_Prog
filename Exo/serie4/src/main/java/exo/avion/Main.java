package exo.avion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    enum TypeVol{
        INTERNATIONAL,
        NATIONAL
    };
}

class Vol{
    private TypeVol typeVol;
    private String destination;
    private ArrayList<Billet> billets;

    Vol(TypeVol typeVol, String destination, ArrayList<Billet> billets){
        setBillets(billets);
        setDestination(destination);
        setTypeVol(typeVol);
    }

    public void setBillets(ArrayList<Billet> billets) {
        this.billets = billets;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setTypeVol(TypeVol typeVol) {
        this.typeVol = typeVol;
    }

    public ArrayList<Billet> getBillets() {
        return billets;
    }
    public String getDestination() {
        return destination;
    }
    public TypeVol getTypeVol() {
        return typeVol;
    }

}

class Billet{
    private int idBillet;
    private String nomPassager;
    private Double prixBillet;
    private Boolean isElectronique;

    Billet(int idBillet, String nomPassager, Double prixBillet, Boolean isElectronique){
        setIdBillet(idBillet);
        setIsElectronique(isElectronique);
        setNomPassager(nomPassager);
        setPrixBillet(prixBillet);
    }

    public void setIdBillet(int idBillet) {
        this.idBillet = idBillet;
    }
    public void setIsElectronique(Boolean isElectronique) {
        this.isElectronique = isElectronique;
    }
    public void setNomPassager(String nomPassager) {
        this.nomPassager = nomPassager;
    }
    public void setPrixBillet(Double prixBillet) {
        this.prixBillet = prixBillet;
    }

    public int getIdBillet() {
        return idBillet;
    }
    public Boolean getIsElectronique() {
        return isElectronique;
    }
    public String getNomPassager() {
        return nomPassager;
    }
    public Double getPrixBillet() {
        return prixBillet;
    }

}

class OutilsGestion{
    final float TPS = 0.06f;
    final float TVA = 0.05f;
    final float TVQ = 0.1f;

    public float calculPrixReelBillet(Billet Billet, Vol vol){
        return ;
    }
}