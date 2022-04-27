package UI;

import javax.swing.*;

public class HomePanel extends JPanel {
	private JTextField txtEnterYourName;
	
	public HomePanel() {
		setLayout(null);
		
		JLabel title = new JLabel("WORD GUESSING GAME");
		title.setBounds(18, 18, 150, 16);
		add(title);
		
		JButton btnStart = new JButton("START!");
		btnStart.setBounds(170, 39, 117, 29);
		add(btnStart);
		
		txtEnterYourName = new JTextField();
		txtEnterYourName.setText("Enter your name.");
		txtEnterYourName.setBounds(18, 39, 150, 26);
		add(txtEnterYourName);
		txtEnterYourName.setColumns(10);
		
	}
}
