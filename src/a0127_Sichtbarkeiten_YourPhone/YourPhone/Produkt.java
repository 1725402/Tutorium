package a0127_Sichtbarkeiten_YourPhone.YourPhone;

public class Produkt {

	private String bezeichnung, beschreibung, material;
	private double preisUVP, preisAnschaffung;
	private int lieferZeitInTagen, lagerBestand;
	
	public Produkt(String bezeichnung, double preisUVP, double preisAnschaffung, String beschreibung, int lieferZeitInTagen, String material, int lagerBestand) {
		if(bezeichnung.length()>=5)
			setBezeichnung(bezeichnung);
		else
			System.err.println("Bezeichnung zu kurz");
		
		if (preisUVP>0)
			setPreisUVP(preisUVP);
		else
			System.err.println("UVP ungültig");
		
		if (preisAnschaffung>0)
			setPreisAnschaffung(preisAnschaffung);
		else
			System.err.println("Beschreibung zu kurz");
		
		if (beschreibung.length()>5)
			setBeschreibung(beschreibung);
		else
			System.err.println("Beschreibung zu kurz");
		
		if (lieferZeitInTagen>0)
			setLieferZeitInTagen(lieferZeitInTagen);
		else
			System.err.println("Lieferzeit ungültig");
		
		if (material.length()>5)
			setMaterial(material);
		else
			System.err.println("Material zu kurz");
		
		if (lagerBestand >= 0)
			setLagerBestand(lagerBestand);
		else
			System.err.println("Lagerbestand ungültig");
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
