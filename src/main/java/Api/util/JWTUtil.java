package Api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String SECRET_KEY = "your-secret-key"; // Secret key to sign the JWT
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours expiration time

    /**
     * Generate a JWT token for the given username.
     *
     * @param username The username to generate the token for
     * @return The JWT token
     */
    public String generateToken(String username) {
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        System.out.println("Generated JWT: " + token);  // Debugging log
        return token;
    }


    /**
     * Validate the JWT token by checking the signature and expiration.
     *
     * @param token The JWT token to validate
     * @return true if valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid JWT Token: " + e.getMessage());  // Debugging log
            return false;
        }
    }
    
    

    /**
     * Extract the username from the JWT token.
     *
     * @param token The JWT token to extract the username from
     * @return The username (subject) of the token
     */
    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody(); // Extract the claims from the token
        return claims.getSubject(); // Return the subject (username)
    }
    
    
}
