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
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import com.sun.mail.imap.Rights.Right;

import Authentication.FirstLogInPage;
import Authentication.User;
import tasks.Copy;
import tasks.Directory;
import tasks.NewFile;
import tushar.RightClick.MyLabel.PopupTriggerListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AllPermission;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class FileWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField textField;
	private File uploadedFile;
	private JFrame frame;
	private JPasswordField passwordField;
	private int index = 1;
	private ArrayList<User> allUsers = new ArrayList<User>();
	private FileReader inputFile;
	private BufferedReader stream;
	private int totalAccount;
	static Stack<String> Back = new Stack<>(),Forword = new Stack<>();
	static String current = "Alluser" ;
	JPopupMenu menu = new JPopupMenu("Popup");
	public static boolean CopySelect,CutSelect,ShareSelect,ShareWith;
	private static String dire = "";
	/**
	 * @wbp.nonvisual location=102,-31
	 */
	private final JScrollBar scrollBar = new JScrollBar();
	private static JTextArea fileDetailsTextArea = new JTextArea();
	private static JPanel p = new JPanel();
	private String userName; 
	private static String ListPath = "",CutCopyPath = "";
	
	
	class PopupTriggerListener extends MouseAdapter {
		
	      public void mousePressed(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	          menu.show(ev.getComponent(), ev.getX(), ev.getY());
	        }
	      }

	      public void mouseReleased(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	          menu.show(ev.getComponent(), ev.getX(), ev.getY());
	        }
	      }

	      public void mouseClicked(MouseEvent ev) {
	      }
	    }
	public FileWindow(String path,String treePath, String userName) throws FileNotFoundException {
		
		Popup();
		this.userName = userName;
		current = userName;
		dire = treePath;
		 try 
		    { 
			 UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel"); 
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
		list.addMouseListener(new PopupTriggerListener());
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String fileSelect = list.getSelectedValue().toString();
				ListPath = fileSelect;
				//System.out.println(ListPath);
						
			}
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {
		      public void valueChanged(TreeSelectionEvent event) {
		        File file = (File) tree.getLastSelectedPathComponent();
		        String treePath = file.getPath().toString();
		         
		     
		       
		        availableList.add(FilePath);
		        FilePath.setText(treePath);
		       // fileDetailsTextArea.setText(treePath);
		        //scrollPane_1.repaint();
		       // scrollPane_1.add(FilePath);
		        //p.repaint();
		      //  p = new Explorer().Explore(treePath);
		        //ListPath = treePath;
		        
		        System.out.println(treePath);
		        try {
		        	File fil = new File (treePath);
		        	if(fil.isDirectory() )
		        	{
		        		new FileWindow(userName,treePath, userName);
		        		Back.push(current);
		        		current = treePath;
		        		while(!Forword.isEmpty()) Forword.pop();
		        		setVisible(false);
		        		
		        	}
		        	while(!Forword.isEmpty()) Forword.pop();
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
			setVisible(false);
			FirstLogInPage firstLogInPage =  new FirstLogInPage();
			firstLogInPage.runPage();
			
			}
		});
		
		
		panel.add(btnLogOut);
		RoundButton back = new RoundButton("Back");
		if(Back.isEmpty()) back.setVisible(false);
		back.setBounds(48, 184, 37, 23);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Forword.push(current);
				current = Back.pop();
				setVisible(false);
				try {
					new FileWindow(userName,current, userName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		RoundButton forward = new RoundButton("forward");
		if(Forword.isEmpty()) forward.setVisible(false);
		forward.setBounds(107, 184, 37, 23);
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Forword.isEmpty())
				{
					Back.push(current);
					current = Forword.pop();
					try {
						new FileWindow(userName,current, userName);
						setVisible(false);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		panel.add(back);
		panel.add(forward);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(653, 185, 201, 20);
		//txtSearch.setText(ListPath);
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
		textField.setText(dire);
		panel.add(textField);
		textField.setColumns(10);
		
		//JButton 
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(38, 62, 182, 118);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("PICTUREs/"+userName+".png"));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel( );
		
		panel_1.setBounds(219, 82, 424, 92);
		//panel_1.add(new JLabel("tusher"));
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
		
		JComboBox<String> conmboUser = new JComboBox<>();
		ArrayList<String > userNameArr = new ArrayList<>();
		for(User user : allUsers){
			conmboUser.addItem(user.getUserName());
		}
		
		panel_1.add(conmboUser);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(219, 62, 66, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = JOptionPane.showInputDialog("Create New File Or Folder");
				if(!fileName.contains(".")){
					//frame.setVisible(false);
					Directory directory = new Directory();
					directory.create(ListPath,fileName);
					try {
						//frame.setVisible(false);
						new FileWindow(path, ListPath, userName);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					setVisible(false);
				}
				else {
					//frame.setVisible(false);
					NewFile newFile = new NewFile();
					newFile.create(ListPath,fileName);
					try {
						new FileWindow(path, ListPath, userName);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Share");
		btnNewButton_1.setBounds(286, 62, 75, 20);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String shareFile = (String) conmboUser.getSelectedItem();
				shareFile += "\\shareWithMe";
				
				File src = new File(ListPath);
				File des = new File(shareFile+"\\"+src.getName());
				try {
					if(src.isDirectory())
					new tasks.Copy().copyFolder(src, des);
					else {
						new tasks.Copy().copyFile(ListPath, shareFile);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("upload");
		btnNewButton_2.setBounds(360, 62, 60, 20);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					uploadedFile = fc.getSelectedFile();
				}

				Copy copy = new Copy();
				try {
					copy.copyFile(uploadedFile, ListPath + "/" + uploadedFile.getName());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				try {
					new FileWindow(path, ListPath, userName);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "File uploaded succefully");
			}
		});
		panel.add(btnNewButton_2);
		
		
		JTextArea txtrFileSystemBy = new JTextArea();
		txtrFileSystemBy.setBounds(670, 82, 279, 91);
		txtrFileSystemBy.setBackground(new Color(0, 128, 0));
		txtrFileSystemBy.setFont(new Font("Modern No. 20", Font.BOLD, 23));
		txtrFileSystemBy.setText("    FILE SYSTEM \r\n      BY GROUP JEUS");
		panel.add(txtrFileSystemBy);
		
	}
	public void Popup() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JButton Open = new JButton("     Open     ");
	    Open.setSize(50,10);
	    Open.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  File file = new File(ListPath);
	    	  if(file.isDirectory()){
	    		  try {
	    			Back.push(current);
					current = ListPath;
					new FileWindow(userName,current, userName);
					while(!Forword.isEmpty()) Forword.pop();
					
		    		
		    		
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		  setVisible(false);
	    		  
	    	  }
	    	  else
	    	  new tasks.FileOpen().fileOpen(ListPath);
	    	  
	      }
	    });
	    menu.add(Open);

	    JButton Cut = new JButton("       Cut       ");
	    Cut.setSize(50,10);
	    Cut.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  CopySelect = false;
		      CutSelect = true;
		      CutCopyPath = ListPath;
	      }
	    });
	    menu.add(Cut);
	    
	    JButton Copy = new JButton("      Copy     ");
	    Copy.setSize(50,10);
	    Copy.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        CopySelect = true;
	        CutSelect = false;
	        CutCopyPath = ListPath;
	        System.out.println(CutCopyPath);
	      }
	    });
	    menu.add(Copy);
	    JButton Paste = new JButton("    Paste     ");
	    Paste.setSize(50,10);
	    Paste.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        if(CopySelect){
	        	try {
					//File copyFile = new F
	        		File src = new File(CutCopyPath);
	        		File des = new File(ListPath+"\\"+src.getName());
	        		if(src.isDirectory()){
	        			new tasks.Copy().copyFolder(src, des);
	        		}
	        		else new tasks.Copy().copyFolder(src, des);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	        	
	        }
	        else if(CutSelect){
	        	try {
	        		
	        		File src = new File(CutCopyPath);
	        		File des = new File(ListPath+"\\"+src.getName());
	        		File lst = new File(ListPath);
	        		String str = ListPath.replace(lst.getName(),"" );
	        		if(src.isDirectory()){
	        			new tasks.Copy().copyFolder(src, des);
	        			new tasks.Delete().delete(src);
	        		}
	        		else 
	        		{
	        			new tasks.Copy().copyFolder(src, des);
	        			new tasks.Delete().delete(src);
	        		}
	        		setVisible(false);
	        		new FileWindow(userName, str, userName);
					//System.out.println(CutCopyPath + "To "+ ListPath);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	        System.out.println(CutCopyPath + "To "+ ListPath);
	      }
	    });
	    menu.add(Paste);
	    JButton Delete = new JButton("    Delete    ");
	    Delete.setSize(50,10);
	    Delete.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	File fl = new File(ListPath);
	        String delefl = ListPath.replace("\\"+fl.getName(), "");
	        try {
				new tasks.Delete().delete(new File(ListPath));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        setVisible(false);
	        try {
				new FileWindow(userName, delefl, userName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }
	    });
	    menu.add(Delete);
	    JButton Rename = new JButton("   Rename ");
	    Rename.setSize(50,10);
	    Rename.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        String rm = JOptionPane.showInputDialog("Enter Rename file");
	        File fl = new File(ListPath);
	        if(!fl.isDirectory()) {
	        	String str = fl.getName().substring(fl.getName().lastIndexOf("."), fl.getName().length());
	        	rm = rm + str;
	        	//System.out.println(str);
	        }
	        String str = ListPath.replace(fl.getName(),rm);
	        String str1 = ListPath.replace(fl.getName(),"");
	        System.out.println(str1);
	        try {
	        	File src = new File(ListPath);
	        	if(src.isDirectory())
	        	{
	        		new tasks.Copy().copyFolder(src,new File(str));
	        	}
	        	else new tasks.Copy().copyFile(ListPath, str);
				new tasks.Delete().delete(new File(ListPath));
				ListPath = str;
				setVisible(false);
				new FileWindow(userName,str1 , userName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        System.out.println(ListPath);
	       // System.out.println(rm);
	        //System.out.println(fl.getName());
	        
	        
	      }
	    });
	    menu.add(Rename);
	    JButton Properties = new JButton("properties");
	    Properties.setSize(50,10);
	    Properties.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        File fl = new File(ListPath);
	        String ex =  fl.getName().substring(fl.getName().lastIndexOf(".")+1,fl.getName().length());
	        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	        sdf.format(fl.lastModified());
	        String str ;
	        boolean si = false;
	        int unit =  1024;
	        if (fl.getUsableSpace() < unit) str =  fl.length() + " B";
	        int exp = (int) (Math.log(fl.getUsableSpace()) / Math.log(unit));
	        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	         str = String.format("%.1f %sB", fl.getUsableSpace()/ Math.pow(unit, exp), pre);
	         new Properties(fl.getName(),ex,sdf.format(fl.lastModified()), userName, str);
	      }
	    });
	    menu.add(Properties);

	   
	    pack();
	    setSize(938,741);
	  }
	
}
