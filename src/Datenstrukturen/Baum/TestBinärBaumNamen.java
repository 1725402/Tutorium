package Datenstrukturen.Baum;

public class TestBinärBaumNamen {
	public static void main (String [] args) {
		testNormal();
		testUngünstig();
		testGünstig();
	}
	private static void testNormal () {
		System.err.println("----------------");
		BinärbaumNamen bn = new BinärbaumNamen("Marius");
		bn.einfügen("Marc");
		bn.einfügen("Hendrik");
		bn.einfügen("Caroline");
		bn.einfügen("Magnus");
		bn.einfügen("Jan");
		bn.einfügen("Cora");
		bn.einfügen("Tina");
		bn.einfügen("Achim");
		System.out.println("Höhe: " + bn.getHöhe());
		bn.löschen ("Achim");
		System.out.println(bn.inOrderAusgabe());
		System.out.println(bn.getKleinster());
		System.out.println(bn.getKnoten("Marius"));
		System.out.println("L: " + bn.getKnoten ("Marius").getLinks());
		System.out.println("R: " + bn.getKnoten ("Marius").getRechts());
	}
	
	private static void testUngünstig () {
		System.err.println("----------------");
		BinärbaumNamen bn = new BinärbaumNamen("A");
		bn.einfügen("Achim");
		bn.einfügen("Caro");
		bn.einfügen("Cora");
		bn.einfügen("Marius");
		bn.einfügen("Tina");
		bn.einfügen("Urs");
		bn.einfügen("Zelda");
		System.out.println("Höhe: " + bn.getHöhe());
		System.out.println(bn.inOrderAusgabe());
	}
	
	private static void testGünstig () {
		System.err.println("----------------");
		BinärbaumNamen bn = new BinärbaumNamen("A");
		bn.einfügen("Cora");
		bn.einfügen("Achim");
		bn.einfügen("Caro");
		bn.einfügen("Marius");
		bn.einfügen("Tina");
		bn.einfügen("Marriuss");
		System.out.println("Höhe: " + bn.getHöhe());
		System.out.println(bn.inOrderAusgabe());
	}
}
