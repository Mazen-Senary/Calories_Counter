import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupScreen {
    private JPanel signupFrame;
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

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
