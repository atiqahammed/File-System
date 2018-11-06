package Authentication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import tushar.FileWindow;

//import javafx.scene.image.Image;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FirstLogInPage {

	private JFrame frame;
	private JPasswordField passwordField;
	private int index = 1;
	private ArrayList<User> allUsers = new ArrayList<User>();
	private FileReader inputFile;
	private BufferedReader stream;
	private int totalAccount;

	public FirstLogInPage() {
		initialize();
	}

	public void runPage() {
		frame.setVisible(true);
	}

	private void initialize() {

		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "problem");
		}

		inputAllUser();

		frame = new JFrame("WELCOME TO FILE SYSTEM");
		frame.setBounds(100, 100, 724, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblFileSystem = new JLabel("FILE SYSTEM");
		lblFileSystem.setFont(new Font("Tempus Sans ITC", Font.BOLD, 36));
		lblFileSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileSystem.setForeground(Color.DARK_GRAY);
		lblFileSystem.setBounds(10, 11, 688, 85);
		frame.getContentPane().add(lblFileSystem);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblUsername.setBounds(200, 242, 297, 14);
		frame.getContentPane().add(lblUsername);

		JButton userPicture = new JButton("");

		userPicture.setBounds(292, 107, 128, 128);
		if (allUsers.size() == 1)
			userPicture.setVisible(false);
		else {
			//ImageIcon img = new ImageIcon("PICTUREs/" + allUsers.get(0).getUserName() + ".png");
			//.getClass().Image image = img.getImage();
			//image = image.getScaledInstance(64, 64, java.awt.SCALE_SMOOTH);
			//image = image.getScaledInstance(64, 64, java.awt.SCALE_SMOOTH);
			//image = image.setAccelerationPriority(priority);

		//	userPicture.setIcon((Icon) image);
			userPicture.setIcon(new ImageIcon("PICTUREs/" + allUsers.get(0).getUserName() + ".png"));
			lblUsername.setText(allUsers.get(0).getUserName());
		}
		frame.getContentPane().add(userPicture);

		JButton before = new JButton("PREVIOUS");
		before.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		before.setVisible(false);

		// before.setIcon(new ImageIcon("PICTUREs/bk.png"));
		before.setBounds(20, 171, 128, 33);
		// before.setBackground(Color.BLUE);//();
		// before.setBorder(new RoundedBorder(10));

		frame.getContentPane().add(before);

		JButton after = new JButton("NEXT");
		if (allUsers.size() <= 0)
			after.setVisible(false);
		after.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				userPicture.setIcon(new ImageIcon("PICTUREs/" + allUsers.get(index - 1).getUserName() + ".png"));
				lblUsername.setText(allUsers.get(index - 1).getUserName());
				if (index == allUsers.size())
					after.setVisible(false);
				if (index > 0)
					before.setVisible(true);
			}
		});
		after.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		after.setBounds(580, 172, 128, 33);
		frame.getContentPane().add(after);
		// after.setVisible(false);
		JButton signInButton = new JButton("SIGN IN");
		signInButton.setVisible(false);

		signInButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		signInButton.setBounds(292, 312, 128, 23);
		frame.getContentPane().add(signInButton);

		before.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index--;
				userPicture.setIcon(new ImageIcon("PICTUREs/" + allUsers.get(index - 1).getUserName() + ".png"));
				lblUsername.setText(allUsers.get(index - 1).getUserName());
				if (index == 1)
					before.setVisible(false);
				if (index < allUsers.size())
					after.setVisible(true);
			}
		});

		JLabel lblpassword = new JLabel("*PASSWORD*");
		lblpassword.setVisible(false);
		lblpassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setBounds(169, 267, 115, 33);
		frame.getContentPane().add(lblpassword);

		passwordField = new JPasswordField();
		passwordField.setVisible(false);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 21));
		passwordField.setBounds(292, 267, 128, 33);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Signup signup = new Signup(allUsers);
				signup.runPage();

			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnNewButton.setBounds(292, 358, 128, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnAccountRecovery = new JButton("RECOVER ACCOUNT");
		btnAccountRecovery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RecoverAccount account = new RecoverAccount(allUsers);
				account.runPage();
			}
		});
		btnAccountRecovery.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnAccountRecovery.setBounds(263, 399, 183, 23);

		userPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInButton.setVisible(true);
				lblpassword.setVisible(true);
				passwordField.setVisible(true);
			}
		});

		// int i = 0;

		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = passwordField.getText();
				if (pass.equals(allUsers.get(index - 1).getPassword())) {
					//JOptionPane.showMessageDialog(null, "Sign in success full, yeeeeeeeeee");
					try {
						FileWindow fileWindow = new FileWindow(allUsers.get(index-1).getUserName(), allUsers.get(index-1).getUserName(), allUsers.get(index-1).getUserName());
						frame.setVisible(false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password");
				}
			}
		});

		frame.getContentPane().add(btnAccountRecovery);

	}

	private void inputAllUser() {
		// TODO Auto-generated method stub
		try {
			File accountInformationFile = new File("AUTHENTICATION/accountInfo.txt");
			inputFile = new FileReader(accountInformationFile);
			stream = new BufferedReader(inputFile);
			totalAccount = Integer.parseInt(stream.readLine());
			// JOptionPane.showMessageDialog(null, "total "+ totalAccount);
			for (int i = 0; i < totalAccount; i++) {
				String temp1 = stream.readLine();
				String s[] = temp1.split(" ");
				allUsers.add(new User(s[0], s[1], s[2]));
			}

			stream.close();
			// JOptionPane.showMessageDialog(null, "total "+ allUsers.size()
			// +"he he");
			// stream.readLine();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "account information file not found :( ");
		}

		// if(accountInformationFile.exists())
		// JOptionPane.showConfirmDialog(null, "FileOK");
	}
}
