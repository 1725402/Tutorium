package a0143_Fahrzeugvererbung;

public class Segelboot extends Fahrzeug{
	private int anzSegel;
	public Segelboot(String fahrzeugTyp, String modellName, int anzSitze, double gewicht, int anzSegel) {
		super(fahrzeugTyp, modellName, anzSitze, gewicht);
		this.setAnzSegel(anzSegel);
	}

	@Override
	public void fahre() {
		System.out.println("Ich tuckere über das Wasser...");
	}

	@Override
	public void tanke() {
		System.out.println("Im Hafen tanken...");
	}

	@Override
	public void parken() {
		System.out.println("im Hafen anlegen...");
	}

	public int getAnzSegel() {
		return anzSegel;
	}

	public void setAnzSegel(int anzSegel) {
		this.anzSegel = anzSegel;
	}

}
