package game;

import java.io.*;
import java.net.*;
import java.util.Random;

import server.GameServer;

// CLIENT HANDLER for each player--each client will have their own ID
public class ClientHandler implements Runnable {
	private Socket socket;
	private GameServer server;
	private BufferedReader input;
	private PrintWriter output;
	
	public ClientHandler(Socket socket, GameServer SERVER) {
		this.socket = socket;
		this.server = SERVER;
				
		// set up comms with server
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Having trouble connecting... (ClientHandler end)");
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
	
	@Override // override Thread 
	public void run() {
		System.out.println("Player is active!");
		
		// start looking for an opponent, tell the GUI that we are actively searching
	}
}
