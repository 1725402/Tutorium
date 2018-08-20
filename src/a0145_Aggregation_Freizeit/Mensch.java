package a0145_Aggregation_Freizeit;

public class Mensch {
	private Freizeit[] freizeiten = new Freizeit[3];
	private int anzFreizeiten = 0;
	public Mensch() {}
	
	public void teilnehmen (Freizeit f){
		for (int f1=0; f1<3; f1++) {
			if (freizeiten[f1] == null) {
				freizeiten[f1] = f;
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
}
