package aufgabe_0105_Aggregation;

public class Freizeit {
	private Mensch[] teilnehmer = new Mensch[30];
	private int anzTeilnehmer = 0;
	public Freizeit () {}
	
	public void anmelden(Mensch m) {
		for (int m1=0; m1<30; m1++) {
			if (teilnehmer[m1] == null) {
				teilnehmer[m1] = m;
				incAnz();
				System.out.println("Teilnehemr angemeldet. Frei Plätze: " + (30-m1-1));
				return;
			}
		}
		System.err.println("Teilnehmermaximum erreicht!");
	}
	
	public int getAnz() {
		return anzTeilnehmer;
	}
	
	private void incAnz() {
		anzTeilnehmer++;
	}
}
