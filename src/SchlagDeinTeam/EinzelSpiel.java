package SchlagDeinTeam;

import java.io.Serializable;

public class EinzelSpiel extends MiniSpiel implements Serializable{
	
	private int spielNummer;
	private String beschreibung;
	
	private EinzelSpiel(String name) throws SdTException {
		super(name);
	}
	public EinzelSpiel (String name, String beschreibung) throws SdTException {
		super(name);
		if (beschreibung != null && beschreibung.length()>3)
			this.setBeschreibung(beschreibung);
		else
			throw new SdTException("Beschreibung ungültig");
		this.spielNummer = this.getAnzahlSpiele();
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
