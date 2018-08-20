package a0110_Überlauf_Ganzzahl;

import java.util.Scanner;

public class Aufgabe {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		short eins = einlesen(sc);
		short zwei = einlesen(sc);
		System.out.println("Ergebnis: "+rechnen( eins, zwei)
		+ "\nÜberlauf: " + überlauf(eins,zwei));
		
	}

	private static boolean überlauf(short eins, short zwei) {
		if ((eins + zwei) > Short.MAX_VALUE)
				return true;
		return false;
	}

	private static short einlesen(Scanner sc) {
		System.out.println("Bitte eine Ganzzahl zwischen " + Short.MIN_VALUE 
				+ " und " + Short.MAX_VALUE + " eingeben.");
		int zahl = Integer.parseInt(sc.nextLine());
		if (zahl< Short.MIN_VALUE || zahl> Short.MAX_VALUE)
			return einlesen(sc);
		else 
			return (short) zahl;
	}

	private static short rechnen(short eins, short zwei) {
		return (short) (eins + zwei);
	}
}
