package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import game.ClientHandler;

// Server back-end
public class GameServer {
	private static ServerSocket socket;
	private String IPString;
	private int port;
	// this list of players is public so that all clients know who is out there!
	public static ArrayList<ClientHandler> players = new ArrayList<>(); 
	
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
		
		// OUT
		OutputStream output = incoming.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		
		// sent to the client when connected
		writer.println("You have connected!");
	}
	
	public boolean disconnected() throws IOException {
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		GameServer SERVER = new GameServer(8300);
		SERVER.startServer();
		
		try {
			while (true) {
				// Start the game
				// Have Players connect through Thread handler
				ClientHandler player = new ClientHandler(socket.accept(), SERVER);
				
				players.add(player);
				
				// Start player events
				player.run();
			}
		} finally {
			socket.close();
		}
	}
}
