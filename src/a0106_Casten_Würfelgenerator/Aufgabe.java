package a0106_Casten_Würfelgenerator;

public class Aufgabe {
	public static void main (String[] args) {
		System.out.println(würfeln(2));
		System.out.println(würfeln(1));
	}

	private static String würfeln(int i) { //mit falscher Eingabe überprüfen (-1 & 3)
		if (i<1 || i > 2) {
			System.err.println("Eingabe ungültig. nur 1 oder zwei Würfel möglich!");
			return null;
		}
		String würfel = null;
		switch (i) {
		case 1:{
			würfel = "Der Wurf des Würfels hat folgendes ergeben: " + (int) (Math.random()*6+1); //gewollt abgeschnitten, daher nur zahlen von 1-6 möglich
			break;
		}
		case 2:{
			würfel = "Der Wurf des ersten Würfels hat die Zahl " + (int) (Math.random()*6+1) + " ergeben.";
			würfel += "\nDer Wurf des zweiten Würfels hat die Zahl " + (int) (Math.random()*6+1) + " ergeben.";
		}
		}
		return würfel;
	}
}
