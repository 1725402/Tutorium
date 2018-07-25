package aufgabe_0101_Getter_Setter;

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
		this.name = name;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getProduktKategorie() {
		return produktKategorie;
	}
	public void setProduktKategorie(String produktKategorie) {
		this.produktKategorie = produktKategorie;
	}
	
	@Override
	public String toString() {
		return "Name:\t\t\t" + this.name + "\nMaterial:\t\t" + this.material + "\nPreis:\t\t\t" + this.preis + "\nProduktkategorie:\t" + this.produktKategorie;
	}
}
