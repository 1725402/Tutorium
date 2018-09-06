package a0112_SchleifenRekursiv_ZahlErraten;

public class Aufgabe {
	
	public static void main (String[] args) {
		System.out.println(zahlErratenRekursiv(1,100,49));
		System.out.println(zahlErratenSchleife(49));
	}
	
	public static int zahlErratenSchleife(int zahl) {
		boolean erraten = false;
		int oben = 100;
		int unten = 1;
		int counter = 0;
		do {
			if (zahl == (oben + unten)/2)
				break;
			else if (zahl > (oben + unten)/2)
				unten = (oben + unten)/2;
			else if (zahl < (oben + unten)/2)
				oben = (oben + unten)/2;
			counter++;
		}while (erraten == false);
		System.out.println("counter: " + counter);
		return (oben + unten)/2;
	}
	
	public static int zahlErratenRekursiv (int unten, int oben, int zahl) {
		if (zahl == (oben + unten)/2)
			return (oben + unten)/2;
		else if (zahl > (oben + unten)/2)
			return zahlErratenRekursiv((oben + unten)/2, oben, zahl);
		else
			return zahlErratenRekursiv(unten, (oben + unten)/2, zahl);
	}
}
