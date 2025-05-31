public class UserDirector {
    private UserBuilder userbuilder;
    public UserDirector(UserBuilder userBuilder){
        this.userbuilder=userBuilder;
    }
    public void createAccount(String email,String username, String password, int age, double weight){
        userbuilder.createEmail(email);
        userbuilder.createUsername(username);
        userbuilder.createPassword(password);
        userbuilder.createAge(age);
        userbuilder.createWeight(weight);
    }
    public User getUser() {
        return userbuilder.getUser();
    }
}
