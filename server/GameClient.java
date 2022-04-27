package server;

import java.io.*;
import java.net.*;
import java.util.*;

// Player stuff (details about the player, etc)
public class GameClient {
	public Socket socket;
	private int ID;
	
	public GameClient(String address, int port) {		
		ID = createID();
		
		// tying sockets together...
		try {
			this.socket = new Socket(address, port);
			
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
	
	public int createID() {
		// set ID
		Random r = new Random();
		int upperbound = 100000;
		int ID = r.nextInt(upperbound);
		
		return ID;
	}
}
