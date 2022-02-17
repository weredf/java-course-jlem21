package app.core.jwt;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1ParsingJws {

	public static void main(String[] args) {

		// Creating the key
		// 1. set the secret - signature
		String secretKey = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		// 2. decode to base-64
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKey.getBytes());
		// 3. choose algorithm
		String algorithm = SignatureAlgorithm.HS256.getJcaName(); // JCA algorithm used to compute the signature
		// 4. create the key
		Key key = new SecretKeySpec(secretKeyDecoded, algorithm);
		
		// ==========================
		
		// get a token (from app.core.jws.Demo5)
		String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtbUBtYWlsLmNvbSIsImlhdCI6MTY0NTEwMDgzMCwiZXhwIjoxNjQ1MTAxMTMwLCJjbGllbnQtdHlwZSI6IkNvbXBhbnkiLCJhZGRyZXNzIjoiSmVydXNhbGVtLCBJc3JhZWwifQ.JXVlIrUUjl_wjBMxVIlBCB_kafyh3J1kd_LK6EoLMlc";
		// get a parser
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		// parse the token and get the JWT (Jason Web Token)
		Jws<Claims> jwt = jwtParser.parseClaimsJws(jws);
		
		// print data
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		System.out.println(jwt.getSignature());
		// get exception(io.jsonwebtoken.ExpiredJwtException) when token expired after 5 minutes
	}

}
