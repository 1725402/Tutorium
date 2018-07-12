package Fehler;

public class Test_finally {

	public static void main(String[] args) {
		int x = funktion (0);
		System.out.println(x);
	}

	private static int funktion(int a) {
		try {
			if (a == 0)
				throw new RuntimeException ("Bla");
			return 11;
		}
		catch (RuntimeException e) {
			System.out.println("LALA");
			return 4;
		}
		finally {
			return 8;
		}
	}

}

