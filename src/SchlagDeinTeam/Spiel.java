package SchlagDeinTeam;

import java.io.Serializable;
import java.util.ArrayList;

public class Spiel implements Serializable, bedienerInterface{
	private static Spiel spiel;
	private static int runde = 1;
	private ArrayList <MiniSpiel> spiele = new ArrayList <MiniSpiel>();
	private int[] punkteStand;
	private MiniSpiel aktuellesSpiel;
	
	public void Spiel () {
		
	}
	
	public void speichern(String ort) throws SdTException {
		persistenzSerialisiert speicher = new persistenzSerialisiert ();
		speicher.speichern(ort,  this);
	}
	
	public void laden (String ort) throws SdTException {
		persistenzSerialisiert speicher = new persistenzSerialisiert ();
		spiel =(Spiel) speicher.laden(ort);
	}

	@Override
	public int[] getPunktestand() {
		return punkteStand;
	}

	@Override
	public void setErgebnisMiniSpiel(int team1, int team2) {
		aktuellesSpiel.setErgebnis(new int [] {team1,team2});
		
	}

	@Override
	public int getRunde() {
		return runde;
	}

	@Override
	public void setNächstesSpiel() throws SdTException {
		if (aktuellesSpiel.getErgebnis() == null) {
			throw new SdTException("Ergebnis noch nicht eingetragen");
		}
	}
	
}
