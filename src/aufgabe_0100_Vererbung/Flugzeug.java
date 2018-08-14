package aufgabe_0100_Vererbung;

public class Flugzeug extends Fahrzeug{

	private int anzTriebwerke;
	public Flugzeug(String fahrzeugTyp, String modellName, int anzSitze, double gewicht, int anzTriebwerke) {
		super(fahrzeugTyp, modellName, anzSitze, gewicht);
		this.setAnzTriebwerke(anzTriebwerke);
	}

	@Override
	public void fahre() {
		System.out.println("abheben...");
	}

	@Override
	public void tanke() {
		System.out.println("Kerosin auffüllen...");		
	}

	@Override
	public void parken() {
		System.out.println("auf freiem Platz auf dem Rollfeld abstellen...");		
	}

	public int getAnzTriebwerke() {
		return anzTriebwerke;
	}

	public void setAnzTriebwerke(int anzTriebwerke2) {
		this.anzTriebwerke = anzTriebwerke2;
	}
	
}
