package Datenstrukturen.EinfacheVerketteteListe;

public class Knoten {
	private Object o;
	private Knoten nächster;
	
	public Knoten (Object o, Knoten nächster) {
		this.setData(o);
		this.setNext(nächster);
	}

	public void setNext(Knoten nächster) {
		this.nächster = nächster;
	}
	
	public Knoten getNext () {
		return this.nächster;
	}

	public void setData(Object o) {
		this.o = o;
	}
	
	public Object getData() {
		return this.o;
	}
	
	@Override
	public String toString () {
		if (this.getData() == null) return null;
		return this.getData().toString();
	}
	
	
}
