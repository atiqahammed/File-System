package tasks;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class NewFile {
	public boolean create(String path,String fileName){

		//String fileName = JOptionPane.showInputDialog("Enter Folder Name");
		File file = new File(path+"\\"+fileName);
		boolean isCreated = true ;
		if(!file.exists()){
			try {
				isCreated = file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(isCreated){
			new FileOpen().fileOpen(file);;

		}
		return isCreated;
	}
}
