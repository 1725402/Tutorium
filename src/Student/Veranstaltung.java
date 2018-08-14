package Student;

public class Veranstaltung {
	private String dozent;
	private int id;
	private String raum;
	private String uhrzeit;
	
	public Veranstaltung(String dozent, int id, String raum, String uhrzeit) {
		setDozent(dozent);
		setId(id);
		setRaum(raum);
		setUhrzeit(uhrzeit);
	}

	public String getDozent() {
		return dozent;
	}

	private void setDozent(String dozent) {
		this.dozent = dozent;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getRaum() {
		return raum;
	}

	private void setRaum(String raum) {
		this.raum = raum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	private void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}
	

	@Override
	public String toString() {
		StringBuilder ausgabe = new StringBuilder();
		ausgabe.append("\tName:\t" + this.getId());
		ausgabe.append("\n\tDozent:\t" + this.getDozent());
		ausgabe.append("\n\tRaum:\t" + this.getRaum());
		ausgabe.append("\n\tUhrzeit:\t" + this.getUhrzeit());
		return ausgabe.toString();
	}
}
