package com.receiptwallet.profile.security;

import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//@Component
public class JwtTokenProvider {

	// @Value("${security.jwt.token.secret-key:secret}")
	private static String secretKey = "secret";

	// @Value("${security.jwt.token.expire-length:3600000}")
	private static long validityInMilliseconds = 3600000; // 1h

	private static String encodedSecretKey;

	// @PostConstruct
	static {
		encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public static String createToken(String emailId, String password, String phone, String firstName, String lastName,
			String profileId) {
		Claims claims = Jwts.claims().setSubject("ProfileInfo");
		claims.put("password", password);
		claims.put("profileId", profileId);
		claims.put("firstName", firstName);
		claims.put("phone", phone);
		claims.put("emailId", emailId);
		claims.put("lastName", lastName);

		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);
		return Jwts.builder()//
				.setClaims(claims)//
				.setIssuedAt(now)//
				.setExpiration(validity)//
				.signWith(SignatureAlgorithm.HS256, encodedSecretKey)//
				.compact();
	}

}
