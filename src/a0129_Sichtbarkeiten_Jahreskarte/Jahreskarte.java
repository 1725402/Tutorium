package a0129_Sichtbarkeiten_Jahreskarte;

import java.sql.Date;

public class Jahreskarte {
	private String name;
	private String adresse;
	private Date geburtsdatum;
	private double preis;
	private String zahlungsInformation;
	
	public Jahreskarte(String name, String adresse, Date geburtsdatum, double preis, String zahlungsInformationen) {
		setName(name);
		setAdresse(adresse);
		setGeburtsdatum(geburtsdatum);
		setPreis(preis);
		setZahlungsInformation(zahlungsInformationen);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	private void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	private void setPreis(double preis) {
		this.preis = preis;
	}

	private void setZahlungsInformation(String zahlungsInformation) {
		this.zahlungsInformation = zahlungsInformation;
	}
}
