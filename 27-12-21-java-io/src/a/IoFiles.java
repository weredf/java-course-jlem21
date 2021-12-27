package a;

import java.io.File;
import java.io.IOException;

public class IoFiles {

	public static void main(String[] args) {
		String path = "c:/Wered/temp/File1.txt"; // backslash(\) only works with windows, forward(/) works with linux
													// and mac as well
		try {
			// create file object that points to file(with path)
			File file = new File(path);
			// ask if exists, boolean
//		System.out.println(file.exists()); // true
			if (!file.exists()) {
				file.createNewFile(); // usually errors, try an catch necessary
				System.out.println("file created: " + file); // if no file with that name, creates one
			}else {
				System.out.println("file exists"); // if file exists, no new file created
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
