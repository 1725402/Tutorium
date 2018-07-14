package SchlagDenRaab;

public class Testen {

	public static void main(String[] args) {
		persistenzSerialisiert temp = new persistenzSerialisiert();
		try {
			MiniSpiel temp1 = new EinzelSpiel ("Spiel05", "beschreibung");
			MiniSpiel temp2 = new GruppenSpiel ("Spiel02", "beschreibung");
			MiniSpiel temp3 = new EinzelSpiel ("Spiel03", "beschreibung");
			temp.speichern("Test1", temp2);
			MiniSpiel temp4 = (MiniSpiel) temp.laden("Test1");
			System.out.println(temp4.toString());
			

		} catch (SdRException e) {
			e.printStackTrace();
		}
		
		
	}

}
