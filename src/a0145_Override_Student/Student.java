package a0145_Override_Student;


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
		if (veranstaltungen.length<=6)
			this.veranstaltungen = veranstaltungen;
		else
			System.err.println("Zu viele Veranstaltungen wollen besucht werden");
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
		ausgabe.append("Nachname:\t" + this.getNachname());
		ausgabe.append("\nVorname:\t" + this.getVorname());
		ausgabe.append("\nMatrikelnr.:\t" + this.getMatr());
		ausgabe.append("\nAdresse:\t" + this.getAdresse());
		for (Veranstaltung v:  veranstaltungen) {
			if (v != null)
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
		if ( o == null)	return false;
		if (o == this)	return true;
		if (o.getClass() == this.getClass()) {
			Student s = (Student)o;
			if (s.hashCode() == this.hashCode())
				if (s.getAdresse().equals(this.adresse))
					if (s.getNachname().equals(this.getNachname()))
						if (s.getVorname().equals(this.getVorname())) {
							for (int v = 0; v < 6; v++) {
								if (this.getVeranstaltungen()[v]!=null)
									if (!this.getVeranstaltungen()[v].equals(s.getVeranstaltungen()[v]))
										return false;
							}
							return true;
						}
		}
		return false;
	}
	
	@Override
	public Student clone() {
		Student s = new Student (this.vorname,this.nachname,this.adresse,this.matr);
		for (Veranstaltung v: this.veranstaltungen)
			s.addVeranstaltung(v);
		return s;
	}
}
