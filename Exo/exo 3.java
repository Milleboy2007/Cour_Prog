//--------------------------------------------------------------------
// Créer et afficher les variables avec le meilleur type possible
//--------------------------------------------------------------------
        
// Variable contenant l'âge d'une personne

// Population du cégep Marie-Victorin

// Variable comptant la population au Qc

// Variable pour calculer le revenu d'un individu

// Nombre de gouttes d'eau dans une piscine.

// Une variable qui se rappelle si le prof était bon ou pas

// Note en lettre qu'un étudiant obtient au cours
    
// Les mois de l'année sous format texte 

public class exo3{
	public static void main(String[] args){

		byte age = 20;
		short popuMv = 4000;
		int popuQc = 8000000;
		float revenu = 154452.43f;
		int goute = 960000000;
		boolean isGood = true;
		char grade = 'A';
		String mois = "Janvier";
		
		System.out.println(age + " ans");
		System.out.println(popuMv + " personne");
		System.out.println(popuQc + " d'habitants au Qc");
		System.out.println(revenu + " $/année");
		System.out.println(goute + " gouttes d'eau dans une picine");
		System.out.println(isGood);
		System.out.println(grade);
		System.out.println(mois);
	}
}