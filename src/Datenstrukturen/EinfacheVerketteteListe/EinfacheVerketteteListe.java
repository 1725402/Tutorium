package Datenstrukturen.EinfacheVerketteteListe;


import javax.management.relation.RelationTypeNotFoundException;

public class EinfacheVerketteteListe {
	private Knoten wurzel;
	
	public EinfacheVerketteteListe (Object o) {
		wurzel = new Knoten (o,null);
	}
	
	public Object getFirst () {
		if (wurzel == null) return null;
		return wurzel.getData();
	}
	
	public Object get (int pos) {
		int anz = this.getAnzKnoten();
		if ((pos<1) || (pos>anz))
			throw new RuntimeException ("Position ungültig");
		Knoten k = wurzel;
		for (int i = 1; i< pos; i++) {
			k=k.getNext();
		}
		return k.getData();
	}
	
	public int getAnzKnoten () {
		if (wurzel == null) return 0;
		Knoten k = wurzel;
		Knoten nächster;
		int anz = 0;
		do {
			nächster = k.getNext();
			k = nächster;
			anz++;
		}while (nächster != null);
		return anz;
	}
	
	public Object [] getAll() {
		int anz = this.getAnzKnoten();
		if (anz == 0) return new Object [0];
		Object [] array = new Object [anz];
		array[0] = wurzel.getData();
		Knoten k = wurzel.getNext();
		for (int i = 1; i < anz; i++) {
			array [i] = k.getData();
			if (k != null) k=k.getNext();
		}
		return array;
	}

	public void removeFirst() {
		if (wurzel != null) wurzel = wurzel.getNext();
	}

	public void removeLast () {
		if (wurzel == null) return;
		if (wurzel.getNext() == null)
			wurzel = null;
		else {
			Knoten k = wurzel;
			Knoten nächster = null;
			Knoten vorheriger = null;
			do {
				nächster = k.getNext();
				if (nächster != null) {
					vorheriger = k;
					k = nächster;
				}
			}while (nächster != null);
			vorheriger.setNext(null);
		}
	}

	public void remove (int pos) {
		int anz = this.getAnzKnoten();
		if ((pos < 1) || (pos > anz)) return;
		if (pos == 1) {
			this.removeLast(); 
			return;
		}
		if (pos == anz) {
			this.removeLast();
			return;
		}
		Knoten k = wurzel;
		Knoten nächster = null;
		Knoten vorheriger = null;
		for (int i = 1; i < pos; i++) {
			vorheriger = k;
			k = k.getNext();
		}
		nächster = k.getNext();
		vorheriger.setNext(nächster);
	}

	public void addFirst (Object o) {
		Knoten k = new Knoten (o,wurzel);
		wurzel = k;
	}
	
	public void addLast (Object o) {
		Knoten k = wurzel;
		Knoten nächster;
		do {
			nächster = k.getNext();
			if (nächster != null) k = nächster;
		}while(nächster != null);
		nächster = new Knoten (o,null);
		k.setNext(nächster);
	}
	
	public Object getLast() {
		Knoten k = wurzel;
		Knoten nächster;
		do {
			nächster = k.getNext();
			if (nächster != null) k = nächster;
		}while(nächster != null);
		return k;
	}
	
	public void add (int pos, Object o) {
		int anz = this.getAnzKnoten();
		if ((pos < 1)||(pos > anz))
			throw new RuntimeException("Position ungültig");
		if (pos == 1) {
			this.addFirst(o);
			return;
		}
		Knoten k = wurzel;
		for (int i = 1; i < pos; i++)
			k = k.getNext();
		Knoten neu = new Knoten (o,k.getNext());
		k.setNext(neu);
	}
	
}
