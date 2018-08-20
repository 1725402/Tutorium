package a0123_SchleifenRekursiv_Binomialkoeffizient;

import java.util.Scanner;

public class Aufgabe {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte n eingeben:");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("Bitte k eingeben:");
		int k = Integer.parseInt(sc.nextLine());
		sc.close();
 
		if (n < 0 || k < 0 || k > n)
			System.err.println("Üngültige Werte eingegeben"); 
			//Alternativ ArithmetikException("...") werfen
		else {
			System.out.println("n über k: " + binomko (n, k));
		}        
	}
	
	
	static double binomko(int n, int k) {
		if (k == 0) {
			return 1; }
		else
			return ((double)n/k) * binomko(n-1, k-1); 
	}
 
}
