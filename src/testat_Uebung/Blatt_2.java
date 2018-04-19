package testat_Uebung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Blatt_2 {

	public static void main(String[] args) {
		int [] i = {18};
		kehrwerte(i, "test.txt");
	}
	
	public static double[] kehrwerte (int[] daten, String datei) {
		
		double [] ausgabe = new double [daten.length];
		PrintWriter pw = null;
		try{
			if (daten == null || datei == null)
			throw new NullPointerException ("Eingabe darf nicht NULL sein");
			pw = new PrintWriter (new File (datei));
			int counter = 0;
			for (int temp : daten) {
				if (temp == 0) {
					throw new ArithmeticException ("Von 0 ist kein Kehrwert möglich");
				}
				else {
					ausgabe [counter] = (1.0/temp) ;
				}
				counter ++;
			}
			for (int o = 0; 0 < ausgabe.length; o++) {
				double temp = ausgabe [o];
				pw.print(temp);
				if (o == ausgabe.length-1) {
					return ausgabe;
				}
				pw.print(";");
			}
			pw.close();
		}
		catch (ArithmeticException a) {
			System.err.println(a.getClass() + a.getMessage());
		}
		catch (NullPointerException n) {
			System.err.println(n.getClass() + n.getMessage());
		}
		catch (FileNotFoundException f) {
			System.out.println("Dateifehler");
		}
		finally {
			pw.close();
		}
		

		
		
		return ausgabe;
	}

}
