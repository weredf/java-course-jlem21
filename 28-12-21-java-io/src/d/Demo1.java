package d;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {
		// data to file
		int n1 = 123;
		byte n2 = 50;
		double n3 = 2.458;
		boolean b = true;
		long n4 = 99999999999L;
		
		// 1. define a file with relative path:
		// files/primitives.data
		File file = new File("files/primitives.data");
		
		// 2. create a DataOutputStream
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file));){
			out.writeInt(n1);
			out.writeByte(n2);
			out.writeDouble(n3);
			out.writeLong(n4);
			out.writeBoolean(b);
			// 3. print a success message
			System.out.println("data stored in " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
