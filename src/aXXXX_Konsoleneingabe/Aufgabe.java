package aXXXX_Konsoleneingabe;

import java.util.Scanner;

public class Aufgabe {

	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		char kommando = kommandoEinlesen(sc);
		int zahl1 = zahlEinlesen(sc);
		int zahl2 = zahlEinlesen(sc);
		double ergebnis = 0.0;
		switch (kommando) {
		case '+':{
			ergebnis = zahl1 + zahl2;
			break;
		}
		case '*':{
			ergebnis = zahl1*zahl2;
			break;
		}
		case '-':{
			ergebnis = zahl1 - zahl2;
			break;
		}
		case '/':
			ergebnis = zahl1 / zahl2;
		}
		System.out.println("Ergebnis der Rechnung: " + ergebnis);
	}

	private static int zahlEinlesen(Scanner sc) {
		String eingabe = sc.nextLine();
		return Integer.parseInt(eingabe);
	}

	private static char kommandoEinlesen(Scanner sc) {
		String eingabe =  sc.nextLine();
		if (eingabe.length() == 1)
			return (eingabe.charAt(0));
		else
			System.out.println("Falsche eingabe");
		return '0';
	}
}