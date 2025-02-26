import java.util.ArrayList;
import java.util.Scanner;

public class Q3{
	public static void main(String[] args){
		ArrayList<Integer> tab = new ArrayList <Integer>();
		for(int i = 0; i < 100; i++){
			int rand = (int) (Math.random() * 100);
			tab.add(rand);
		}
		
		//Tableau de base
		System.out.print("[");
		for(int i = 0; i < tab.size() - 1; i++){
			System.out.print(tab.get(i) + ",");
		}
		System.out.print(tab.get(tab.size() - 1) + "]");
		System.out.println();
		
		//Tableau trié
		for(int i = 0; i < tab.size(); i++){
			int temp = tab.get(i);
			for(int j = 0; j < tab.size(); j++){
				if(temp < tab.get(j)){
					temp = tab.get(i);
					tab.set(i, tab.get(j));
					tab.set(j, temp);
					
				}
			}
		}
		
		System.out.print("[");
		for(int i = 0; i < tab.size() - 1; i++){
			System.out.print(tab.get(i) + ",");
		}
		System.out.print(tab.get(tab.size() - 1) + "]");
		System.out.println();
		
	}
}