package aufgabe_0105_Aggregation;

public class TestAggregation {
	public static void main(String []args) {
		Freizeit f1 = new Freizeit();
		for (int i = 0; i <= 30; i++) {
			Mensch m = new Mensch();
			f1.anmelden(m);
			m.teilnehmen(f1);
		}
		
	}
}
