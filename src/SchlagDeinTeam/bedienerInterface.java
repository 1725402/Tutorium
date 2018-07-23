package SchlagDeinTeam;

import java.util.ArrayList;

public interface bedienerInterface {

	public int[] getPunktestand();
	public void setErgebnisMiniSpiel (int team1, int team2);
	public Spiel laden(String ort) throws SdTException;
	public void speichern(String ort) throws SdTException;
	public int getRunde();
	public void setNächstesSpiel() throws SdTException;
	public void setErgebnis(int[] ergebnis);
	int anzSpiele();
	void addSpiel(MiniSpiel spiel);
	String ladenCSV(String fullName) throws SdTException;
	void speichernCSV(String fullName, ArrayList<String> tn) throws SdTException;
}
