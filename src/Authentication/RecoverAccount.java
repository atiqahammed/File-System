package Authentication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class RecoverAccount {

	private JFrame frame;
	private JTextField email;
	private JButton btnSendVarificationCode;
	private JTextField varificationCode;
	private JButton btnConfirmCode;
	private JLabel lblNewUsername;
	private JPasswordField passwordField;
	private JButton btnBack;
	private JLabel lblNewPassword;
	private JButton btnConfirm;
	private int varificaCode;
	private ArrayList<User> allUsers;
	private int index;

	public void runPage() {
		frame.setVisible(true);
	}

	public RecoverAccount(ArrayList<User> allUsers2) {
		allUsers = allUsers2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "problem");
		}

		frame = new JFrame("RECOVER ACCOUNT");
		frame.getContentPane().setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		frame.setBounds(100, 100, 724, 474);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		email = new JTextField();
		email.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		email.setBounds(167, 52, 389, 27);
		frame.getContentPane().add(email);
		email.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(98, 52, 54, 27);
		frame.getContentPane().add(lblEmail);

		btnSendVarificationCode = new JButton("SEND VARIFICATION CODE");

		btnSendVarificationCode.setHorizontalAlignment(SwingConstants.TRAILING);
		btnSendVarificationCode.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnSendVarificationCode.setBounds(363, 100, 193, 23);
		frame.getContentPane().add(btnSendVarificationCode);

		varificationCode = new JTextField();
		varificationCode.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		varificationCode.setBounds(167, 145, 389, 27);
		varificationCode.setVisible(false);///////////////////////////////////////////////////////////////////////
		frame.getContentPane().add(varificationCode);
		varificationCode.setColumns(10);

		btnConfirmCode = new JButton("CONFIRM CODE");

		btnConfirmCode.setHorizontalAlignment(SwingConstants.TRAILING);
		btnConfirmCode.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnConfirmCode.setBounds(429, 194, 127, 23);
		btnConfirmCode.setVisible(false);/////////////////////////////////////////////////////////////////////////
		frame.getContentPane().add(btnConfirmCode);

		lblNewUsername = new JLabel("NEW USERNAME");
		lblNewUsername.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUsername.setVisible(false);//////////////////////////////////////////////////////////////////////////
		lblNewUsername.setBounds(10, 246, 546, 27);
		frame.getContentPane().add(lblNewUsername);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		passwordField.setBounds(167, 295, 389, 27);
		passwordField.setVisible(false);//////////////////////////////////////////////////////////////////////
		frame.getContentPane().add(passwordField);

		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				FirstLogInPage firstLogInPage = new FirstLogInPage();
				firstLogInPage.runPage();

			}
		});
		btnBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);

		lblNewPassword = new JLabel("NEW PASSWORD");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewPassword.setBounds(10, 295, 142, 27);
		lblNewPassword.setVisible(false);////////////////////////////////////////////////////////////////////////
		frame.getContentPane().add(lblNewPassword);

		btnConfirm = new JButton("CONFIRM");

		btnConfirm.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnConfirm.setBounds(429, 333, 127, 23);
		btnConfirm.setVisible(false);
		frame.getContentPane().add(btnConfirm);

		btnSendVarificationCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String em = email.getText();
				boolean testEm = testMail(em);

				if (!testEm)
					JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR CURRECT EMAIL");
				else {
					varificationCode.setVisible(true);
					btnConfirmCode.setVisible(true);

					Random rand = new Random();
					varificaCode = rand.nextInt(10000) + 1;

					btnSendVarificationCode.setVisible(false);
					email.setVisible(false);
					lblEmail.setVisible(false);

					SendEmail sendEmail = new SendEmail();
					for (int i = 0; i < allUsers.size(); i++) {
						index = i;
						if (allUsers.get(i).getEmail().equals(em)) {
							sendEmail.recoverMessage(allUsers.get(i).getUserName(), allUsers.get(i).getEmail(),
									varificaCode);
							break;
						}
					}

				}
			}

			private boolean testMail(String em) {
				for (int i = 0; i < allUsers.size(); i++)
					if (em.equals(allUsers.get(i).getEmail()))
						return true;
				return false;
			}
		});

		btnConfirmCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int enteredCode = Integer.parseInt(varificationCode.getText());
				if (enteredCode == varificaCode) {
					btnConfirmCode.setVisible(false);
					varificationCode.setVisible(false);

					lblNewUsername.setText("USERNAME:   " + allUsers.get(index).getUserName());
					lblNewUsername.setVisible(true);
					lblNewPassword.setVisible(true);
					//// newUserName.setVisible(true);
					passwordField.setVisible(true);
					btnConfirm.setVisible(true);

				} else
					JOptionPane.showMessageDialog(null, "WRONG CONFIRMATION CODE");
				// String s;
				// for()
				// String nUN = newUserName.getText();
				// boolean test1 = testName(nUN);
				// if(!test1) JOptionPane.showMessageDialog(null, "PLEASE ENTER
				// OTHER USERNAME");

				// }
				// else JOptionPane.showMessageDialog(null, "WRONG VARIFICATOIN
				// CODE");

			}

			private boolean testName(String uN) {
				if (uN.length() > 20)
					return false;

				for (int i = 0; i < allUsers.size(); i++)
					if (uN.equals(allUsers.get(0).getUserName()))
						return false;
				Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
				return (uN != null) && pattern.matcher(uN).matches();
			}
		});

		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String pass = passwordField.getText();
				boolean test1 = testPassword(pass);
				if (!test1)
					JOptionPane.showMessageDialog(null, "PLEASE TRY OTHER PASSWORD");
				else {
					allUsers.get(index).setPassword(pass);

					PrintWriter writer = null;
					try {
						writer = new PrintWriter("AUTHENTICATION/accountInfo.txt", "UTF-8");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// writer.println("The first line");
					// writer.println("The second line");
					writer.println(allUsers.size());
					for (int i = 0; i < allUsers.size(); i++)
						writer.println(allUsers.get(i).getUserName() + " " + allUsers.get(i).getEmail() + " "
								+ allUsers.get(i).getPassword());

					writer.close();

					frame.setVisible(false);

					FirstLogInPage firstLogInPage = new FirstLogInPage();
					firstLogInPage.runPage();
					JOptionPane.showMessageDialog(null,
							"Congratulation, your password has been changed successfully. :)");
				}

			}
		});

	}

	private boolean testPassword(String pas) {
		if (pas.length() > 20)
			return false;
		Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
		return (pas != null) && pattern.matcher(pas).matches();
	}
}
