package UI;

import javax.swing.*;
import server.GameClient;
import server.GameServer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class HomePanel extends JPanel {
	public JLabel opponentStatus;
	private JTextField guessField;
	public boolean offline = false;
	private GameClient client;
	
	public HomePanel() {
		setLayout(null);
		
		JLabel title = new JLabel("WORD GUESSING GAME");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setBounds(18, 18, 235, 18);
		add(title);
		
		opponentStatus = new JLabel("");
		opponentStatus.setHorizontalAlignment(SwingConstants.LEFT);
		opponentStatus.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		opponentStatus.setBounds(18, 35, 403, 44);
		add(opponentStatus);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(393, 253, 39, 29);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				offline = true;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		add(btnExit);
		
		guessField = new JTextField();
		guessField.setBounds(17, 76, 226, 26);
		add(guessField);
		guessField.setColumns(10);
		
		JButton btnSendWord = new JButton("SEND WORD");
		btnSendWord.setBounds(18, 114, 117, 29);
		add(btnSendWord);
		btnSendWord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client.sendGuess(guessField.getText());
			}
			
		});
	}
	
	public void notifyStatus(int a) {
		if (a == 0) {
			opponentStatus.setText("CONNECTED");
			opponentStatus.repaint();
		}
		else if (a == 1) {
			opponentStatus.setText("FOUND AN OPPONENT!");
			opponentStatus.repaint();
		} else if (a == 2) {
			opponentStatus.setText("WAITING FOR A PLAYER 2...");
			opponentStatus.repaint();
		} else if (a == 3) {
			opponentStatus.setText("WAITING FOR PLAYER 2 TO FINISH...");
			opponentStatus.repaint();
		}
		else if (a == 4) {
			opponentStatus.setText("YOU WERE CORRECT!");
			opponentStatus.repaint();
		} else if (a == 5) {
			opponentStatus.setText("YOU WERE INCORRECT!");
			opponentStatus.repaint();
		} else if (a == 6) {
			opponentStatus.setText("ENTER A WORD FOR YOUR OPPONENT!");
			opponentStatus.repaint();
		} else if (a == 7) {
			opponentStatus.setText("GUESS A WORD, THEN PRESS SEND!");
			opponentStatus.repaint();
		}
		
		opponentStatus.revalidate();
	}
	
	public boolean getIfOffline() {
		return offline;
	}
	
	public void setClient(GameClient c) {
		this.client = c;
	}
}
