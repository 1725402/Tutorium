package a0112_Schleifen_ZahlErraten;

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
			if (zahl == mitte(oben, unten))
				break;
			else if (zahl > mitte(oben, unten))
				unten = mitte(oben, unten);
			else if (zahl < mitte(oben, unten))
				oben = mitte(oben, unten);
			counter++;
		}while (erraten == false);
		System.out.println("counter: " + counter);
		return mitte(oben, unten);
	}
	
	public static int mitte (int unten, int oben) {
		return ((oben + unten)/2);
	}
	
	public static int zahlErratenRekursiv (int unten, int oben, int zahl) {
		if (zahl == mitte(oben, unten))
			return mitte(oben, unten);
		else if (zahl > mitte(oben, unten))
			return zahlErratenRekursiv(mitte(oben, unten), oben, zahl);
		else
			return zahlErratenRekursiv(unten, mitte(oben, unten), zahl);
	}
}
