package server;

import java.io.*;
import java.net.*;

import game.Player;

// Server back-end
public class GameServer {
	private static ServerSocket socket;
	private String IPString;
	private int port;
	
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
		
		// open a socket
		try {
			socket = new ServerSocket(port);
			// check IP stuff if socket successful
			getIP();
			
			do {
				// test open
				response = comm();
				
				if (response != null);
					System.out.println(response);
			} while (response.compareTo("close") != 0);
			
			// test close
			socket.close();
			System.out.println("Server closed by Jackson's Ultimate Client.");
		} catch (IOException e) {
			System.out.println("Something happened!");
			e.printStackTrace();
		}
	}
	
	private String comm() throws IOException {
		Socket incoming = socket.accept(); // get new socket from the ServerSocket
		System.out.println("New client connected!");
		
		// OUT
		OutputStream output = incoming.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		
		// sent to the client when connected
		writer.println("You have connected!");
		
		// IN
		BufferedReader input = new BufferedReader(new InputStreamReader
				(incoming.getInputStream()));
		
		return input.readLine();
	}
	
	public static void main(String[] args) throws Exception {
		GameServer SERVER = new GameServer(8300);
		SERVER.startServer();
		
		try {
			while (true) {
				// Start the game
				// Have Players connect through Thread handler
				Player P1 = new Player(socket.accept());
				
				P1.start();
			}
		} finally {
			
		}
	}
}
