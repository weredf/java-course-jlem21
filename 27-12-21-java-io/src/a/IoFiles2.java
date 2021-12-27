package a;

import java.io.File;
import java.io.IOException;

public class IoFiles2 {

	public static void main(String[] args) {
		try { // auto fill try/catch only around create new file, better to move to surround whole main
			String path = "c:/Wered/temp/File1.txt";
			File file = new File(path);

			if (file.exists()) {
				System.out.println("file exists: " + file);
			} else {
				System.out.println("file doesn't exist: " + file);
				file.createNewFile();
				System.out.println("file created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
