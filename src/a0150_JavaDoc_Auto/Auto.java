package a0150_JavaDoc_Auto;
/**
 * Klasse, welche ein Auto darstellt
 * 
 * @author Berlinghof
 * @version 1.1
 */
public class Auto {
	private String marke, modell;
	private int sitzzahl;
	
	/**
	 * Konstruktor eines Autos
	 * @param marke Hestellermarke des Autos
	 * @param modell Modellbezeichnung des Autos
	 * @param sitzzahl Anzahl der Sitze
	 */
	public Auto(String marke, String modell, int sitzzahl) {
		setMarke(marke);
		setModell(modell);
		setSitzzahl(sitzzahl);
	}
	/**
	 * Abfrage der Herstellerbezeichnung
	 * @return Herstellerbezeichnung als Zeichenkette
	 */
	public String getMarke() {
		return marke;
	}
	private void setMarke(String marke) {
		this.marke = marke;
	}
	/**
	 * Abfrage der Modellbezeichnung
	 * @return Modellbezeichnung als Zeichenkette
	 */
	public String getModell() {
		return modell;
	}
	private void setModell(String modell) {
		this.modell = modell;
	}
	/**
	 * Abfrage der Sitzzahl
	 * @return Sitzzahl als Ganzzahl
	 */
	public int getSitzzahl() {
		return sitzzahl;
	}
	private void setSitzzahl(int sitzzahl) {
		this.sitzzahl = sitzzahl;
	}
}
