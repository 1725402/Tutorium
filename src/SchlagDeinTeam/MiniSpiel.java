package SchlagDeinTeam;

import java.io.Serializable;

import SchlagDeinTeam.SdTException;

public abstract class MiniSpiel implements Serializable {
	private static int anzSpiele = 0;
	private String name;
	private int[] ergebnis;
	
	public MiniSpiel (String name) throws SdTException {
		if (name != null && name.length() >= 3)
		 this.setName(name);
		else
			throw new SdTException ("Falsche Namenseingabe");
		incAnzahlSpiele();
	}
	private void incAnzahlSpiele() {
		anzSpiele++;
	}
	protected int getAnzahlSpiele() {
		return this.anzSpiele;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public void setErgebnis(int[] ergebnis) {
		this.ergebnis = ergebnis;
	}
	public int[] getErgebnis() {
		return ergebnis;
	}
	
}
