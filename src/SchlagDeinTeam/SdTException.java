package SchlagDeinTeam;

import javax.swing.JDialog;

public class SdTException extends Exception {
	public SdTException (String name){
		System.err.println(name);
	}
}
