package testat_Uebung.Blatt_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
	public static void main (String[] args) {
		ArrayList<Integer> daten = new ArrayList <Integer>();
		daten.add(12);
		daten.add(10);
		String kommando = "MULT";
		starteClient (daten, kommando);
		
	}
	
	 public static void starteClient (ArrayList <Integer> daten, String kommando) {
		 BufferedWriter out = null;
		 BufferedReader in = null;
		 Socket s = null;
		 StringBuilder textBuilder = new StringBuilder();
		 if (daten != null)
			 for(int i: daten)
				 textBuilder.append(i + ";");
		 else
			 return;
		 String text = textBuilder.toString();
		 try {
			 System.out.println("Client startet...");
			 s = new Socket ("localhost",1234);
			 out = new BufferedWriter (new OutputStreamWriter (s.getOutputStream()));
			 System.out.println("Client sendet: " + text);
			 out.write(text);
			 out.newLine();
			 out.write(kommando);
			 out.newLine();
			 out.flush();
			 in = new BufferedReader (new InputStreamReader (s.getInputStream()));
			 String ergebnis = in.readLine();
			 System.out.println("Das Ergebnis lautet: " + ergebnis);
			 System.out.println("Client terminated");
		 }catch (IOException e) {
			 e.printStackTrace();
			}finally {
				try {
					out.close();
				}catch (Exception e) {}
				try {
					in.close();
				}catch (Exception e) {}
				
		 }
	 }
	
}
