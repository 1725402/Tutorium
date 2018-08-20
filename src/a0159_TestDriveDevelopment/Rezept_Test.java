package a0159_TestDriveDevelopment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Rezept_Test {

	@Test
	void test1() {
		RezeptSammlung sammlung = new RezeptSammlung();
		assertEquals("kein Rezept hinzugefügt", sammlung.rezeptAusgeben(0));
	}
	
	@Test
	void test2() {
		RezeptSammlung sammlung = new RezeptSammlung();
		sammlung.addRezept(new Rezept ("Rührei", "Ei", 5, "\n\t1. Eier Schlagen\n\t2. in Pfanne kochen"));
		assertEquals("Rezept: Rührei\nDauer: 5min\nZutaten: Ei\nAnweisung: \n\t1. Eier Schlagen\n\t2. in Pfanne kochen"	,sammlung.rezeptAusgeben(1));
		assertEquals("kein Rezept mit dieser ID vorhanden",sammlung.rezeptAusgeben(2));
	}
}