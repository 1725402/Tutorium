package testat_Uebung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Blatt_2 {

	public static void main(String[] args) {
		int [] i = {0};
		kehrwerte(i, "C:\\Users\\mariu\\Desktop\\Temp\\test.csv");
	}
	
	public static void kehrwerte (int[] daten, String datei) {
		
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
			for (int o = 0; o < ausgabe.length; o++) {
				pw.print(ausgabe[o]);
				if (o < ausgabe.length-1) {
					pw.print(";");
				}
			}
		}
		catch (ArithmeticException a) {
			System.err.println("ArithmeticException: " + a.getMessage());
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
	}

}
