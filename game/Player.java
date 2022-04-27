package game;

import java.io.*;
import java.net.*;
import server.GameServer;

// CLIENT HANDLER!
public class Player extends Thread {
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	
	public Player(Socket socket) {
		this.socket = socket;
		
		// set up intractability with server
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Having trouble connecting... (Player end)");
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("Unable to close Thread");
				e.printStackTrace();
			}
		}
	}
	
}
