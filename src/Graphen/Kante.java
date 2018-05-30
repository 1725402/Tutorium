package Graphen;

public class Kante {
	private Knoten knoten1 = null;
	private Knoten knoten2= null;
	
	public Kante (Knoten kn1, Knoten kn2) {
		knoten1 = kn1;
		knoten2 = kn2;
		kn1.addKante(this);
		kn2.addKante(this);
	}
	
	public Knoten getAnderesEnde (Knoten kn) {
		if (knoten1 == kn)
			return knoten2;
		else
			return knoten1;
	}
}
