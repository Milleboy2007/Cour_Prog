/*ABANDON */
public class tryCatch {
    
        public static void main(String[] args) {
            try{
                System.out.println("Bonjour " + args[0] + " " + args[1]);
            }catch(ArrayIndexOutOfBoundsException e){
                try{
                    String test = args[0];
                }catch(ArrayIndexOutOfBoundsException e2){
                    System.out.println("Vous deviez mettre votre prénom et nom en argument, mais vous pouvez encore le faire ici: ");
            }
            }
        }
            
}
