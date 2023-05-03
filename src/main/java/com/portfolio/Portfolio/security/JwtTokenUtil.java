package com.portfolio.Portfolio.security;

import java.nio.charset.StandardCharsets;
// import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.portfolio.Portfolio.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;

@Component
public class JwtTokenUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
  
  private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

  SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  String secretString = Encoders.BASE64.encode(key.getEncoded());

  // public void logging() {
  //   System.out.println(secretString);
  // }

  public String generateAccessToken(User user) {

    // logging();

    return Jwts.builder()
        .setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
        .setIssuer("CodeJava")
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
        .signWith(key)
        .compact();

  }


  public boolean validateAccessToken(String token) {
    try {
      ((JwtParser) Jwts.parserBuilder().setSigningKey(key)).parseClaimsJws(token);
      return true;
    } catch (ExpiredJwtException ex) {
      LOGGER.error("JWT expired", ex.getMessage());
    } catch (IllegalArgumentException ex) {
      LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
    } catch (MalformedJwtException ex) {
      LOGGER.error("JWT is invalid", ex);
    } catch (UnsupportedJwtException ex) {
      LOGGER.error("JWT is not supported", ex);
    } catch (SecurityException ex) {
      LOGGER.error("Signature validation failed");
    }

    return false;
  }

  public String getSubject(String token) {
    return parseClaims(token).getSubject();
  }

  private Claims parseClaims(String token) {
    return ((JwtParser) Jwts.parserBuilder()
        .setSigningKey(key))
        .parseClaimsJws(token)
        .getBody();
  }

}