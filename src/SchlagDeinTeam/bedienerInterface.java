package SchlagDeinTeam;

public interface bedienerInterface {

	public int[] getPunktestand();
	public void setErgebnisMiniSpiel (int team1, int team2);
	public void laden(String ort) throws SdTException;
	public void speichern(String ort) throws SdTException;
	public int getRunde();
	public void setNächstesSpiel() throws SdTException;
}
