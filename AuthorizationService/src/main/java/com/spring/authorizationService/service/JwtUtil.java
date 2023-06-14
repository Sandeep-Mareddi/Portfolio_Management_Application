package com.cognizant.authorizationService.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	private String secretkey = "${jwt.secret}";

	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		logger.info("START");

		final Claims claims = extractAllClaims(token);
		logger.info("END");

		return claimsResolver.apply(claims);

	}

	private Claims extractAllClaims(String token) {

		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();

	}

	public String generateToken(UserDetails userDetails) {
		logger.info("START GENERATING TOKEN");

		Map<String, Object> claims = new HashMap<>();
		logger.info("ENDING GENERATING TOKEN");

		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		logger.info("START");

		String compact = Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis())).signWith(SignatureAlgorithm.HS256, secretkey)
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
				.compact();
		logger.info("END");

		return compact;
	}

	public Boolean validateToken(String token) {
		logger.info("START");

		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			logger.info("END");

			return true;
		} catch (Exception e) {
			logger.info("EXCEPTION");
			return false;
		}

	}
}