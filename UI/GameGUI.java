package UI;

import java.awt.*;
import javax.swing.*;

import controllers.HomeControl;
import server.GameClient;

// GUI for the game
public class GameGUI extends JFrame {
	private GameClient client;
	
	public GameGUI() {
		client = new GameClient("192.168.0.16", 8300); // start client
		setTitle("GAME");
		
		// set up layout
		CardLayout cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
		
	    // build controllers for event handling
	    HomeControl hc = new HomeControl(container, client);
	    
	    // add windows
		JPanel home = new HomePanel(client, hc);
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
	}
	
	public static void main(String[] args) {
		new GameGUI();
	}
}
