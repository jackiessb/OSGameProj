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
	private int respectiveClientID;
	
	public ClientHandler(Socket socket, GameServer SERVER, int clientID) {
		setServer(SERVER);
		setSocket(socket);
		
		// set up comms with server
		try {
			// OUT
			OutputStream output = this.socket.getOutputStream();
			output = this.socket.getOutputStream();
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
	
	public void setSocket(Socket s) {
		socket = s;
	}
	
	public void setServer(GameServer ser) {
		server = ser;
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
