package server;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JPanel;

// Player stuff (details about the player, etc)
public class GameClient {
	private Socket socket;
	private int ID;
	private BufferedReader input;
	private OutputStream output;
	
	public GameClient(String address, int port) {		
		// tying sockets together...
		this.ID = createID();
		
		try {
			// THIS SHOULD HAPPEN ONCE!
			this.socket = new Socket(address, port);
			output = socket.getOutputStream();
			
			DataOutputStream IDSend = new DataOutputStream(output);
			
			// send all client information
			IDSend.writeInt(ID);
			IDSend.flush();
			
			// constant comm
			while (true) {
				
			}
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
	
	public int getID() {
		return ID;
	}
	
	public GameClient getOpponentData() {
		return null;
	}
	
	public void sendOpponentData() {
		
	}
	
	public int createID() {
		// set ID
		Random r = new Random();
		int upperbound = 100000;
		int ID = r.nextInt(upperbound);
		
		return ID;
	}
}
