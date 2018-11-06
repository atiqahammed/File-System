package tushar;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Option extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public static String selectedPath = null;
	public static boolean copyOption, cutOption, pasteOption; 
	
	public Option() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JButton Paste = new JButton("Paste");
		Paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Paste.setBackground(Color.BLACK);
		Paste.setForeground(Color.GREEN);
		Paste.setBounds(103, 102, 234, 23);
		add(Paste);
		
		JButton open = new JButton("Open");
		open.setEnabled(false);
		open.setBackground(Color.BLACK);
		open.setForeground(Color.GREEN);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		open.setBounds(103, 37, 234, 23);
		add(open);
		
		JButton copy = new JButton("Copy");
		copy.setBackground(Color.BLACK);
		copy.setForeground(Color.GREEN);
		copy.setBounds(103, 58, 234, 23);
		add(copy);
		
		JButton Cut = new JButton("Cut");
		Cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cut.setForeground(Color.GREEN);
		Cut.setBackground(Color.BLACK);
		Cut.setBounds(103, 79, 234, 23);
		add(Cut);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Delete.setForeground(Color.GREEN);
		Delete.setBackground(Color.BLACK);
		Delete.setBounds(103, 125, 234, 23);
		add(Delete);
		
		JButton Rename = new JButton("Rename");
		Rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Rename.setBackground(Color.BLACK);
		Rename.setForeground(Color.GREEN);
		Rename.setBounds(103, 146, 234, 23);
		add(Rename);
		
		JButton Properties = new JButton("Properties");
		Properties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Properties.setForeground(Color.GREEN);
		Properties.setBackground(Color.BLACK);
		Properties.setBounds(103, 167, 234, 23);
		add(Properties);

	}
}
