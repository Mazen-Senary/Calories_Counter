package data; // Corrected: Uses 'data' package

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// Corrected imports for classes within your project's 'data' package
import data.NutritionFacade;
import data.Command;
import data.UserS;
import data.AnalysisAccessProxy;
import data.PaymentScreen;
import data.ViewHistoryScreen;
import data.AddCommand; // Explicitly import Command implementations
import data.ViewCommand; // Explicitly import Command implementations
import data.DeleteCommand; // Explicitly import Command implementations


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
    private JLabel statusLabel;
    private Command addCommand;
    private Command viewCommand;
    private Command deleteCommand;
    private UserS user;
    private AnalysisAccessProxy analysisProxy;
    private NutritionFacade nutritionFacade;
    private JButton viewLogHistoryButton;

    public DashBoard() {
        this.$$$setupUI$$$();

        this.setTitle("Meal Nutrition Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.Dash);
        this.setSize(600, 700);
        this.setLocationRelativeTo((Component)null);

        this.user = new UserS();
        this.analysisProxy = new AnalysisAccessProxy(this.user);
        this.statusLabel = new JLabel("User status: " + this.user.getStatusName());
        this.Dash.add(this.statusLabel, BorderLayout.NORTH);

        this.setVisible(true);

        this.nutritionFacade = new NutritionFacade();

        this.addCommand = new Command(this) {
            @Override
            public void execute() {

            }
        };
        this.viewCommand = new ViewCommand(this) {
            @Override
            public void execute() {

            }
        };
        this.deleteCommand = new DeleteCommand(this);

        this.addButton.addActionListener((e) -> this.addCommand.execute());
        this.viewAllButton.addActionListener((e) -> this.viewCommand.execute());
        this.deleteButton.addActionListener((e) -> this.deleteCommand.execute());
        this.premierButto.addActionListener((e) -> new PaymentScreen());
        this.AnalsysButton.addActionListener((e) -> this.analysisProxy.accessAnalysis(this));

        this.viewLogHistoryButton = new JButton("View Log History");
        this.viewLogHistoryButton.addActionListener(e -> {
            new ViewHistoryScreen();
        });
        this.Dash.add(this.viewLogHistoryButton, BorderLayout.SOUTH);
    }

    public void addMeal() {
        this.showNutritionInfo();
    }

    public void viewMeal() {
        this.showNutritionInfo();
    }

    public void deleteMeal() {
        this.mealInputField.setText("");
        this.infoTextArea.setText("");
        this.totalCaloriesNumberField.setText("");
    }

    private void showNutritionInfo() {
        String mealName = this.mealInputField.getText().trim();
        if (mealName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a meal name.");
        } else {
            String details = this.nutritionFacade.getComprehensiveMealDetails(mealName);
            this.infoTextArea.setText(details);

            int totalCalories = this.nutritionFacade.getMealCalories(mealName);
            if (totalCalories != -1) {
                this.totalCaloriesNumberField.setText(String.valueOf(totalCalories));
            } else {
                this.totalCaloriesNumberField.setText("N/A");
            }
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                // Ignore
            }
        }

        SwingUtilities.invokeLater(DashBoard::new);
    }

    private void $$$setupUI$$$() {
        Dash = new JPanel();
        Dash.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        welcomeLabel = new JLabel("Welcome to your Calorie Tracker!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        instructionLabel = new JLabel("Enter meal name:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        topPanel.add(welcomeLabel);
        topPanel.add(instructionLabel);

        JPanel inputActionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        mealInputField = new JTextField(20);
        mealInputField.setPreferredSize(new Dimension(200, 30));
        addButton = new JButton("Add Meal");
        deleteButton = new JButton("Delete Meal");
        viewAllButton = new JButton("View All Meals");
        premierButto = new JButton("Upgrade to Premier");
        AnalsysButton = new JButton("View Analysis");
        LogOutButton = new JButton("Log Out");

        inputActionPanel.add(mealInputField);
        inputActionPanel.add(addButton);
        inputActionPanel.add(deleteButton);
        inputActionPanel.add(viewAllButton);
        inputActionPanel.add(premierButto);
        inputActionPanel.add(AnalsysButton);
        inputActionPanel.add(LogOutButton);

        JPanel infoDisplayPanel = new JPanel(new BorderLayout(5, 5));
        totalCaloriesLabel = new JLabel("Total Calories:");
        totalCaloriesNumberField = new JTextField(10);
        totalCaloriesNumberField.setEditable(false);
        infoTextArea = new JTextArea(10, 30);
        infoTextArea.setEditable(false);
        JScrollPane infoScrollPane = new JScrollPane(infoTextArea);

        JPanel caloriesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        caloriesPanel.add(totalCaloriesLabel);
        caloriesPanel.add(totalCaloriesNumberField);

        infoDisplayPanel.add(caloriesPanel, BorderLayout.NORTH);
        infoDisplayPanel.add(infoScrollPane, BorderLayout.CENTER);

        Dash.add(topPanel, BorderLayout.NORTH);
        Dash.add(inputActionPanel, BorderLayout.CENTER);
        Dash.add(infoDisplayPanel, BorderLayout.EAST);
    }
}