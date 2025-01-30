public class exo19{
	public static void main(String[] args){
		int[] tab = new int[10];
		for(int i = 0; i < tab.length; i++){
			tab[i] = (int) (Math.random() * 101);
		}
		
		System.out.print("tab: " );
		System.out.print("[");
		for(int i = 0; i < tab.length - 1; i++)System.out.print(tab[i] + ",");
		System.out.print(tab[tab.length-1] + "]");
		
		int[] newTab = new int[tab.length];
		int keep = 101;
		for(int j = 0; j < tab.length; j++){
			for(int i = 0; i < tab.length; i++){
				if(tab[i] < keep){
					newTab[j] = tab[i];
					keep = tab[i];
				}
			}
			keep = 101;
		}
		
		
		System.out.print('\n' +"newTab: ");
		System.out.print("[");
		for(int i = 0; i < newTab.length-1; i++)System.out.print(newTab[i] + ",");
		System.out.print(newTab[newTab.length-1] + "]");
	}
}