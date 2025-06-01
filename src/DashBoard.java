import Strategy.PaymentScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame{
    public JPanel Dash;
    private JLabel welcomeLabel;
    private JButton premierButto;
    private JLabel instructionLabel;
    private JTextField mealInputField;
    private JButton deleteButton;
    private JButton addButton;
    private JButton viewAllButton;
    private JLabel totalCaloriesLabel;
    private JTextField totalCaloriesNumberField;
    private JTextArea infoTextArea;

    public DashBoard() {




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);  // center window
        setVisible(true);
        premierButto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentScreen paymentScreen = new PaymentScreen();
                paymentScreen.setContentPane(paymentScreen.payment);
                paymentScreen.setSize(700,600);
                paymentScreen.setVisible(true);
                dispose();

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
