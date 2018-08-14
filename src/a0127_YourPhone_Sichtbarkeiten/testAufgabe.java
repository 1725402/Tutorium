package a0127_YourPhone_Sichtbarkeiten;

import a0127_YourPhone_Sichtbarkeiten.Kunde.K‰ufer;
import a0127_YourPhone_Sichtbarkeiten.YourPhone.Produkt;

public class testAufgabe {
	public static void main (String[] args) {
		Produkt[] bestellKatalog = new Produkt[3];
		bestellKatalog[0] = new Produkt("P20", 799.99, 415, "High-End Smartphone", 4, "Elektronik", 800);
		bestellKatalog[1] = new Produkt("Smart M", 9.99, 3.15, "Medium Daten-Tarif", 5, "Vertrag", 3000);
		bestellKatalog[2] = new Produkt("YoungXL", 14.99, 6.48, "groﬂer Datentarif", 3, "Vertrag", 700);
		
		K‰ufer k‰ufer = new K‰ufer (bestellKatalog);
		System.out.println(k‰ufer.produktInfosAnfragen());
	}
}
