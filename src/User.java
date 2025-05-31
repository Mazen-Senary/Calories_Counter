public class User {
    private String email;
    private String username;
    private String password;
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
}

