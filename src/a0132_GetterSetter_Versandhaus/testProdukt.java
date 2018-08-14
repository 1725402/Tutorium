package a0132_GetterSetter_Versandhaus;

public class testProdukt {
	
	public static void main (String [] args) {
		Produkt p1 = new Produkt("Rasierer", "Plastik, Metall", 4.99, "Kosmetik");
		Produkt p2 = new Produkt("Chips", "Kartoffel", 0.99, "Süßwaren");
		Produkt p3 = new Produkt("Käse", "Milch", 1.49, "Lebensmittel");
		
		System.out.println(p1.getName());
		System.out.println(p1.getMaterial());
		System.out.println(p1.getPreis());
		System.out.println(p1.getProduktKategorie());
		System.out.println(p2.getName());
		System.out.println(p2.getMaterial());
		System.out.println(p2.getProduktKategorie());
		System.out.println(p2.getPreis());
		System.out.println(p3.getPreis());
		System.out.println(p3.getProduktKategorie());
		System.out.println(p3.getMaterial());
		System.out.println(p3.getName());
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}
}
