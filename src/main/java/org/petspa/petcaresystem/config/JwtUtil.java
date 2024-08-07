package org.petspa.petcaresystem.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    public static String SECRET_KEY = Base64.getEncoder().encodeToString(Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded());


    private SecretKey getSingingKey(){
        //byte[] keyBytes = Base64.getUrlDecoder().decode(SECRET_KEY);
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }


    public String extractRole(String token){
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    public String extractUserName(String token){
        return extractClaim(token, claims -> claims.get("userName", String.class));
    }

    public Long extractUserId(String token){
        return extractClaim(token, claims -> claims.get("userId", Long.class));
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSingingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
   }

   // check token expire time
   private Boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
   }

   // create token with email
   public String generateToken(String email, String role, String userName, Long userId) {
       Map<String, Object> claims = new HashMap<>();
       claims.put("role", "ROLE_" + role.toUpperCase());
       claims.put("userName", userName);
       claims.put("userId", userId);
       return createToken(claims, email);
   }

   // create new token with claims and subject
   private String createToken(Map<String, Object> claims, String subject) {
        return Jwts
                .builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10000 * 60 * 24))
                .signWith(getSingingKey()).compact();
   }

    // check token validate
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
