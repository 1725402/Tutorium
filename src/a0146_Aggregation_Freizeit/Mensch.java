package a0146_Aggregation_Freizeit;

public class Mensch {
	private Freizeit[] freizeiten = new Freizeit[3];
	private int anzFreizeiten = 0;
	public Mensch() {}
	
	public void teilnehmen (Freizeit f){
		for (int f1=0; f1<3; f1++) {
			if (freizeiten[f1] == null) {
				freizeiten[f1] = f;
				f.teilnehmerEintragen(this);
				incAnz();
				return;
			}
		}
		System.err.println("Freizeitmaximum erreicht!");
	}
	public int getAnz() {
		return anzFreizeiten;
	}
	
	
	private void incAnz () {
		anzFreizeiten++;
	}

	public void teilnahmeMitteilen(Freizeit freizeit) {
		if (freizeit == null || anzFreizeiten>=3) {
			System.err.println("Anmeldung fehlgeschlagen");
			return;
		}
		for (int z = 0; z<3; z++)
			if (freizeiten[z]==null)
				freizeiten[z]=freizeit;
	}
}
