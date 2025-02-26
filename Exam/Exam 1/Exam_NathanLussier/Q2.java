import java.util.ArrayList;
import java.util.Scanner;

public class Q2{
	public static void main(String[] args){
		ArrayList<String> nameTab = new ArrayList <String>();
		ArrayList<Double> gradeTab = new ArrayList <Double>();
		double moyenne = 0.0;
		
		while(true){
			System.out.println("Menu : ");
			System.out.println("1. Ajouter le résultat D'un étudiant");
			System.out.println("2. Afficher la liste des résultas");
			System.out.println("3. Terminer le programme");
			System.out.println("------------------------------------");
			System.out.println("Moyenne du groupe : " + moyenne);
			System.out.println("------------------------------------");
			
			System.out.print("Entrez votre choix : ");
			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine();
			
			if(answer.equals("1")){
				System.out.print("Entrez le nom complet de l'étudiant : ");
				String name = sc.nextLine();
				nameTab.add(name);
				
				System.out.print("Entrez la note de cet étudiant : ");
				double grade = sc.nextDouble();
				gradeTab.add(grade);
				sc.nextLine();
				
				System.out.println("Résultat pour " + name + " : " + grade);
				System.out.println("1. continuer");
				System.out.println("-------------------------------------------");
				String answer2 = sc.nextLine();
				
				double temp = 0;
				for(int i = 0; i < gradeTab.size(); i++){
					
					temp += gradeTab.get(i);
					moyenne = temp / gradeTab.size();
				}
				
			}else if(answer.equals("2")){
				System.out.println("Liste : ");
				
				for(int i = 0; i < nameTab.size(); i++){
					//int nbSpace = 10 - (nameTab.get(i)).size();
					System.out.println(nameTab.get(i) + ("         ")/*.repeat(nbSpace)*/ + gradeTab.get(i));
				}
				System.out.println("1. continuer");
				System.out.println("-------------------------------------------");
				String answer2 = sc.nextLine();
			}else if(answer.equals("3")){
				System.out.println("Aurevoir!");
				break;
			}else {
				System.out.println("Invalide!!!");
			}
			
		
		}
	}
}