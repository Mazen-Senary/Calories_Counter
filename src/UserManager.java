import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance = null;
    private List<User> users;
    private String currentUser; // Track logged-in user
    private static final String USERS_FILE = "data/users.txt";

    private UserManager() {
        users = new ArrayList<>();
        loadUsers();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    // Add user to list and save to file
    public void addUser(User user) {
        if (user == null || users.contains(user)) {
            throw new IllegalArgumentException("User already exists or is invalid");
        }
        users.add(user);
        saveUsers();
    }

    // Load users from data/users.txt
    private void loadUsers() {
        // Ensure data directory exists
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        File file = new File(USERS_FILE);
        if (!file.exists()) {
            return; // No file yet, keep users empty
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    User user = User.fromString(line);
                    if (!users.contains(user)) { // Avoid duplicates
                        users.add(user);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid user data: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading users.txt: " + e.getMessage());
        }
    }

    // Save users to data/users.txt
    private void saveUsers() {
        // Ensure data directory exists
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to users.txt: " + e.getMessage());
            throw new RuntimeException("Failed to save users", e);
        }
    }

    // Verify user credentials for login
    public boolean verifyUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        // Hash password same way as ConcreteUser
        String hashedPassword = Integer.toHexString(password.hashCode());
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(hashedPassword)) {
                currentUser = username;
                return true;
            }
        }
        return false;
    }

    // Get current logged-in user
    public String getCurrentUser() {
        return currentUser;
    }

    // For debugging
    public void displayAllUsers() {
        for (User user : users) {
            user.displayInfo();
        }
    }
}