package Fehler;

public class MeinFehler extends Exception {
	
	private static final long serialVersionUID=1L;
	private int id;
	
	public MeinFehler (String meldung) {
		super(meldung);
		//mail an Admin schicken;
		id= 0;
	}
	public MeinFehler (String meldung, int id) {
		super(meldung);
		this.id=id;
		//wenn ID>1000 SMS an Admin
	}
	
}
