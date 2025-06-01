import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DashBoard extends JFrame {
    public JPanel Dash;
    private JLabel welcomeLabel;
    private JLabel instructionLabel;
    private JTextField mealInputField;
    private JButton deleteButton;
    private JButton addButton;
    private JButton viewAllButton;
    private JLabel totalCaloriesLabel;
    private JTextField totalCaloriesNumberField;
    private JTextArea infoTextArea;
    private JButton premierButto; // optional if used in form

    public DashBoard() {
        setTitle("Meal Nutrition Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Dash);  // set content pane from the form
        setSize(600, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        addButton.addActionListener(e -> showNutritionInfo());
        viewAllButton.addActionListener(e -> showNutritionInfo());
        deleteButton.addActionListener(e -> {
            mealInputField.setText("");
            infoTextArea.setText("");
            totalCaloriesNumberField.setText("");
        });
    }

    private void showNutritionInfo() {
        String mealName = mealInputField.getText().trim();

        if (mealName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a meal name.");
            return;
        }

        FoodInfo caloriesInfo = new CaloriesInfo(mealName);
        FoodInfo proteinDecorator = new ProteinDecorator(caloriesInfo, mealName);
        FoodInfo fatDecorator = new FatDecorator(proteinDecorator, mealName);

        String details = fatDecorator.getNutritionDetails();
        infoTextArea.setText(details);

        NutritionData data = CaloriesInfo.nutritionDB.get(mealName);
        if (data != null) {
            totalCaloriesNumberField.setText(String.valueOf(data.calories));
        } else {
            totalCaloriesNumberField.setText("N/A");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashBoard::new);
    }
}
