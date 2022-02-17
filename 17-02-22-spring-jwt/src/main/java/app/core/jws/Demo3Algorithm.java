package app.core.jws;

import io.jsonwebtoken.SignatureAlgorithm;

public class Demo3Algorithm {

	public static void main(String[] args) {
		// JCA

		System.out.println(SignatureAlgorithm.HS256);
		System.out.println("description: " + SignatureAlgorithm.HS256.getDescription());
		
		// In cryptography, an HMAC is a specific type of Message Authentication Code
		// (MAC) involving a cryptographic Hash function and a secret cryptographic key.
		// HMAC = Hash based Message Authentication Code

	}

}
