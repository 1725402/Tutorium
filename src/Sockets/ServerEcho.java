package Sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {
	public static void main (String [] args) {
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
			System.out.println("incoming message: " + text);
			out = new BufferedWriter (new OutputStreamWriter (s.getOutputStream()));
			String text2 = "Server: " + text;
			System.out.println("Outgoing message: " + text2);
			out.write(text2);
			out.newLine();
			out.flush();
			System.out.println("Server terminated");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			}catch (Exception e) {
				try {
					server.close();
				}catch (IOException ee) {}
			}
		}
	}
}
