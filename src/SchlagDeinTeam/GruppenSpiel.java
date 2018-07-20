package SchlagDeinTeam;

import java.io.Serializable;

public class GruppenSpiel extends MiniSpiel implements Serializable{
	private String beschreibung;
	private int spielNummer;
	
	private GruppenSpiel(String name) throws SdTException {
		super(name);
		this.spielNummer = super.getAnzahlSpiele();
	}
	public GruppenSpiel (String name, String beschreibung) throws SdTException {
		this(name);
		if (beschreibung != null && beschreibung.length()>3)
			this.setBeschreibung(beschreibung);
		else
			throw new SdTException("Beschreibung ung�ltig");
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
		