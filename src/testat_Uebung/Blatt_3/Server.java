package testat_Uebung.Blatt_3;

public class Server {
	ServerSocket server = null;
	Socket s =  null;
	BufferedReader in = null;
	BufferedWriter out = null;
	try {
		System.out.println("Server starting...");
		server = new ServerSocket(1234);
		s = server.accept();
		in = new BufferedReader (new InputStreamReader (s.getInputStream()));
		String text = in.readLine();
		String kommando = in.
	}
}
