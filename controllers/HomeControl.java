package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import server.GameClient;
import server.GameServer;

public class HomeControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	
	public HomeControl(JPanel container, GameClient client) {
		this.client = client;
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "EXIT") {
			try {
				// close this client, tell the server there was a disconnect, and exit the GUI.
				client.socket.close();  
				
				System.exit(0);
			} catch (IOException e1) {
				System.out.println("Could not close thread!");
				e1.printStackTrace();
			}
		} else if (e.getActionCommand() == "START!") {
			// IF we:
			// 1. have an established opponent (at least two clients connected to server) and
			// 1a. both continually connected and able to send data
			// THEN:
			// 2. get their client information (match two Threads together)
			// 2a. switch view to game view
			
		}
	}
}
