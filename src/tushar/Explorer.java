package tushar;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Explorer {

	public  JPanel Explore(String path){
		File directory = new File(path);
		File[] contents = directory.listFiles();
		 
		
		ArrayList<String> list=new ArrayList<String>();
		for ( File f : contents) 
		  //System.out.println(f.getName());
			list.add(f.getName());
		
		String [] arr  = list.toArray(new String[list.size()]);
		
		JFrame frm = new JFrame();
		JPanel p = new JPanel();
		//JLabel b = new JLabel("");
		p.setLayout(new GridLayout(5,4));
		frm.add(p);
		ImageIcon image1 = new ImageIcon("jpg.png");
		ImageIcon image2 = new ImageIcon("txt.png");
		//image1 = ((Image) image1).getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		//image2.getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		//ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
		Image image = image1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image1 = new ImageIcon(newimg);
		
		Image imagee = image2.getImage(); // transform it 
		Image newimge = imagee.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image2 = new ImageIcon(newimge);
		
	
		System.out.println(arr.length);
		int i=0;
		while(true) {
			if(i>=arr.length) break;
			{
				String [] s = arr[i].split("\\.");
				if(s.length > 1&&s[1].equals("txt")) p.add(new JLabel(image2));
				else if(s.length > 1&&s[1].equals("PNG")) p.add(new JLabel(image1));
			}
			if(i+1>=arr.length) break;
			{
				String [] s1 = arr[i+1].split("\\.");
				if(s1.length > 1&& s1[1].equals("txt") ) p.add(new JLabel(image2));
				else if(s1.length > 1&& s1[1].equals("PNG")) p.add(new JLabel(image1));
			}
			if(i+2>=arr.length) break;
			{
				String [] s2 = arr[i+2].split("\\.");
				if(s2.length > 1&& s2[1].equals("txt")) p.add(new JLabel(image2));
				else if(s2.length > 1&& s2[1].equals("PNG")) p.add(new JLabel(image1));
			}
			if(i+3>=arr.length) break;
			{
				String [] s3 = arr[i+3].split("\\.");
				if(s3.length > 1&&s3[1].equals("txt")) p.add(new JLabel(image2));
				else if(s3.length > 1&&s3[1].equals("PNG")) p.add(new JLabel(image1));
			}
			if(i+4>=arr.length) break;
			//System.out.println(s.length);
			
			
			
			
			
			
			JLabel m = new JLabel("                       "+arr[i]);
			m.setForeground(Color.GREEN);
			p.add(m);
			m = new JLabel("                                                 "+arr[i+1]);
			m.setForeground(Color.GREEN);
			p.add(m);
			m = new JLabel("                                                                         "+arr[i+2]);
			m.setForeground(Color.GREEN);
			p.add(m);
			m = new JLabel("                                                                                                   "+arr[i+3]);
			m.setForeground(Color.GREEN);
			p.add(m);
			i = i+4;
		
		}
		p.setBackground(Color.BLACK);
		frm.setVisible(true);
		frm.setSize(800, 800);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(false);
		return p;
		

	}
	public JList getGui(String path) {
        // put File objects in the list..
		File directory = new File(path);
		File[] contents = directory.listFiles();
        JList fileList = new JList(contents);
        // ..then use a renderer
         boolean vertical = false;
        fileList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            fileList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            fileList.setVisibleRowCount(-1);
        } else {
            fileList.setVisibleRowCount(9);
        }
        return fileList;
    }
}
