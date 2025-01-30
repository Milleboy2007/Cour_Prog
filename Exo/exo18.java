public class exo18{
	public static void main (String[] args){
		int[] tab = new int[1000];
		int[] tab2 = new int[10];
		
		for(int i = 0; i < tab.length; i++){
			int random = (int) (Math.random() * 10 + 1);
			tab[i] = random;
			tab2[random-1]++;
			
			/**switch (random){
				case 1:
					tab2[0] += 1;
					break;
				case 2:
					tab2[1] += 1;
					break;
				case 3:
					tab2[2] += 1;
					break;
				case 4:
					tab2[3] += 1;
					break;
				case 5:
					tab2[4] += 1;
					break;
				case 6:
					tab2[5] += 1;
					break;
				case 7:
					tab2[6] += 1;
					break;
				case 8:
					tab2[7] += 1;
					break;
				case 9:
					tab2[8] += 1;
					break;
				case 10:
					tab2[9] += 1;
					break;
				default:
					System.out.println(random + "Non valide");
			}**/
		}
		
		/*System.out.println("1 : " + tab2[0]
		+ '\n' + "2 : " + tab2[1]
		+ '\n' + "3 : " + tab2[2]
		+ '\n' + "4 : " + tab2[3]
		+ '\n' + "5 : " + tab2[4]
		+ '\n' + "6 : " + tab2[5]
		+ '\n' + "7 : " + tab2[6]
		+ '\n' + "8 : " + tab2[7]
		+ '\n' + "9 : " + tab2[8]
		+ '\n' + "10 : " + tab2[9]);*/
		for(int i = 0; i < tab2.length; i++) System.out.println((i+1) + " : " + tab2[i]);
		
	}
}