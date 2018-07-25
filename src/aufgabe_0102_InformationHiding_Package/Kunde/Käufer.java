package aufgabe_0102_InformationHiding_Package.Kunde;

import aufgabe_0102_InformationHiding_Package.YourPhone.Produkt;

public class Käufer {
	private Produkt[] bestellKatalog = null;
	public Käufer (Produkt[] bestellKatalog) {
		this.bestellKatalog = bestellKatalog;
	}
	
	public String  produktInfosAnfragen() {
		String ausgabe = "Name\t|\tBeschreibung:\t|\tLieferzeit:\t|\tPreis:\n";
		for (Produkt t: bestellKatalog) {
			ausgabe += t.getBezeichnung() + "\t\t" + t.getBeschreibung() + "\t" + t.getLieferZeitInTagen() + "\t\t\t" + t.getPreisUVP() + "\n";
		}
		return ausgabe;
	}
}
