package tasks;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new tasks.Copy().copyFile("C:\\Users\\Unity BD\\Desktop\\New folder\\java\\bin\\filesystem\\atiq1\\file.txt","C:\\Users\\Unity BD\\Desktop\\New folder\\java\\bin\\filesystem\\atiq1\\atiq4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
