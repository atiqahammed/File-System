package Authentication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import tasks.Copy;
import tasks.Directory;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Signup {

	private JFrame frame;
	private JTextField userName;
	private JTextField email;
	private JPasswordField passwordField;
	private JLabel label;
	private JButton btnUploadImage;
	private JButton btnSignUp;
	private JButton btnBack;
	private ArrayList<User> allUsers;
	private JLabel lblImageSize;
	private JLabel lblFileTypepng;
	private boolean testPic = true;
	private FileReader inputFile;
	private BufferedReader stream;
	private File userPic = null;
	private boolean testUN;
	private boolean testEm;
	private boolean testPASS;
	private String picName = "PICTUREs/default.png";


	public Signup(ArrayList<User> allUsers2) {
		allUsers = allUsers2;
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

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 724, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		userName = new JTextField();
		userName.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		userName.setBounds(307, 63, 391, 23);
		frame.getContentPane().add(userName);
		userName.setColumns(10);

		JLabel lblNewLabel = new JLabel("USER NAME:");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(108, 63, 167, 23);
		frame.getContentPane().add(lblNewLabel);

		email = new JTextField();
		email.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		email.setBounds(307, 131, 391, 23);
		frame.getContentPane().add(email);
		email.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(108, 130, 167, 23);
		frame.getContentPane().add(lblEmail);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		passwordField.setBounds(307, 194, 391, 23);
		frame.getContentPane().add(passwordField);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(108, 194, 167, 19);
		frame.getContentPane().add(lblPassword);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(570, 260, 128, 128);
		label.setIcon(new ImageIcon("PICTUREs/default.png"));
		frame.getContentPane().add(label);
		userPic = new File("PICTUREs/default.png");

		btnUploadImage = new JButton("UPLOAD IMAGE");
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					userPic = fc.getSelectedFile();
				}

				picName = userPic.getPath();

				BufferedImage bimg = null;
				try {
					bimg = ImageIO.read(userPic);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "IMAGE FILE COULD NOT UPLOADED");

				}
				int width = bimg.getWidth();
				int height = bimg.getHeight();

				if (!picName.endsWith(".png")) {
					JOptionPane.showMessageDialog(null, "PLEASE UPLOAD REQUIRED .png FILE");
					testPic = false;
				} else if (width >= 80 || height >= 80) {
					JOptionPane.showMessageDialog(null, "PLEASE UPLOAD REQUIRED SIZED FILE");
					testPic = false;
				}

				else {
					JOptionPane.showMessageDialog(null, "IMAGE SUCCESS FULLY UPLOADED");
					label.setIcon(new ImageIcon(picName));
				}

			}
		});
		btnUploadImage.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnUploadImage.setBounds(373, 260, 135, 23);
		frame.getContentPane().add(btnUploadImage);

		btnSignUp = new JButton("SIGN UP");

		btnSignUp.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnSignUp.setBounds(373, 332, 135, 23);
		frame.getContentPane().add(btnSignUp);

		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				FirstLogInPage firstLogInPage = new FirstLogInPage();
				firstLogInPage.runPage();

			}
		});

		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String UN = userName.getText();
				String em = email.getText();
				String pas = passwordField.getText();

				testUN = testUserName(UN);
				testEm = testEmail(em);
				testPASS = testPassword(pas);

				if (!testUN)
					JOptionPane.showMessageDialog(null, "PLEASE CHANGE USERNAME");
				if (!testEm)
					JOptionPane.showMessageDialog(null, "PLEASE CHANGE EMAIL ADDRESS");
				if (!testPASS)
					JOptionPane.showMessageDialog(null, "PLEASE CHANGE PASSWORD");

				if (testEm && testPASS && testUN && testPic) {
					Copy copy = new Copy();
					try {
						copy.copyFile(picName, "PICTUREs/" + UN + ".png");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "ERROR OCCUR");
					}
					
					allUsers.add(new User(UN, em, pas));
					Directory dr = new Directory();
					dr.createDir(UN);
					

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
					JOptionPane.showMessageDialog(null, UN + ", WELCOME");// (parentComponent,
																			// message)
					FirstLogInPage firstLogInPage = new FirstLogInPage();
					firstLogInPage.runPage();

					SendEmail sendEmail = new SendEmail();
					sendEmail.welcome(UN, em);

				}

				// else JOptionPane.showMessageDialog(null, "not ok");

			}

			private boolean testPassword(String pas) {
				if (pas.length() > 20)
					return false;
				Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
				return (pas != null) && pattern.matcher(pas).matches();
			}

			private boolean testEmail(String em) {
				for (int i = 0; i < allUsers.size(); i++)
					if (em.equals(allUsers.get(0).getEmail()))
						return false;
				String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

				Pattern pattern = Pattern.compile(EMAIL_PATTERN);

				return (em != null) && pattern.matcher(em).matches();

			}

			private boolean testUserName(String uN) {
				if (uN.length() > 20)
					return false;

				for (int i = 0; i < allUsers.size(); i++)
					if (uN.equals(allUsers.get(0).getUserName()))
						return false;
				Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
				return (uN != null) && pattern.matcher(uN).matches();

			}
		});

		lblImageSize = new JLabel("IMAGE SIZE: 64 * 64\r\n");
		lblImageSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageSize.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblImageSize.setBounds(373, 282, 135, 14);
		frame.getContentPane().add(lblImageSize);

		lblFileTypepng = new JLabel("FILE TYPE: .png");
		lblFileTypepng.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileTypepng.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblFileTypepng.setBounds(373, 294, 135, 14);
		frame.getContentPane().add(lblFileTypepng);
	}

}
