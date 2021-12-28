package c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFile {

	public static void main(String[] args) {
		File directory = new File("c:/Wered/temp/a/b"); // folders to use/create
		if(!directory.exists()) { // if file doesn't exist
//			directory.mkdir(); // creates last folder of path
			directory.mkdirs(); // creates all missing folders
		}
		// destination file
		File file = new File(directory, "/file2.txt");
		
		// create object that can write text to file
		// add buffer
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true));){ // boolean append, true can add to existing file
			out.write("This is the first line");
			out.newLine();
			out.write("This is the second line");
			out.newLine();
//			int x = 500;
//			out.write(""+x);
			System.out.println("text written");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
