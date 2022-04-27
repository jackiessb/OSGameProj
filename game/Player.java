package game;

import java.io.*;
import java.net.*;
import java.util.Random;

import server.GameServer;

// CLIENT HANDLER!
public class Player extends Thread {
	private Socket socket;
	private GameServer server;
	private BufferedReader input;
	private PrintWriter output;
	private int ID; 
	private Player opponent; // other player
	
	public Player(Socket socket, GameServer SERVER) {
		this.socket = socket;
		this.server = SERVER;
		
		// set ID
		Random r = new Random();
		int upperbound = 100000;
		int ID = r.nextInt(upperbound);
		
		// set up interactability with server
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
	
	@Override // override Thread 
	public void run() {
		System.out.println("Player is active!");
		
		// start looking for an opponent, tell the GUI that we are
		
	}
}
