package tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
	public void copyFile(String sourceFilePath,String destinationFilePath) throws IOException{
		//File source = new File(sourceFile);
		//File dest = new File(destination);
		//
		File sourceFile = new File(sourceFilePath);
		File destinationFile = new File(destinationFilePath);
		//sourceFile.delete();
		FileInputStream fileInputStream = new FileInputStream(sourceFile);
		FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

		int bufferSize;
		byte[] bufffer = new byte[512];
		try {
			while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
			fileOutputStream.write(bufffer, 0, bufferSize);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
	public static void copyFolder(File src, File dest)
	    	throws IOException{

	    	if(src.isDirectory()){

	    		//if directory not exists, create it
	    		if(!dest.exists()){
	    		   dest.mkdir();
	    		  
	    		}

	    
	    		String files[] = src.list();

	    		for (String file : files) {
	    		   File srcFile = new File(src, file);
	    		   File destFile = new File(dest, file);
	    	
	    		   copyFolder(srcFile,destFile);
	    		}

	    	}else{
	    		
	    		InputStream in = new FileInputStream(src);
	    	       OutputStream out = new FileOutputStream(dest);

	    	        byte[] buffer = new byte[1024];

	    	        int length;
	    	        while ((length = in.read(buffer)) > 0){
	    	    	   out.write(buffer, 0, length);
	    	        }

	    	        in.close();
	    	        out.close();
	    	        //System.out.println("File copied from " + src + " to " + dest);
	    	}
	    }
	public void copyFile(File sourceFile,String destinationFilePath) throws IOException{
		//File source = new File(sourceFile);
		//File dest = new File(destination);
		//
		//File sourceFile = new File(sourceFilePath);
		File destinationFile = new File(destinationFilePath);
		//sourceFile.delete();
		FileInputStream fileInputStream = new FileInputStream(sourceFile);
		FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

		int bufferSize;
		byte[] bufffer = new byte[512];
		try {
			while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
			fileOutputStream.write(bufffer, 0, bufferSize);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.close();
		fileOutputStream.close();
	}

}
