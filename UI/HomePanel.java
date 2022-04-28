package UI;

import javax.swing.*;
import server.GameClient;
import server.GameServer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class HomePanel extends JPanel {
	private GameClient client;
	
	public HomePanel(GameClient client) {
		// make client information and Control information available.
		this.client = client;
		
		setLayout(null);
		
		JLabel title = new JLabel("WORD GUESSING GAME");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setBounds(18, 18, 235, 18);
		add(title);
		
		JLabel connTitle = new JLabel("Connection Status:");
		connTitle.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		connTitle.setBounds(313, 18, 119, 16);
		add(connTitle);
		
		JLabel opponentStatus = new JLabel("");
		opponentStatus.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		opponentStatus.setBounds(313, 37, 61, 16);
		add(opponentStatus);
		
		JButton btnStart = new JButton("START!");
		btnStart.setBounds(18, 48, 152, 29);
		add(btnStart);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(393, 253, 39, 29);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		add(btnExit);
	}
}
