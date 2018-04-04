package Fehler;

public class Test_Try_Catch {
	
	public static void main (String[] args) throws MeinFehler{
		try {
			int x = 0;		
			int y = funktion(x);
			System.out.println(x);
		}
		catch (MeinFehler e) {
			//Behandlung
			e.printStackTrace();
		}

		
	}

	private static int funktion(int x) throws MeinFehler{
		if (x<=0)
			throw new MeinFehler ("x ist ungültig");
		
		return 17;
	}

}
