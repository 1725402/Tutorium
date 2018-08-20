package a0140_Vererbung_Fahrzeuge;

public class testFahrzeug {

	public static void main(String[] args) {
		Fahrzeug f1 = new Flugzeug("Luftfahrzeug", "Airbus A380", 509, 560000, 4);
		Fahrzeug f2 = new Reisebus("Landfahrzeug", "MAN Luxusliner", 50, 4.5, true);
		Fahrzeug f3 = new Segelboot("Wasserfahrzeug", "Quicksilver Oceanride", 4, 2.1, 3);
		
		f1.fahre();
		f2.fahre();
		f3.fahre();
		
		f1.tanke();
		f2.tanke();
		f3.tanke();
		
		f1.parken();
		f2.parken();
		f3.parken();
		
	}

}
