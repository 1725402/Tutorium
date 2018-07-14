package SchlagDenRaab;

import java.io.Serializable;

public class GruppenSpiel extends MiniSpiel implements Serializable{
	private String beschreibung;
	private int spielNummer;
	
	private GruppenSpiel(String name) throws SdRException {
		super(name);
		this.spielNummer = super.getAnzahlSpiele();
	}
	public GruppenSpiel (String name, String beschreibung) throws SdRException {
		this(name);
		if (beschreibung != null && beschreibung.length()>3)
			this.setBeschreibung(beschreibung);
		else
			throw new SdRException("Beschreibung ungültig");
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	@Override
	public String toString () {
		return this.getName() + "\nSpielnummer: " + this.spielNummer + "\n------------\n" + this.getBeschreibung();
	}
}		
		
