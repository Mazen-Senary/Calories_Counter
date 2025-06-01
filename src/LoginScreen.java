import data.DashBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen  extends JFrame {
    private JLabel title;
    private JLabel usernamLabel;
    private JLabel passwordLabel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    public JPanel loginFrame;
    private JLabel textLabel;
    private JButton signupButton;

    public LoginScreen() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());

                UserManager userManager = UserManager.getInstance();
                boolean isValid = userManager.verifyUser(username, password);

                if (isValid) {
                    JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + username);
                    dispose();
                    DashBoard dashboardScreen = new DashBoard();
                    dashboardScreen.setContentPane(dashboardScreen.Dash);
                    dashboardScreen.setVisible(true);
                    dashboardScreen.setSize(700, 600);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignupScreen signupScreen = new SignupScreen();
                signupScreen.setContentPane(signupScreen.signupFrame);
                signupScreen.setVisible(true);
                signupScreen.setSize(500, 500);
                dispose();
            }
        });
    }
}
