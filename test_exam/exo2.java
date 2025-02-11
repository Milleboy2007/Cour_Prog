import java.util.Scanner;
import java.util.ArrayList;

public class exo2{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		int nbTache = 0;
		ArrayList<Boolean> isDone = new ArrayList<Boolean>();
		
		while(true){
				System.out.println("1. Ajouter une tâche");
				System.out.println("2. Marquer une tâche comme terminée");
				System.out.println("3. Afficher les tâches");
				System.out.println("4. Terminer le programme");
				System.out.println("------------------------------");
				System.out.println("Nombre de tâches : " + nbTache);
				System.out.println("------------------------------");
				
				
				System.out.print("Entrez votre choix : ");
				String answer = sc.next();
				
				if(answer.equals("1")){
					System.out.print("Entrez la tâche à ajouter : ");
					String answerFor1 = sc.next();
					list.add(answerFor1);
					System.out.println();
					System.out.println("Tâche ajouter: " + answerFor1);
					nbTache++;
					isDone.add(false);
					System.out.println("1. continuer");
					String answerFor1_2 = sc.next();
					if(answerFor1_2 == "1") break;
					
				}else if(answer.equals("2")){
					try{
					System.out.print("Entrez le numéro de la tâche à marquer comme terminée : ");
					int answerFor2 = sc.nextInt();
					isDone.set((answerFor2 - 1), true);
					System.out.println();
					System.out.println("Tâche terminée : " + list.get(answerFor2 - 1));
					}catch(Exception e){System.out.println("Erreur: Liste vide ou pas assez de tache");}
					
				}else if(answer.equals("3")){
					System.out.println("--Tâche--");
					for(int i = 0; i < list.size(); i++){
						String temp = "";
						if(isDone.get(i) == false){temp = "À faire ";}else{temp = "Fait ";}
						System.out.println((i+1) + ". " + temp +"-- "+ list.get(i));
					}
					System.out.println("1. Continuer");
					String answerFor3 = sc.next();
					if(answerFor3 == "1") break;
					
				}else if(answer.equals("4")){
					break;
				}else System.out.println("Invalide!!");
		}
	}
}