package Student;

public class Student extends Object implements Cloneable{
	private String vorname, nachname, adresse;
	private int matr;
	private Veranstaltung[] veranstaltungen = new Veranstaltung[6];
	public Student (String vorname, String nachname, String adresse, int matr) {
		setVorname(vorname);
		setNachname(nachname);
		setAdresse(adresse);
		setMatr(matr);
	}
	public Student (String vorname, String nachname, String adressen, int matr, Veranstaltung[] veranstaltungen) {
		this(vorname, nachname, adressen,matr);
		setVeranstaltungen (veranstaltungen);
	}
	
	
	public String getVorname() {
		return vorname;
	}
	private void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	private void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAdresse() {
		return adresse;
	}
	private void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getMatr() {
		return matr;
	}
	private void setMatr(int matr) {
		this.matr = matr;
	}
	
	private void setVeranstaltungen(Veranstaltung[] veranstaltungen) {
		this.veranstaltungen = veranstaltungen;
	}
	public Veranstaltung[] getVeranstaltungen () {
		return veranstaltungen;
	}
	
	public void addVeranstaltung(Veranstaltung v) throws RuntimeException{
		for (int i = 0; i<6; i++) {
			if (veranstaltungen[i] == null) {
				veranstaltungen[i] = v;
				return;
			}
		}
		System.err.println("Bereits 6 Veranstaltungen belegt");
		throw new RuntimeException ("Alle Veanstaltungen belegt");
	}
	
	@Override
	public String toString() {
		StringBuilder ausgabe = new StringBuilder();
		ausgabe.append("Name:\t" + this.getNachname());
		ausgabe.append("\nVorname:\t" + this.getVorname());
		ausgabe.append("\nMatr.:\t" + this.getMatr());
		ausgabe.append("\nAdresse:\t" + this.getAdresse());
		for (Veranstaltung v:  veranstaltungen) {
			ausgabe.append("\n" + v.toString());
		}
		return ausgabe.toString();
	}
	
	@Override
	public int hashCode() {
		return this.matr;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ausgabe = false;
		if ( o == null)	return false;
		if (o == this)	return true;
		if (o.getClass() == this.getClass()) {
			Student s = (Student)o;
			if (s.hashCode() == this.hashCode())
				if (s.getAdresse().equals(this.adresse))
					if (s.getNachname().equals(this.getNachname()))
						if (s.getVorname().equals(this.getVorname()))
							ausgabe= true;
		}
		return ausgabe;
	}
	
	@Override
	public Student clone() {
		Student s = new Student (this.vorname,this.nachname,this.adresse,this.matr);
		for (Veranstaltung v: this.veranstaltungen)
			s.addVeranstaltung(v);
		return s;
	}
}