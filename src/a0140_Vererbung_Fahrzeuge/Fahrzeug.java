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
		if (fahrzeugTyp.length()>=5)
			this.fahrzeugTyp = fahrzeugTyp;
		else
			System.err.println("Fahrzeugtyp zu kurz");
	}

	public String getModellName() {
		return modellName;
	}

	public void setModellName(String modellName) {
		if (modellName.length()>=5)
			this.modellName = modellName;
		else
			System.err.println("Modellname zu kurz");
	}

	public int getAnzSitze() {
		return anzSitze;
	}

	public void setAnzSitze(int anzSitze) {
		if (anzSitze >=1)
			this.anzSitze = anzSitze;
		else
			System.err.println("Sitzanzahl ungültig");
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		if (gewicht >=0)
			this.gewicht = gewicht;
		else
			System.err.println("Gewicht zu gering");
	}
	
	
}
