package a0140_Vererbung_Fahrzeuge;

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

	private void setAnzTriebwerke(int anzTriebwerke) {
		if (anzTriebwerke>=0)
			this.anzTriebwerke = anzTriebwerke;
		else
			System.err.println("Triebwerksanzahl zu gering");
	}
	
}
