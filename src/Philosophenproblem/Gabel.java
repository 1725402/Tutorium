package Philosophenproblem;

public class Gabel {
	public Gabel () {
	}
	
	private boolean inUse = false;

	public synchronized boolean aufheben () {
		if (inUse) 
			return false;
		inUse = true;
		return inUse;
	}
	
	public synchronized void hinlegen() {
		inUse = false;
	}
}
