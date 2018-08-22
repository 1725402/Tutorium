package a0145_Override_Student;

public class StudentTest {
	public static void main (String[] args) {
		Student s = new Student ("Max", "Mustermann", "Musterstraße 01, 12345 Musterort", 1234567);
		Student s1 = s.clone();
		System.err.println(s.equals(new Student ("Max", "Mustermann", "Musterstraße 01, 12345 Musterort", 1234567)));
		
		s.addVeranstaltung(new Veranstaltung("PR1C", 1, "H409", "Montag - Freitag, jeweils von 9.00 bis 17.00 Uhr"));
		System.out.println(s1.toString());
		System.out.println(s.toString());
		System.err.println(s.equals(s1));
	}
}
