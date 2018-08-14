package a0127_YourPhone_Sichtbarkeiten.YourPhone;

public class Produkt {

	private String bezeichnung, beschreibung, material;
	private double preisUVP, preisAnschaffung;
	private int lieferZeitInTagen, lagerBestand;
	
	public Produkt(String bezeichnung, double preisUVP, double preisAnschaffung, String beschreibung, int lieferZeitInTagen, String material, int lagerBestand) {
		setBezeichnung(bezeichnung);
		setPreisUVP(preisUVP);
		setPreisAnschaffung(preisAnschaffung);
		setBeschreibung(beschreibung);
		setLieferZeitInTagen(lieferZeitInTagen);
		setMaterial(material);
		setLagerBestand(lagerBestand);
	}

	public String getBezeichnung() {
		return bezeichnung;
	}
	private void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}
	private void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	String getMaterial() {
		return material;
	}
	private void setMaterial(String material) {
		this.material = material;
	}

	public double getPreisUVP() {
		return preisUVP;
	}
	private void setPreisUVP(double preisUVP) {
		this.preisUVP = preisUVP;
	}

	double getPreisAnschaffung() {
		return preisAnschaffung;
	}
	private void setPreisAnschaffung(double preisAnschaffung) {
		this.preisAnschaffung = preisAnschaffung;
	}

	public int getLieferZeitInTagen() {
		return lieferZeitInTagen;
	}
	private void setLieferZeitInTagen(int lieferZeitInTagen) {
		this.lieferZeitInTagen = lieferZeitInTagen;
	}

	int getLagerBestand() {
		return lagerBestand;
	}
	private void setLagerBestand(int lagerBestand) {
		this.lagerBestand = lagerBestand;
	}
	
	
}
