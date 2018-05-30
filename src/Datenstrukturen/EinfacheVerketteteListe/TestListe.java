package Datenstrukturen.EinfacheVerketteteListe;

public class TestListe {

	public static void alleAusgeben (EinfacheVerketteteListe x) {
		Object [] alle = x.getAll();
		if (alle != null) {
			System.out.println("-- Liste aller Knoten --");
			for (Object k: alle) System.out.println("  "+k);
			System.out.println("-- Liste Ende --");
		}else System.out.println("-- Liste: keine Knoten vorhanden! --");
	}
	
	public static void main (String [] args) {
		EinfacheVerketteteListe l = new EinfacheVerketteteListe("Marius");
		l.addLast("Berlinghof");
		alleAusgeben(l);
		l.addFirst("Student");
		alleAusgeben(l);
		l.add(3,  "999");
		alleAusgeben(l);
		l.remove(3);
		alleAusgeben(l);
		System.out.println(l.get(3));
	}
}
