public class Test {
    public static void main(String[] args) {
            int rand =(int) (Math.random() * (17-13+1)) + 13;


            System.out.println(rand);


            //NOTE
            //System.out.printf("%d. %-24s %s", (i+1), facture.get(i), prixFormatter);
            System.out.printf("%-22s %s%s", "Total",rand,"$");
    }
}