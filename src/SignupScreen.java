import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupScreen extends JFrame{
   public JPanel signupFrame;
    private JLabel title;
    private JLabel emailLabel;
    private JLabel uernameLabel;
    private JTextField emailfield;
    private JTextField usernameFiled;
    private JTextField ageField;
    private JTextField weightField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton1;

    public SignupScreen() {
        createAccountButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Email= emailfield.getText().trim();
                String Username =usernameFiled.getText().trim();
                String Password = new String(passwordField.getPassword()).trim();
                String Age = ageField.getText().trim();
                String Weight = weightField.getText().trim();
                if(Email.isEmpty()|| Username.isEmpty()||Age.isEmpty()||Weight.isEmpty()||Password.isEmpty()){
                    JOptionPane.showMessageDialog(signupFrame,
                            "Please fill in all fields.", " Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int age;
                double weight;
                try {
                    age = Integer.parseInt(Age);
                    weight = Double.parseDouble(Weight);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(signupFrame, "invalid weight and age.", " Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String hashedPassword = Integer.toHexString(Password.hashCode());
                //store user in file
                User user = new User();
                user.setEmail(Email);
                user.setUsername(Username);
                user.setPassword(hashedPassword);
                user.setAge(age);
                user.setWeight(weight);
                UserManager userManager=UserManager.getInstance();
                userManager.addUser(user);
                JOptionPane.showMessageDialog(signupFrame, "Account created ", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setContentPane(loginScreen.loginFrame);
                loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginScreen.setTitle("Login");
                loginScreen.setSize(500, 500);
                loginScreen.setVisible(true);

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginScreen l = new LoginScreen();
                l.setContentPane(l.loginFrame);
                l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                l.setVisible(true);
                l.setSize(500,500);
                dispose();

            }
        });
    }
}
