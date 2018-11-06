package tushar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Properties extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Properties(String Name,String extrantion,String author,String time,String size) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(69, 41, 114, 14);
		contentPane.add(lblName);
		
		JLabel lblNamecon = new JLabel(extrantion);
		lblNamecon.setBounds(193, 41, 105, 14);
		contentPane.add(lblNamecon);
		
		JLabel lblExtention = new JLabel("extention");
		lblExtention.setBounds(69, 78, 114, 14);
		contentPane.add(lblExtention);
		
		JLabel lblExtrationsize = new JLabel(extrantion);
		lblExtrationsize.setBounds(193, 78, 105, 14);
		contentPane.add(lblExtrationsize);
		
		JLabel lblCreateBy = new JLabel("Create By");
		lblCreateBy.setBounds(69, 118, 114, 14);
		contentPane.add(lblCreateBy);
		
		JLabel lblAuthor = new JLabel(author);
		lblAuthor.setBounds(193, 118, 105, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblCreaeTime = new JLabel("Create Time");
		lblCreaeTime.setBounds(69, 154, 116, 14);
		contentPane.add(lblCreaeTime);
		
		JLabel lblTime = new JLabel(time);
		lblTime.setBounds(195, 154, 116, 14);
		contentPane.add(lblTime);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(69, 192, 114, 14);
		contentPane.add(lblSize);
		
		JLabel lblSizetype = new JLabel(size);
		lblSizetype.setBounds(193, 192, 120, 14);
		contentPane.add(lblSizetype);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(335, 37, 89, 23);
		contentPane.add(btnBack);
		setVisible(true);
	}
}
