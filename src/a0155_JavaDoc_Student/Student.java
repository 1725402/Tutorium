package a0155_JavaDoc_Student;

public class Student {
	private int matr;
	private String vorname, nachname;
	
	public Student(int matr, String vorname, String nachname) {
		setMatr(matr);
		setVorname(vorname);
		setNachname(nachname);
	}
	/**
	 * Methode um die Matrikelnummer abzufragen
	 * @return Matrikelnummer das aktuellen Studenten
	 */
	public int getMatr() {
		return matr;
	}
	private void setMatr(int matr) {
		if (matr>1000000 && matr > 9999999)
			this.matr = matr;
		else
			System.err.println("Matrikelnummer ungültig");
	}
	/**
	 * Methode um den Vornamen eines Studenten abzufragen
	 * @return Vorname des Studenten
	 */
	public String getVorname() {
		return vorname;
	}
	private void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * Methode um den Nachnamen abzufragen
	 * @return Nachname des Studenten
	 */
	public String getNachname() {
		return nachname;
	}
	private void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	/**
	* Lässt den Studenten maulen
	* @return Beschwerde des Studenten
	*/
	public String jammern(){
		return "das ist alles viel zu viel…";
	}

	/**
	 * liefert einen eindeutigen Identifier des Studenten
	 * @return Identifizierungsnummer des Studenten (Matrikelnummer)
	 */
	@Override
	public int hashCode() {
		return getMatr();
	}
	
	/**
	 * Vergleicht einen Studenten mit einem beliebigen Objekt und vergleicht alle felder einen Studenten mit dem Objekt
	 * @return Wahrheitswert, ob die zwei Objekte identisch sind
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o.getClass().equals(this.getClass())) {
			Student s = (Student) o;
			if (s.hashCode() == this.hashCode())
				if (s.toString().equals(this.toString()))
						return true;
		}
		return false;
	}
	
	/**
	 * return Student als Zeichenkette
	 */
	@Override
	public String toString() {
		return "Matr.:\t\t" + getMatr() + "\nVorname:\t" + getVorname() + "\nNachname:\t" + getNachname();
	}
}
