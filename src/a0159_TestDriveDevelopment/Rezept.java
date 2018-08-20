package a0159_TestDriveDevelopment;

public class Rezept {
	String titel, zutaten, anweisung;
	int dauerInMinuten;
	public Rezept (String titel, String zutaten, int dauerInMinuten, String anweiseung) {
		setTitel(titel);
		setZutaten(zutaten);
		setDauerInMinuten(dauerInMinuten);
		setAnweisung(anweiseung);
	}
	
	public String getTitel() {
		return titel;
	}
	public String getZutaten() {
		return zutaten;
	}
	public String getAnweisung() {
		return anweisung;
	}
	public int getDauerInMinuten() {
		return dauerInMinuten;
	}
	private void setTitel(String titel) {
		this.titel = titel;
	}
	private void setZutaten(String zutaten) {
		this.zutaten = zutaten;
	}
	private void setAnweisung(String anweisung) {
		this.anweisung = anweisung;
	}
	private void setDauerInMinuten(int dauerInMinuten) {
		this.dauerInMinuten = dauerInMinuten;
	}

	@Override
	public String toString() {
		return "Rezept: " + titel + "\nDauer: "	+ dauerInMinuten + "min"+ "\nZutaten: " + zutaten + "\nAnweisung: " + anweisung ;
	}
}
