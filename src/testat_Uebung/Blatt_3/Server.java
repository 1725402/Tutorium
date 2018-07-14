package testat_Uebung.Blatt_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main (String[] args) {
		ServerSocket server = null;
		Socket s =  null;
		BufferedReader in = null;
		BufferedWriter out = null;
		int ergebnis = 0;
		
		try {
			
			System.out.println("Server starting...");
			server = new ServerSocket(1234);
			s = server.accept();
			in = new BufferedReader (new InputStreamReader (s.getInputStream()));
			String text = in.readLine();
			System.out.println("Server empfängt Zahlen...");
			String kommando = in.readLine();
			System.out.println("Server empfängt Kommando...");
			String [] zahlen = text.split(";");
			if (kommando.equals("MULT")){
				ergebnis = 1;
				for (String temp : zahlen) {
					ergebnis *= Integer.parseInt(temp);
				}
			}else {
				for (String temp: zahlen) {
					ergebnis+= Integer.parseInt(temp);
				}
			}
			
			out = new BufferedWriter (new OutputStreamWriter (s.getOutputStream()));
			System.out.println("Server sendet ergebnis...");
			out.write("" + ergebnis);
			out.newLine();
			out.flush();
			System.out.println("Server teerminated...");	
		}catch (IOException e) {
			
		}finally {
			try {
				out.close();
				s.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
