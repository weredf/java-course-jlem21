package app.core.jws;

import java.util.Arrays;
import java.util.Base64;

public class Demo2SecretDecoded {

	public static void main(String[] args) {
		// base-64
		
		// min 43 characters, needs 256 bit
		String secretKey = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		byte[] secretKeyEncoded = secretKey.getBytes();
		
		// prints numbers for characters according to Unicode table
		System.out.println(Arrays.toString(secretKeyEncoded));
		
		// we need an array of bytes in base-64
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKeyEncoded);
		System.out.println(Arrays.toString(secretKeyDecoded));
		System.out.println(secretKeyDecoded.length); // 32*8 = 256 -> minimum
	}

}
