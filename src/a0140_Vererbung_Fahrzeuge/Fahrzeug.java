package a0140_Vererbung_Fahrzeuge;

abstract class Fahrzeug {
	private String fahrzeugTyp;
	private String modellName;
	private int anzSitze;
	private double gewicht;
	
	public  Fahrzeug(String fahrzeugTyp, String modellName, int anzSitze, double gewicht) {
		setFahrzeugTyp(fahrzeugTyp);
		setModellName(modellName);
		setAnzSitze(anzSitze);
		setGewicht(gewicht);
	}
	
	public abstract void fahre();
	public abstract void tanke();
	public abstract void parken();

	public String getFahrzeugTyp() {
		return fahrzeugTyp;
	}

	public void setFahrzeugTyp(String fahrzeugTyp) {
		this.fahrzeugTyp = fahrzeugTyp;
	}

	public String getModellName() {
		return modellName;
	}

	public void setModellName(String modellName) {
		this.modellName = modellName;
	}

	public int getAnzSitze() {
		return anzSitze;
	}

	public void setAnzSitze(int anzSitze) {
		this.anzSitze = anzSitze;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	
	
}
