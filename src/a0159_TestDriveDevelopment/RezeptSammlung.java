package a0159_TestDriveDevelopment;

import java.util.ArrayList;

public class RezeptSammlung {
	ArrayList <Rezept> rezepte;
	public RezeptSammlung() {
		
	}
	
	public void addRezept(Rezept rezept) {
		if (rezepte == null)
			rezepte = new ArrayList<Rezept>();
		rezepte.add(rezept);
	}
	
	public String rezeptAusgeben(int i) {
		if (rezepte == null)
			return "kein Rezept hinzugefügt";
		else if (rezepte.size() < i)
			return "kein Rezept mit dieser ID vorhanden";
		else return rezepte.get(i-1).toString();
	}
}
