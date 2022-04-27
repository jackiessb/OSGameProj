package server;

import java.io.*;
import java.net.*;

import game.Player;

// Server back-end
public class GameServer {
	private static ServerSocket socket;
	private String IPString;
	private int port;
	public int players = 0;
	
	GameServer(int p) {
		port = p;
	}
	
	public void getIP() {
		// get IP and other details
		try {
			IPString = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			System.out.println("No host found!");
			e.printStackTrace();
		}
		
		String PortString = Integer.toString(port);
		
		System.out.println("Server is on " + IPString);
		System.out.println("\nServer is on " + PortString);
	}
	
	private void startServer() {
		String response = "";
		boolean noDisconnect = true;
		
		// open a socket
		try {
			socket = new ServerSocket(port);
			// check IP stuff if socket successful
			getIP();
			
			do {
				// constantly look for new connections
				connected();
				
				// disconnect checker
				noDisconnect = disconnected();
			} while (noDisconnect);
			
		} catch (IOException e) {
			System.out.println("Something happened!");
			e.printStackTrace();
		}
	}
	
	public void connected() throws IOException {
		Socket incoming = socket.accept(); // get new socket from the ServerSocket
		System.out.println("New client connected!");
		players++; // add new player to count
		
		// OUT
		OutputStream output = incoming.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		
		// sent to the client when connected
		writer.println("You have connected!");
	}
	
	public boolean disconnected() throws IOException {
		if (players == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws Exception {
		GameServer SERVER = new GameServer(8300);
		// SERVER.startServer();
		
		try {
			while (true) {
				// Start the game
				// Have Players connect through Thread handler
				// Player P1 = new Player(socket.accept(), SERVER);
				
				// P1.start();
			}
		} finally {
			socket.close();
		}
	}
}
