package SchlagDenRaab;

import javax.swing.JDialog;

public class SdRException extends Exception {
	public SdRException (String name){
		System.err.println(name);
	}
}
