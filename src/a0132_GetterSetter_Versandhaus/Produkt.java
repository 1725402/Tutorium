package a0132_GetterSetter_Versandhaus;

public class Produkt {
	private String name;
	private String material;
	private double preis;
	private String produktKategorie;
	
	public Produkt(String name, String material, double preis, String produktKategorie) {
		setName(name);
		setMaterial(material);
		setPreis(preis);
		setProduktKategorie(produktKategorie);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.length()>5)
			this.name = name;
		else
			System.err.println("Name zu kurz");
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		if (material.length()>5)
			this.material = material;
		else
			System.err.println("Materialbezeichnung zu kurz");
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		if (preis >=.01)
			this.preis = preis;
		else
			System.err.println("Preis zu gering");
	}
	public String getProduktKategorie() {
		return produktKategorie;
	}
	public void setProduktKategorie(String produktKategorie) {
		if (produktKategorie.length()>5)
			this.produktKategorie = produktKategorie;
		else
			System.err.println("Produktkategorie zu kurz");
	}
	
	@Override
	public String toString() {
		return "Name:\t\t\t" + this.name + "\nMaterial:\t\t" + this.material + "\nPreis:\t\t\t" + this.preis + "\nProduktkategorie:\t" + this.produktKategorie;
	}
}
