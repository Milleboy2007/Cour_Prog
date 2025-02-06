import java.util.Scanner;
import java.util.ArrayList;

public class Menu{


    public static void main(String[] args) {
		
			ArrayList<String> keep = new ArrayList<String>();
			String[] food = {"Crevette", "Salade", "Frite", "Hamburger", "Gâteau"};
			float[] price = {8.99f, 5.60f, 6.40f, 10.99f, 7.99f};
			
			while(true){
				System.out.println("1. Ajouter un item");
				System.out.println("2. Retirer un item");
				System.out.println("3. Afficher le recu");
				System.out.println("4. Terminer la transaction");
				System.out.println("Total de la facture : " + 0);
				
				Scanner sc = new Scanner(System.in);
				System.out.print("Entrez votre choix : ");
				String answer = sc.next();
				
				if(answer.equals("1")){
					for(int i = 0; i < food.length; i++){
						String prixFormatter = String.format("%.02f$", price[i]);
						System.out.println((i+1) + ". " + food[i] + " ".repeat(24 - food[i].length() - prixFormatter.length()) + prixFormatter);
					}
					
					System.out.print("Entrez votre choix : ");
					answer = sc.next();
					keep.add(food[Integer.parseInt(answer) - 1]);
					
				}else if(answer.equals("2")){
					
				}else if(answer.equals("3")){
					double total = 0;
					for(int i = 0; i < keep.size(); i++){
						String prixFormatter = String.format("%.02f$", price[i]);
						
						System.out.println((i+1) + ". " + food[i] + " ".repeat(24 - food[i].length() - prixFormatter.length()) + prixFormatter);
					}
					
				}else if(answer.equals("4")){
					break;
				}else System.out.println("Invalide!!");
				
				
			}
    }

}