package server;

import java.io.*;
import java.net.*;

// Client-side gritty details for the Player 
public class GameClient {
	private Socket socket;
	
	public GameClient(String address, int port) {
		// tying socket together...
		try {
			this.socket = new Socket(address, port);
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
}
