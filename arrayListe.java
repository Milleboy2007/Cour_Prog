import java.util.ArrayList;
import java.util.Scanner;

public class arrayListe{
	
	
	public static void main(String[] args){
		

		ArrayList<Integer> nb = new ArrayList<Integer>();
		
		for(int i = 1; i < 6; i++){
			nb.add(i);
		}
		
		for(int i = 0; i < nb.size(); i++){
			System.out.println(nb.get(i));
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quel nombre veux tu supprimer?: ");
		String answer = sc.next();
	
		
		for(int i = 0; i < nb.size(); i++){
			if(nb.get(i) == Integrer.parseInt.answer){
				nb.remove(i);
			}
		}
		
		
		for(int i = 0; i < nb.size(); i++){
			System.out.println(nb.get(i));
		}
	}
}