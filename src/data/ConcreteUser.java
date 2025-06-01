package data; // Corrected: Uses 'data' package

public class ConcreteUser implements UserBuilder {
    User user;

    public ConcreteUser() {
        this.user = new User(); // Correctly initializes the User object
    }

    @Override
    public void createEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("invalid email format");
        }
        user.setEmail(email);
    }

    @Override
    public void createUsername(String username) {
        if(username==null){
            throw new IllegalArgumentException("Username can't be empty");
        }
        user.setUsername(username);
    }

    @Override
    public void createPassword(String password) {
        if (password == null || password.length() < 6){
            throw new IllegalArgumentException("password can't be empty and at least 6 characters");
        }
        user.setPassword(Integer.toHexString(password.hashCode()));
    }

    @Override
    public void createAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("invalid age");
        }
        user.setAge(age);
    }

    @Override
    public void createWeight(double weight) {
        if(weight <=0 || weight > 800){
            throw new IllegalArgumentException("invalid weight");
        }
        user.setWeight(weight);
    }

    @Override
    public User getUser() {
        return user;
    }
}