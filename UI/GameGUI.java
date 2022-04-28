package UI;

import java.awt.*;
import javax.swing.*;
import server.GameClient;

// GUI for the game
public class GameGUI extends JFrame {
	private GameClient client;
	
	public GameGUI() {
		setTitle("GAME");
		
		// set up layout
		CardLayout cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
	    
	    // add windows
		JPanel home = new HomePanel(client);
		container.add(home, "1");
		
		JPanel game = new GamePanel();
		container.add(game, "2");
		
		JPanel winLose = new WinLosePanel();
		container.add(winLose, "3");
		
		cardLayout.show(container, "1");
		
		// finalize setup
		this.add(container);
		this.setPreferredSize(new Dimension(461, 330));
		this.pack();
		this.setVisible(rootPaneCheckingEnabled);
		
		// start client, send all data to server
		client = new GameClient("192.168.0.16", 8300); // start client
	}
	
	public static void main(String[] args) {
		new GameGUI();
	}
}
