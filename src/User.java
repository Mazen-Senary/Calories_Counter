public class User {
    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    private int age;
    private double weight;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void displayInfo() {
        System.out.println("User Information:");
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Password: [HIDDEN]");
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
    }

    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid user data format: " + line);
        }
        try {
            String email = parts[0];
            String username = parts[1];
            String password = parts[2];
            int age = Integer.parseInt(parts[3]);
            double weight = Double.parseDouble(parts[4]);
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            user.setWeight(weight);
            return user;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in user data: " + line, e);
        }
    }

    // Convert User to string for file storage
    @Override
    public String toString() {
        return email + "," + username + "," + password + "," + age + "," + weight;
    }

    // Override equals for user comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) || email.equals(user.email);
    }

    // Override hashCode to match equals
    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}


