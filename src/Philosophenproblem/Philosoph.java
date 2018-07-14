package Philosophenproblem;

public class Philosoph extends Thread{
	private final Gabel rechts;
	private final Gabel links;
	private String name;
	
	public static void main (String[] args) {
		new Philosoph (2);
	}
	
	public Philosoph(int counter) {
		 if(counter <= 0) throw new RuntimeException("illegal value");
		    links = new Gabel();
		    Philosoph tmp = this;
		    for(int n = 1; n < counter; n++) {
		        tmp = new Philosoph(tmp);
		        tmp.name = "Philosoph " + n;
		    }
		    name = "Philosoph " + counter;
		    rechts = tmp.links;
		    start();
	}

	public Philosoph (Philosoph links) {
		 rechts = (links != null)? links.links : new Gabel();
		    this.links = new Gabel();
		    start();
	}
	
	public void run () {
		try {
			boolean essen = false, gabelLinks = false, gabelRechts = false;
			while (!essen) {
				System.out.println(name + " +überlegt...");
				Thread.sleep(1000);
				while (!gabelLinks) 
					gabelLinks = links.aufheben();
				System.out.println(name + " nimmt Linke Gabel");
				System.out.println(name + " überlegt wieder...");
				Thread.sleep(1000);
				while (!gabelRechts) {
					gabelRechts = rechts.aufheben();
					if (!gabelRechts) {
						links.hinlegen();
						gabelLinks = false;
						System.out.println(name + " hat linke Gabel hingelegt");
					}
				}
				System.out.println(name + " hat rechte Gabel");
				essen = gabelLinks && gabelRechts;
			}
			System.out.println(name + " isst...");
			Thread.sleep(10000);
			links.hinlegen();
			System.out.println(name + " hat links hingelegt (fertig)");
			rechts.hinlegen();
			System.out.println(name + " hat rechts hingelöegt (fertig)");
		}catch (InterruptedException e) {
			
		}
	}

}
