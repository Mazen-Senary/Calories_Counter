////import javax.swing.*;
////import java.awt.*;
////import java.util.Map;
////
////public class DashBoard extends JFrame {
////    public JPanel Dash;
////    private JLabel welcomeLabel;
////    private JLabel instructionLabel;
////    private JTextField mealInputField;
////    private JButton deleteButton;
////    private JButton addButton;
////    private JButton viewAllButton;
////    private JLabel totalCaloriesLabel;
////    private JTextField totalCaloriesNumberField;
////    private JTextArea infoTextArea;
////    private JButton premierButto; // optional if used in form
////
////    public DashBoard() {
////        setTitle("Meal Nutrition Dashboard");
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        setContentPane(Dash);  // set content pane from the form
////        setSize(600, 700);
////        setLocationRelativeTo(null);
////        setVisible(true);
////
////        addButton.addActionListener(e -> showNutritionInfo());
////        viewAllButton.addActionListener(e -> showNutritionInfo());
////        deleteButton.addActionListener(e -> {
////            mealInputField.setText("");
////            infoTextArea.setText("");
////            totalCaloriesNumberField.setText("");
////        });
////    }
////
////    private void showNutritionInfo() {
////        String mealName = mealInputField.getText().trim();
////
////        if (mealName.isEmpty()) {
////            JOptionPane.showMessageDialog(this, "Please enter a meal name.");
////            return;
////        }
////
////        FoodInfo caloriesInfo = new CaloriesInfo(mealName);
////        FoodInfo proteinDecorator = new ProteinDecorator(caloriesInfo, mealName);
////        FoodInfo fatDecorator = new FatDecorator(proteinDecorator, mealName);
////
////        String details = fatDecorator.getNutritionDetails();
////        infoTextArea.setText(details);
////
////        NutritionData data = CaloriesInfo.nutritionDB.get(mealName);
////        if (data != null) {
////            totalCaloriesNumberField.setText(String.valueOf(data.calories));
////        } else {
////            totalCaloriesNumberField.setText("N/A");
////        }
////    }
////
////    public static void main(String[] args) {
////        SwingUtilities.invokeLater(DashBoard::new);
////    }
////}
//
//
//
//import Strategy.PaymentScreen;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class DashBoard extends JFrame {
//    public JPanel Dash;
//    private JLabel welcomeLabel;
//    private JLabel instructionLabel;
//    private JTextField mealInputField;
//    private JButton deleteButton;
//    private JButton addButton;
//    private JButton viewAllButton;
//    private JLabel totalCaloriesLabel;
//    private JTextField totalCaloriesNumberField;
//    private JTextArea infoTextArea;
//    private JButton premierButto;
//    private JButton AnalsysButton;
//    private JButton LogOutButton;
//
//    // Command objects
//    private Command addCommand;
//    private Command viewCommand;
//    private Command deleteCommand;
//
//    public DashBoard() {
//        setTitle("Meal Nutrition Dashboard");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setContentPane(Dash);  // Linked to .form GUI layout
//        setSize(600, 700);
//        setLocationRelativeTo(null);
//        setVisible(true);
//
//        // Initialize commands and pass reference of this DashBoard (receiver)
//        addCommand = new AddCommand(this);
//        viewCommand = new ViewCommand(this);
//        deleteCommand = new DeleteCommand(this);
//
//        // Connect commands to buttons
//        addButton.addActionListener(e -> addCommand.execute());
//        viewAllButton.addActionListener(e -> viewCommand.execute());
//        deleteButton.addActionListener(e -> deleteCommand.execute());
//        premierButto.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PaymentScreen p = new PaymentScreen();
//            }
//        });
//    }
//
//    // Called by command classes
//    public void addMeal() {
//        showNutritionInfo();  // You can enhance this to "save" meal separately
//    }
//
//    public void viewMeal() {
//        showNutritionInfo();
//    }
//
//    public void deleteMeal() {
//        mealInputField.setText("");
//        infoTextArea.setText("");
//        totalCaloriesNumberField.setText("");
//    }
//
//    private void showNutritionInfo() {
//        String mealName = mealInputField.getText().trim();
//
//        if (mealName.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter a meal name.");
//            return;
//        }
//
//        FoodInfo caloriesInfo = new CaloriesInfo(mealName);
//        FoodInfo proteinDecorator = new ProteinDecorator(caloriesInfo, mealName);
//        FoodInfo fatDecorator = new FatDecorator(proteinDecorator, mealName);
//
//        String details = fatDecorator.getNutritionDetails();
//        infoTextArea.setText(details);
//
//        NutritionData data = CaloriesInfo.nutritionDB.get(mealName);
//        if (data != null) {
//            totalCaloriesNumberField.setText(String.valueOf(data.calories));
//        } else {
//            totalCaloriesNumberField.setText("N/A");
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(DashBoard::new);
//    }
//}
//
//




import javax.swing.*;

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
    private JButton premierButto;
    private JButton AnalsysButton;
    private JButton LogOutButton;

    // New components for user status
    private JLabel statusLabel;

    // Command objects
    private Command addCommand;
    private Command viewCommand;
    private Command deleteCommand;

    // User and proxy fields
    private UserS user;
    private AnalysisAccessProxy analysisProxy;

    public DashBoard() {
        setTitle("Meal Nutrition Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Dash);  // Linked to .form GUI layout
        setSize(600, 700);
        setLocationRelativeTo(null);

        // Initialize user and proxy
        user = new UserS();  // or pass as parameter if needed
        analysisProxy = new AnalysisAccessProxy(user);

        // Add user status label to GUI (below or above existing controls)
        statusLabel = new JLabel("User status: " + user.getStatusName());
        // Add the statusLabel to your existing panel/layout (example with FlowLayout)
        Dash.add(statusLabel);

        setVisible(true);

        // Initialize commands and pass reference of this DashBoard (receiver)
        addCommand = new AddCommand(this);
        viewCommand = new ViewCommand(this);
        deleteCommand = new DeleteCommand(this);

        // Connect commands to buttons
        addButton.addActionListener(e -> addCommand.execute());
        viewAllButton.addActionListener(e -> viewCommand.execute());
        deleteButton.addActionListener(e -> deleteCommand.execute());

        // Payment button opens payment screen
        premierButto.addActionListener(e -> new PaymentScreen());

        // Analysis button action using proxy
        AnalsysButton.addActionListener(e -> analysisProxy.accessAnalysis(this));
    }

    // Called by command classes
    public void addMeal() {
        showNutritionInfo();  // You can enhance this to "save" meal separately
    }

    public void viewMeal() {
        showNutritionInfo();
    }

    public void deleteMeal() {
        mealInputField.setText("");
        infoTextArea.setText("");
        totalCaloriesNumberField.setText("");
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

