package exo;

public class Main {
    public static void main(String[] args) {
        System.out.println(
            additionner(1.5,2.5) + " " +
            additionner(1, 2) + " " +
            additionner(1.5, 2) + " " + 
            additionner(1, 2.5)
            );
    }

    public static double additionner(double a, double b){
        return a + b + 10;
    }

    public static int additionner(int a, int b){
        return a + b + 20;
    }

    public static double additionner(double a, int b){
        return a + b + 30;
    }

    public static double additionner(int a, double b){
        return a + b + 40;
    }
}