public class exo1 {
	public static void main(String[] args){
		int rand = (int)(Math.random() * 100);
		
		if(rand > 26){
			for(int i = 0; i < (rand%26); i++){
				System.out.print((char) (65+i) + " ");
			}
		}
		System.out.println();
		System.out.println("rand:"+rand);
		System.out.println("modulo:"+(rand%26));
		
	}
}