import java.util.Scanner;
import java.util.ArrayList;
public class Exo016{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> facture = new ArrayList<>();


        String[] plats = {"Crevette", "Salade", "Frite", "Hamburger", "Gâteau"};
        float[] prix = {8.99f, 5.60f, 6.40f, 10.99f, 7.99f};
        while(true){
            System.out.println("");

            System.out.println("1. Ajouter un item");
            System.out.println("2. Retirer un item");
            System.out.println("3. Afficher le reçu");
            System.out.println("4. Terminer la transaction");
            String choix = scanner.nextLine();
            System.out.println("Vous avez choisi : " + choix);
            System.out.println("Appuyer sur enter pour continuer");
            System.out.println("");
            if(choix.equals("1")){
                for(int i = 0 ; i < plats.length ; i++){
                    String prixFormatter = String.format("%.02f$", prix[i]);
                    System.out.println((i+1) + ". " + plats[i] + 
                        " ".repeat(24 - plats[i].length() - prixFormatter.length()) + prixFormatter);
                }

                System.out.print("Entrez le numéro de l'item : ");
                choix = scanner.nextLine();
                facture.add(plats[Integer.parseInt(choix) - 1]);
            }
            else if(choix.equals("2")){
                
                afficherReçu(facture, prix);

                System.out.print("Quel item voulez-vous retirer : ");
                choix = scanner.nextLine();
                facture.remove(Integer.parseInt(choix));
            }
            else if(choix.equals("3")){
                afficherReçu(facture, prix);
            }
            else if(choix.equals("4")){
                afficherReçu(facture, prix);
                System.out.println();
                System.out.println("Merci pour votre visite!");
                break;
            }
            scanner.nextLine();
      

        }
    }
    public static void afficherReçu(ArrayList<String> facture, float[] prix){
        double total = 0;
        for(int i = 0 ; i <  facture.size() ; i++){
            total += prix[i];
            String prixFormatter = String.format("%.02f$", prix[i]);

            System.out.println((i+1) + ". " + facture.get(i) + " ".repeat(24 - facture.get(i).length() - prixFormatter.length()) + prixFormatter);

        }
        System.out.println("-".repeat(27));
        String totalFormatter = String.format("%.02f$",total);
        System.out.println("Total" + " ".repeat(22 - totalFormatter.length()) + totalFormatter);
    }
}