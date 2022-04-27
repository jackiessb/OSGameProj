package game;

import java.awt.Component;
import java.awt.Container;
import java.io.*;
import java.net.*;
import java.util.Random;

import javax.swing.JLabel;

import server.GameClient;
import server.GameServer;

// CLIENT HANDLER for each player--each client will have their own ID
public class ClientHandler implements Runnable {
	private Socket socket;
	private GameServer server;
	private BufferedReader input;
	private int respectiveClientID;
	
	public ClientHandler(Socket socket, GameServer SERVER, int clientID) {
		this.socket = socket;
		this.server = SERVER;
		respectiveClientID = clientID;
				
		// set up comms with server
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// OUT
			OutputStream output = socket.getOutputStream();
			output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			
			// sent to the client when connected
			writer.println("Client connected to handler");
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
		// For each new player that connects...
		System.out.println("Player " + respectiveClientID + " is active!");
		
		if (GameServer.players != null) {
			
		} else {
			System.out.println("You weren't added to the active player list for some reason.");
		}
	}
}
