package tasks;

import java.io.File;

import javax.swing.JOptionPane;

public class Directory {
	public boolean create(String path,String fileName) {
		//String fileName = JOptionPane.showInputDialog("Enter Folder Name");
		path = path + "/" + fileName;

		boolean success = true;
		try{
			success = (new File(path)).mkdirs();
			System.out.println(success);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return success;

	}
	
	public boolean createDir(String userName) {
		//String fileName = JOptionPane.showInputDialog("Enter Folder Name");
		String path =  userName;

		boolean success = true;
		try{
			success = (new File(path)).mkdirs();
			System.out.println(success);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return success;

	}
	
	


	public boolean create(File file) {

		if(!file.isDirectory())
			return false;



		String path = file.getPath();
		String fileName = JOptionPane.showInputDialog("Enter Folder Name");
		path = path +"/"+fileName;

		boolean success = true;
		try{
			success = (new File(path)).mkdirs();
			System.out.println(success);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return success;

	}
}
