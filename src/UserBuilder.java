public interface UserBuilder {

    void createEmail(String email);

    void createUsername(String username);

    void createPassword(String password);

    void createAge(int age);

    void createWeight(double weight);

    User getUser();
}

