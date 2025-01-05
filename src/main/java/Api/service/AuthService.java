package Api.service;

import Api.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    // In-memory user store (for demonstration purposes)
    private Map<String, User> userDatabase = new HashMap<>();

    // Constructor to populate some users (for example purposes)
    public AuthService() {
        // In a real app, you would query the database for the user.
        userDatabase.put("user", new User("user", "password"));
        userDatabase.put("admin", new User("admin", "admin123"));
    }

    /**
     * Authenticate the user by username and password.
     *
     * @param username Username to authenticate
     * @param password Password to authenticate
     * @return User object if authentication is successful, null otherwise
     */
    public User authenticate(String username, String password) {
        // Validate username and password
        if (username == null || password == null) {
            System.out.println("Username or Password is null!");  // Debugging log
            return null;  // Reject null values
        }

        User user = userDatabase.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Authenticated User: " + user.getUsername());  // Debugging log
            return user;
        }

        System.out.println("Authentication failed for user: " + username);  // Debugging log
        return null; // Invalid credentials
    }

}
