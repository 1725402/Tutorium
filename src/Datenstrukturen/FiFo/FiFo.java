package Datenstrukturen.FiFo;

import Datenstrukturen.EinfacheVerketteteListe.EinfacheVerketteteListe;

public class FiFo {

	private EinfacheVerketteteListe puffer = null;
	
	public FiFo () {
	}
	
	public void put (Object o) {
		if (puffer == null)
			puffer = new EinfacheVerketteteListe(o);
		else
			puffer.addFirst(o);
	}
	
	public Object get () {
		if ((puffer == null) || (puffer.getAnzKnoten() == 0))
				throw new RuntimeException ("Fehler. Objekt ungültig");
		Object o = puffer.getLast();
		puffer.removeLast();
		return o;
	}
}
