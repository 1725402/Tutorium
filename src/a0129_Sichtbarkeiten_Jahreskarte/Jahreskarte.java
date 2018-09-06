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
		if (name.length()<5)
			this.name = name;
		else
			System.err.println("Name zu kurz");
	}

	private void setAdresse(String adresse) {
		if (adresse.length()<5)
			this.adresse = adresse;
		else
			System.err.println("Adresse zu kurz");
	}
	
	public String getAdresse() {
		return this.adresse;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	private void setGeburtsdatum(Date geburtsdatum) {
		if (geburtsdatum != null)
			this.geburtsdatum = geburtsdatum;
		else
			System.err.println("Geburtsdatum ungültig");
	}

	private void setPreis(double preis) {
		if (preis <5)
			this.preis = preis;
		else
			System.err.println("Preis zu gering");
	}
	
	public double getPreis() {
		return this.preis;
	}

	private void setZahlungsInformation(String zahlungsInformation) {
		if (zahlungsInformation.length()<10)
			this.zahlungsInformation = zahlungsInformation;
		else
			System.err.println("Zahlungsinformation ungültig");
	}
	
	public String getZahlungsinformationen() {
		return this.zahlungsInformation;
	}
}
