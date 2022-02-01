package app.core.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.core.model.User;

public class AppGui {

	private User user = new User();
	private JTextField tfEmail = new JTextField();
	private JTextField tfPass = new JTextField();
	
	public static void main(String[] args) {
		AppGui app = new AppGui();
		app.createAndShowGui();
	}
	
	private void createAndShowGui() {
		JFrame fr = new JFrame("my app");
		fr.setBounds(100, 100, 500, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(null); // absolute layout
		
		// add controls
		JLabel lbEmail = new JLabel("user email");
		lbEmail.setBounds(10, 10, 150, 25);
		fr.add(lbEmail);
		
		tfEmail.setBounds(100, 10, 150, 25);
		fr.add(tfEmail);
		
		JLabel lbPass = new JLabel("user password");
		lbPass.setBounds(10, 50, 150, 25);
		fr.add(lbPass);
		
		tfPass.setBounds(100, 50, 150, 25);
		fr.add(tfPass);
		
		// button
		JButton bt = new JButton("Enter");
		bt.setBounds(10, 100, 150, 25);
		fr.add(bt);
		
		//controller
		MyActionListener listener = new MyActionListener();
		bt.addActionListener(listener);
		
		fr.setVisible(true);
	}
	
	// define what to do for controller
	class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String email = AppGui.this.tfEmail.getText();
			String password = AppGui.this.tfPass.getText();
			AppGui.this.user.setEmail(email);
			AppGui.this.user.setPassword(password);
//			System.out.println(user);
			JOptionPane.showMessageDialog(null, user);
		}
	}
}
