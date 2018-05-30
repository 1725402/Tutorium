package Datenstrukturen.FiFo;

public class TestFiFo {
	public static void main (String[] args) {
		FiFo f = new FiFo();
		f.put("Student");
		f.put("Marius");
		f.put("Berlinghof");
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		try {
			System.out.println(f.get());
		}catch (RuntimeException e) {
			System.err.println("FiFo leer");
		}
		
	}
	
}
