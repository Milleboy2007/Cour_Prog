import java.util.ArrayList;
import java.util.Scanner;

public class Q1{
	public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
		System.out.print("Combien voulez vous de nombre? : ");
		int n = sc.nextInt();
		
		int[] tab = new int[n];
		for(int i = 0; i < tab.length; i++){
			tab[i] =(int) (Math.random() * 100);
		}
		
		System.out.print("[");
		for(int i = 0; i < tab.length - 1; i++){
			System.out.print(tab[i] + ",");
		}
		System.out.print(tab[tab.length - 1] + "]");
	}
}