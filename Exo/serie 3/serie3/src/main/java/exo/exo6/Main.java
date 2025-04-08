package main.java.exo.exo6;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Forme> liste = new ArrayList<>();
        liste.add(new Cercle(new HashMap<Dimensions, Double>() {{ put(Dimensions.RAYON,4.5); }}));

        liste.add(new Triangle(new HashMap<Dimensions, Double>() {{ 
            put(Dimensions.BASE,4.5);
            put(Dimensions.HAUTEUR,4.5);
         }}));

         liste.add(new Rectangle(new HashMap<Dimensions, Double>() {{ 
            put(Dimensions.BASE,5.5);
            put(Dimensions.HAUTEUR,5.5);
         }}));

        for (Forme forme : liste){
            System.out.println(forme.getArea());
        }
    }
}

enum Dimensions{
    BASE,
    HAUTEUR,
    RAYON
}

class Forme{

    HashMap<Dimensions, Double> dimensions;

    public Forme(HashMap<Dimensions, Double> dimensions){
        setDimensions(dimensions);
    }

    public void setDimensions(HashMap<Dimensions, Double> dimensions) {
        this.dimensions = dimensions;
    }

    public double getArea(){
        return 0;
    }
}

class Cercle extends Forme{
    public Cercle(HashMap<Dimensions, Double> Dimensions){
        super(Dimensions);
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(dimensions.get(Dimensions.RAYON),2);
    }
}

class Triangle extends Forme{
    public Triangle(HashMap<Dimensions, Double> Dimensions){
        super(Dimensions);
    }

    @Override
    public double getArea(){
        return dimensions.get(Dimensions.BASE) * dimensions.get(Dimensions.HAUTEUR) / 2;
    }
}

class Rectangle extends Forme{
    public Rectangle(HashMap<Dimensions, Double> Dimensions){
        super(Dimensions);
    }

    @Override
    public double getArea(){
        return dimensions.get(Dimensions.BASE) * dimensions.get(Dimensions.HAUTEUR);
    }
}