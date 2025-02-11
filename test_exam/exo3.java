public class exo3 {
	public static void main(String[] args){
			int[] tab = new int[10];
		for(int i = 0; i < tab.length; i++){
			tab[i] = (int) (Math.random() * 101);
		}
		
		System.out.print("tab: " );
		System.out.print("[");
		for(int i = 0; i < tab.length - 1; i++)System.out.print(tab[i] + ",");
		System.out.print(tab[tab.length-1] + "]");
		
		for (int i = 0; i < tab.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = tab[i];
            tab[i] = tab[minIndex];
            tab[minIndex] = temp;
        }
		
		
		System.out.print('\n' +"newTab: ");
		System.out.print("[");
		for(int i = 0; i < tab.length-1; i++)System.out.print(tab[i] + ",");
		System.out.print(tab[tab.length-1] + "]");
		
	}
}