package SchlagDeinTeam;

import java.io.Serializable;
import java.util.ArrayList;

public class Spiel implements Serializable, bedienerInterface{
	private static Spiel spiel;
	private static int runde = 1;
	private ArrayList <MiniSpiel> spiele = new ArrayList <MiniSpiel>();
	private int[] punkteStand = {0,0};
	private MiniSpiel aktuellesSpiel;
	
	public Spiel () {}
	
	public void speichern(String ort) throws SdTException {
		persistenzSerialisiert speicher = new persistenzSerialisiert ();
		speicher.speichern(ort,  this);
	}
	
	public Spiel laden (String ort) throws SdTException {
		persistenzSerialisiert laden = new persistenzSerialisiert ();
		return (Spiel) laden.laden(ort);
	}

	@Override 
	public String ladenCSV (String fullName) throws SdTException {
		persistenzSerialisiert laden = new persistenzSerialisiert();
		return (String) laden.ladenCSV(fullName);
	}
	
	@Override
	public void speichernCSV (String fullName, ArrayList<String> tn) throws SdTException{
		persistenzSerialisiert speicher = new persistenzSerialisiert ();
		speicher.speichern(fullName,  tn);
	}
	
	@Override
	public int[] getPunktestand() {
		return punkteStand;
	}
	@Override
	public void setErgebnis (int[] ergebnis) {
		this.punkteStand=ergebnis;
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
	@Override
	public int anzSpiele () {
		return spiele.size();
	}
	@Override
	public void addSpiel(MiniSpiel spiel) {
		spiele.add(spiel);
	}
}
