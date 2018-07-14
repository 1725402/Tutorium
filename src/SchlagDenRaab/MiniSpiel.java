package SchlagDenRaab;

import java.io.Serializable;

import SchlagDenRaab.SdRException;

public abstract class MiniSpiel implements Serializable {
	private static int anzSpiele = 0;
	private String name;
	
	public MiniSpiel (String name) throws SdRException {
		if (name != null && name.length() >= 3)
		 this.setName(name);
		else
			throw new SdRException ("Falsche Namenseingabe");
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
	
}
