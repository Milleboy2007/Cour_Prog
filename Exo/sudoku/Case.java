
public class Case {

    Coordonne coord;
    int value = 0;
    Boolean[] valeurPossibles = new Boolean[]{true,true,true,true,true,true,true,true,true,};

    public Case(Coordonne coord){
        this.coord = coord;
    }

    public Boolean setValue(int val){
        if(val != 0){
            this.value = val;
            this.valeurPossibles = new Boolean[]{false,false,false,false,false,false,false,false,false,};
            return true;
        }
        return false;
    }

    public Boolean isLastPossible(int val){
       for (int i = 0; i < valeurPossibles.length; i++) {
            if(this.valeurPossibles[i] && i != val - 1){
                return false;
            }
        }
        
        if(this.valeurPossibles[val - 1]){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String msg = "("+ this.coord.x + "," + this.coord.y + " " + this.value +")";
        for (int i = 0; i < 9; i++) {
            msg += (i+1) + ":" + String.valueOf(this.valeurPossibles[i]) + " ";
        }
        return msg;
    }




    public static void main(String[] args) {
        // Créer une case à la position (2,3)
        Case case1 = new Case(new Coordonne(2, 3));
        
        // Afficher les informations de la case
        System.out.println(case1);
    
        // Retirer une valeur possible
        case1.valeurPossibles[3] = false;
    
        // Afficher les informations de la case
        System.out.println(case1);
    
        // Affecter une valeur à la case
        case1.setValue(5);
    
        // Afficher les informations de la case
        System.out.println(case1);
    
        // Vérifier si une valeur est la dernière possibilité
        if(case1.isLastPossible(7)){
            System.out.println("Erreur isLastPossible-1");
        }
        case1.valeurPossibles = new Boolean[]{false,false,true,false,false,false,false,false,false};
        if(!case1.isLastPossible(3) || case1.isLastPossible(1)){
            System.out.println("Erreur isLastPossible-2");
    
        }
    }
}

class Coordonne{
    int x;
    int y;

    public Coordonne(int x, int y){
        this.x = x;
        this.y = y;
    }
}