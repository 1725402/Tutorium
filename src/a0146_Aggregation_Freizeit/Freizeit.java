package a0146_Aggregation_Freizeit;

public class Freizeit {
	private Mensch[] teilnehmer = new Mensch[30];
	private int anzTeilnehmer = 0;
	public Freizeit () {}
	
	public void anmelden(Mensch m) {
		for (int m1=0; m1<30; m1++) {
			if (teilnehmer[m1] == null) {
				teilnehmer[m1] = m;
				m.teilnahmeMitteilen(this);
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

	public void teilnehmerEintragen(Mensch mensch) {
		if (anzTeilnehmer>30) {
			System.err.println("Zu viele Teilnehmer");
			return;
		}
		for (int z = 0; z<30;z++)
			if (teilnehmer[z]==null)
				teilnehmer[z] = mensch;
	}
}
