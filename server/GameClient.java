package server;

import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.HomePanel;

// Player stuff (details about the player, etc)
public class GameClient {
	private Socket socket;
	private int ID;
	private BufferedReader input;
	private OutputStream output;
	private DataOutputStream send;
	private PrintWriter writer;
	private JPanel container;
	
	public GameClient(String address, int port, JPanel container) {	
		setContainer(container);
		((HomePanel)container.getComponent(0)).setClient(this);
		
		// tying sockets together...
		this.ID = createID();
		
		try {
			// THIS SHOULD HAPPEN ONCE!
			this.socket = new Socket(address, port);
			
			output = socket.getOutputStream();
			send = new DataOutputStream(output);
			
			// send all client information
			send.writeInt(ID);
			send.flush();
			
			while (true) {
				// check if offline
				if (ifOffline() == true) {
					send.writeBoolean(true);
					send.flush();
					// socket.close();
				} else 
					send.writeBoolean(false);
				
				// get messages
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String response = input.readLine();
				
				if (response != null) {
					System.out.println(response);
					setNotifyLabel(response);
				}
			}
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
	
	// setters for panels (cast gives it those private data fields)
	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public JPanel getContainer() {
		return container;
	}
	
	// get Client ID
	public int getID() {
		return ID;
	}
	
	// create Client ID
	public int createID() {
		// set ID
		Random r = new Random();
		int upperbound = 100000;
		int ID = r.nextInt(upperbound);
		
		return ID;
	}
	
	public boolean ifOffline() {
		HomePanel h = (HomePanel)container.getComponent(0);
		boolean status = h.getIfOffline();
		return status;
	}
	
	public void sendGuess(String guess) {
		writer = new PrintWriter(output, true);
		writer.println(guess);
	}
	
	public void setNotifyLabel(String s) {
		if (s.compareTo("Client has successfully connected to handler") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(0);
		} else if (s.compareTo("Opponent has been found!") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			h.notifyStatus(1);
		} else if (s.compareTo("Waiting for another player...") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(2);
		} else if (s.compareTo("Waiting for Player to finish turn...") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(3);
		} else if (s.compareTo("Guess was correct!") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(4);
		} else if (s.compareTo("Guess was incorrect!") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(5);
		} else if (s.compareTo("Enter a word!") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(6);
		} else if (s.compareTo("Guess a word!") == 0) {
			HomePanel h = (HomePanel)container.getComponent(0);
			h.notifyStatus(7);
		} else if (s.compareTo("You won!") == 0) {
			
		} else if (s.compareTo("You lost!") == 0) {
			
		}
	}
}
