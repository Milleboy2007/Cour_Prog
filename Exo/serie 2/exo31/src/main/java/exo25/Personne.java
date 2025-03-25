package exo25;
import java.time.LocalDate;
import java.util.Date;;

public class Personne {
    protected String nom = "Inconnu";
    protected int age = -1;
    protected String ville = "Non renseignée";
    protected String dateNaissance = "0000-00-00";

    public void setNom(String nom){ this.nom = nom;}
    public void setAge(int age){
        if(age > 0 && age < 125){
            this.age = age;
        }else System.out.println("Age non valide elle doit être entre 0 et 125");
    }
    public void setVille(String ville){this.ville = ville;}
    public void setDateNaissance(String dateNaissance){
        LocalDate currentDate = LocalDate.now();
        String[] dateNaissanceSplit = dateNaissance.split("-");

        if(dateNaissanceSplit[0].length() == 4 && dateNaissanceSplit[1].length() == 2 && dateNaissanceSplit[2].length() == 2){
            try{
                int[] dateInt = {Integer.parseInt(dateNaissanceSplit[0])};

                if(currentDate.getYear() <= dateInt[0]){
                    if(currentDate.getMonthValue() <= dateInt[1]){
                        if(currentDate.getDayOfMonth() <= dateInt[2]){
                            this.setDateNaissance(dateNaissance);
                        }else System.out.println("Invalide date futur entrer");
                    }else System.out.println("Invalide date futur entrer");
                }else System.out.println("Invalide date futur entrer");
            }catch(Exception e){
                
            }
            

        }else System.out.println("Format invalide écriver YYYY-MM-DD");
    }

    public String getNom() {
        return nom;
    }
    public int getAge() {
        return age;
    }
    public String getVille() {
        return ville;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }

    public Personne(String nom, String ville,String dateNaissance){
        setNom(nom);
        setVille(ville);
        setDateNaissance(dateNaissance);
    }
}
