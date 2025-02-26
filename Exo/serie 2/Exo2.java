public class Exo2{
    public static void main(String[] args) {
        Examen exam1 = new Examen("Max", (byte)78);
        exam1.afficheResultat();
    }
}


class Examen {

    String nomEtudiant;
    byte note;

    public Examen(String nomEtudiant, byte note){
        this.nomEtudiant = nomEtudiant;
        this.note = note;
    }

    public void afficheResultat(){
        System.out.println(this.nomEtudiant + " : " + this.convertNote());
    }

    public char convertNote(){
        
        if(note > 90){
            return 'A';
        }else if(note > 80){
            return 'B';
        }else if(note > 70){
            return 'C';
        }else if(note > 60){
            return 'D';
        }else{
            return 'E';
        }
    
    }
}
