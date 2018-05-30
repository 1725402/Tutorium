package Datenstrukturen.LiFo;

import Datenstrukturen.EinfacheVerketteteListe.EinfacheVerketteteListe;

public class LiFo {
	private EinfacheVerketteteListe puffer = null;
	
	public LiFo () {
	}
	
	public void push (Object o) {
		if (puffer == null)
			puffer = new EinfacheVerketteteListe(o);
		else
			puffer.addFirst(o);
	}
	
	public Object pop () {
		Object o = this.peek();
		puffer.removeFirst();
		return o;
	}

	private Object peek() {
		if (puffer == null) return null;
		return puffer.getFirst();
	}
}
