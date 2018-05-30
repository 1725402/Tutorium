package Graphen;

import java.util.ArrayList;

public class Knoten {
	private int id = 0;
	private ArrayList <Kante> kantenListe = new ArrayList <Kante>();
	
	public Knoten (int id) {
		this.id = id;
	}
	
	public int getId () {
		return this.id;
	}
	
	public int getGrad () {
		return this.kantenListe.size();
	}
	
	public void addKante (Kante ka) {
		if (ka == null)
			throw new RuntimeException ("addKante: Ungültige Kante");
		kantenListe.add(ka);
	}
	
	public ArrayList<Kante> getKanten (){
		return kantenListe;
	}

	public ArrayList<Knoten> getNachbarKnoten () {
		ArrayList<Kante> kanten = getKanten();
		if (kanten == null)
			return null;
		ArrayList<Knoten> aus = new ArrayList <Knoten>();
		for(Kante ka: kanten)
			aus.add(ka.getAnderesEnde(this));
		return aus;
	}
	
	@Override
	public String toString() {
		return ""+this.getId();
	}
}
