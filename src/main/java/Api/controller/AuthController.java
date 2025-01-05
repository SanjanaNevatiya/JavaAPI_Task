package Api.controller;

import Api.service.AuthService;
import Api.util.JWTUtil;
import Api.entity.User;
import Api.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil; // For generating and validating JWT tokens

    @Autowired
    private AuthService authService; // A service to handle username/password validation

    /**
     * Handle user login and generate JWT token.
     *
     * @param username Username provided in the login request
     * @param password Password provided in the login request
     * @return Response with JWT token if authentication is successful
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("Authenticating user: " + username);  // Debugging log

        // Validate username and password using the AuthService
        User user = authService.authenticate(username, password);
        
        if (user != null) {
            System.out.println("User authenticated successfully. Generating token.");  // Debugging log
            // Generate JWT token
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(new JwtResponse(token)); // Send token back in response
        } else {
            System.out.println("Invalid credentials for user: " + username);  // Debugging log
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
