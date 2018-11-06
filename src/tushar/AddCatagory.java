package tushar;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class AddCatagory extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField textField;
	static Stack<String> back = new Stack<>(),forword = new Stack<>();
	static String current = "" ;
	/**
	 * @wbp.nonvisual location=102,-31
	 */
	private final JScrollBar scrollBar = new JScrollBar();
	private static JTextArea fileDetailsTextArea = new JTextArea("C:\\Users\\KowserTusher\\workspace\\FileSystem\\AllUser\\Atiq\\f1\\f2");
	private static JPanel p = new JPanel();
	
	
	public AddCatagory(String path,String treePath) throws FileNotFoundException {
		
		 try 
		    { 
		        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		    } 
		    catch(Exception e){ 
		    }
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setResizable(false);
		setBounds(380, 100, 938,741);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		JPanel panel = new JPanel();
		panel.setToolTipText("Search");
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-34, -55, 1284, 767);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(309, 218, 656, 550);
		//panel.add(scrollPane);
		
		JButton FilePath = new JButton("Tusher ");
		//scrollPane.setColumnHeaderView(FilePath);
		
		JLabel filePath1 = new JLabel("New label");
		//scrollPane.setViewportView(filePath1);
		//scrollPane.add(FilePath);
		
		//JScrollBar scrollBar_2 = new JScrollBar();
		//scrollPane.setColumnHeaderView(scrollBar_2);
		
		//JScrollPane scrollPane_1 = new JScrollPane();
		//scrollPane_1.setBounds(38, 218, 273, 550);
		JList list =  new Explorer().getGui(treePath);
		
		JScrollPane scrollPane_1 = new JScrollPane(list);
		
		
		FileTreeFrame tm = new FileTreeFrame(path);
		JTree tree = tm.fileTree;
		tree.setEditable(true);
		JScrollPane scrollPane = new JScrollPane( tree);
		scrollPane.setBounds(38, 218,280, 550);
		String treep ="";
		//p = new Explorer().Explore("C:\\Users\\KowserTusher\\workspace\\FileSystem\\AllUser\\Atiq\\f1\\f2");
		JList<String>availableList = new JList<String>();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
		      public void valueChanged(TreeSelectionEvent event) {
		        File file = (File) tree.getLastSelectedPathComponent();
		        String treePath = file.getPath().toString();
		         
		     
		       
		        availableList.add(FilePath);
		        FilePath.setText(treePath);
		        fileDetailsTextArea.setText(treePath);
		        //scrollPane_1.repaint();
		       // scrollPane_1.add(FilePath);
		        p.repaint();
		      //  p = new Explorer().Explore(treePath);
		        
		        System.out.println(treePath);
		        try {
		        	File fil = new File (treePath);
		        	if(fil.isDirectory())
		        	{
		        		new AddCatagory("AllUser\\Atiq",treePath);
		        		back.push(current);
		        		current = treePath;
		        		
		        		setVisible(false);
		        		
		        	}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        //treep = FilePath.getText();
		      }
		    });
		
		
		
		//scrollPane_1.setViewportView(FilePath);
		
		scrollPane_1.setBounds(309, 218, 273, 550);
		//scrollPane.setBounds(, y, width, height);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, scrollPane,scrollPane_1 );
		//splitPane.getVetoableChangeListeners();
		
		splitPane.setBounds(38, 218, 930, 550);
		panel.add(splitPane);
		//getContentPane().add(splitPane);
		
		
		
		
		//scrollPane_1.add(splitPane);
		//panel.add(scrollPane_1);
		//scrollPane_1.setViewportView(tree);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		//scrollBar_1.setBounds(10,1160,10,10);
		//scrollPane_1.setRowHeaderView(scrollBar_1);
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_3.setBounds(10, 800, 15, 800);
		//scrollPane_1.setColumnHeaderView(scrollBar_3);
		
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(876, 184, 89, 23);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnLogOut);
		RoundButton back = new RoundButton("Back");
		back.setBounds(48, 184, 37, 23);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		RoundButton forward = new RoundButton("forward");
		forward.setBounds(107, 184, 37, 23);
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(back);
		panel.add(forward);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(653, 185, 201, 20);
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		txtSearch.setText("Search");
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(154, 185, 489, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("image");
		lblNewLabel.setBounds(38, 62, 182, 118);
		lblNewLabel.setBackground(Color.BLACK);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("home");
		btnNewButton.setBounds(219, 62, 66, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Share");
		btnNewButton_1.setBounds(286, 62, 75, 20);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("view");
		btnNewButton_2.setBounds(360, 62, 60, 20);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(219, 82, 424, 92);
		panel.add(panel_1);
		
		JTextArea txtrFileSystemBy = new JTextArea();
		txtrFileSystemBy.setBounds(670, 82, 279, 91);
		txtrFileSystemBy.setBackground(new Color(0, 128, 0));
		txtrFileSystemBy.setFont(new Font("Modern No. 20", Font.BOLD, 23));
		txtrFileSystemBy.setText("    FILE SYSTEM \r\n      BY GROUP JEUS");
		panel.add(txtrFileSystemBy);
		
	}
}
