package app.core.jws;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class Demo1TokenWithoutSignature {

	public static void main(String[] args) {
		// jws - s stands for signature
	
		Instant now = Instant.now();
		Instant expiration = now.plus(30, ChronoUnit.SECONDS);
		
		String jws = Jwts.builder()
				
				.setSubject("mm@mail.com") // sub
				
				.setIssuedAt(Date.from(now)) // iat
				
				.setExpiration(Date.from(expiration)) // exp
				
				.claim("client-type", "Company") // details
				
//				.claim("first name", "Mickey")
				
//				.claim("last name", "Mouse")
				
				.claim("address", "Jerusalem, Israel") // details
				
				.compact();
		
		System.out.println(jws);
	}

}
