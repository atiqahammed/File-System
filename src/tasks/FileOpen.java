package tasks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileOpen {
	public boolean fileOpen(String filePath) {
		try {
			Desktop desktop = null;
			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
			}

			desktop.open(new File(filePath));
		} catch (IOException ioe) {
			return false;
		}
		return true;
	}


	public boolean fileOpen(File file) {
		try {
			Desktop desktop = null;
			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
			}

			desktop.open(file);
		} catch (IOException ioe) {
			return false;
		}
		return true;
	}

}
