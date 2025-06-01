import javax.swing.*;

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
    private JButton LogOutButton;
    private JTextArea textArea1;

    public DashBoard() {




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);  // center window
        setVisible(true);
    }
}
