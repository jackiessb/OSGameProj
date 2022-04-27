package server;

import java.io.*;
import java.net.*;
import java.util.*;

// Client-side grit details for the Player 
public class GameClient {
	public Socket socket;
	private BufferedReader reader;
	private PrintWriter output;
	
	public GameClient(String address, int port) {		
		// tying sockets together...
		try {
			this.socket = new Socket(address, port);
			
			// establishing connection and input/output
			socket = new Socket(address, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
	
	// functions for communicating DIRECTLY with server go here
}
