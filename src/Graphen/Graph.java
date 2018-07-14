package Graphen;

import java.util.ArrayList;

public class Graph {
	private ArrayList <Knoten> knotenListe = new ArrayList <Knoten>();
	
	public Graph () {
	}
	
	public void addKnoten (Knoten kn) {
		if(kn == null)
			throw new RuntimeException ("addKnoten: ungültiger Knoten");
		knotenListe.add(kn);
	}
	
	public boolean hatKnoten (Knoten kn) {
		if (kn == null)
			return false;
		for (Knoten knAusListe: knotenListe) {
			if (knAusListe == kn)
				return true;
		}
		return false;
	}
	
	public int getAnzKnoten () {
		return this.knotenListe.size();
	}
	
	public Knoten getKnoten (int id) {
		for (Knoten knAusListe: knotenListe) {
			if (knAusListe.getId() == id)
				return knAusListe;
		}
		return null;
	}
	
	public ArrayList<Knoten> getKnoten (){
		return knotenListe;
	}
	
	public int getGrad() {
		int max = 0;
		for (Knoten knAusListe: knotenListe) {
			if (knAusListe.getGrad() > max)
				max = knAusListe.getGrad();
		}
		return max;
	}
	
	public void setKnoten (ArrayList<Knoten> liste) {
		if ((liste==null) || (liste.size() < 1))
			throw new RuntimeException ("setKnoten:  ungültige Liste");
		knotenListe = liste;
	}
}
