package server;

import java.io.*;
import java.net.*;

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
		// open a socket
		try {
			socket = new ServerSocket(port);
			// check IP stuff if socket successful
			getIP();
		} catch (IOException e) {
			System.out.println("Something happened!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// start the server on port x
		GameServer test = new GameServer(8300);
		// test.startServer();	
	}
}
