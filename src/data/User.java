package data; // Corrected: Singular, and uses 'data' package

import java.util.Objects;

public class User implements Cloneable {
    private String email;
    private String username;
    private String password;
    private int age;
    private double weight;

    public User() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

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

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("CloneNotSupportedException for User", e);
        }
    }

    public void displayInfo() {
        System.out.println("User Information:");
        System.out.println("Email: " + this.email);
        System.out.println("Username: " + this.username);
        System.out.println("Password: [HIDDEN]");
        System.out.println("Age: " + this.age);
        System.out.println("Weight: " + this.weight + " kg");
    }

    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid user data format: " + line);
        } else {
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
    }

    @Override
    public String toString() {
        return this.email + "," + this.username + "," + this.password + "," + this.age + "," + this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) || Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }
}