package tasks;

import java.io.File;
import java.io.IOException;

public class Delete {
	public boolean deleteFile(String filePath) {

		try {
			File file = new File(filePath);
			file.delete();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static void delete(File file)
	    	throws IOException{

	    	if(file.isDirectory()){

	    		//directory is empty, then delete it
	    		if(file.list().length==0){

	    		   file.delete();
	    		   

	    		}else{

	    		   //list all the directory contents
	        	   String files[] = file.list();

	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);

	        	      //recursive delete
	        	     delete(fileDelete);
	        	   }

	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length==0){
	           	     file.delete();
	        	    
	        	   }
	    		}

	    	}else{
	    		//if file, then delete it
	    		file.delete();
	    		
	    	}
	    }

	public boolean deleteFile(File file) {

		try {
			file.delete();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
