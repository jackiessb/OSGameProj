package UI;

import java.awt.*;
import javax.swing.*;

import server.GameClient;

// GUI for the game
public class GameGUI extends JFrame {
	private GameClient client;
	
	public GameGUI() {
		client = new GameClient("192.168.0.29", 8300);
		
		setTitle("GAME");
		this.setPreferredSize(new Dimension(600, 400));
		this.pack();
		this.setVisible(rootPaneCheckingEnabled);
	}
	
	public static void main(String[] args) {
		new GameGUI();
	}
}
