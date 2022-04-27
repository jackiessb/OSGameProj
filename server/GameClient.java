package server;

import java.io.*;
import java.net.*;
import java.util.*;

// Client-side grit details for the Player 
public class GameClient {
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter output;
	private Scanner scanner = new Scanner(System.in);
	
	public GameClient(String address, int port) {		
		// tying sockets together...
		try {
			this.socket = new Socket(address, port);
			
			// establishing connection and input/output
			socket = new Socket(address, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			socket.close();
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new GameClient("192.168.0.16", 8300);
	}
}
