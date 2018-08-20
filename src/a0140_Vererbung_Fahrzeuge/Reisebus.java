package a0140_Vererbung_Fahrzeuge;

public class Reisebus extends Fahrzeug{

	private boolean hatToilette;
	public Reisebus(String fahrzeugTyp, String modellName, int anzSitze, double gewicht, boolean hatToilette) {
		super(fahrzeugTyp, modellName, anzSitze, gewicht);
		this.setHatToilette(hatToilette);
	}

	@Override
	public void fahre() {
		System.out.println("Brum, Brum, ...");
	}

	@Override
	public void tanke() {
		System.out.println("an der Tankstelle auftanken...");
	}

	@Override
	public void parken() {
		System.out.println("auf kostenlosem Parkplatz abstellen...");
	}

	public boolean isHatToilette() {
		return hatToilette;
	}

	public void setHatToilette(boolean hatToilette) {
		this.hatToilette = hatToilette;
	}

}
