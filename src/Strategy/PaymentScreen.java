
package Strategy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PaymentScreen extends JFrame {
    public JPanel payment;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField cardNumberField;
    private JTextField cvvField;
    private JRadioButton creditCardRadio;
    private JRadioButton paypalRadio;
    private JButton payButton;
    private ButtonGroup paymentMethodGroup;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel cardNumberLabel;
    private JLabel cvvLabel;
    private JLabel titleLabel;

    private PaymentContext paymentContext;
    private CreditCardPayment creditCardPayment;
    private PayPalPayment paypalPayment;

    public PaymentScreen() {
        super("Payment Screen - Strategy Pattern");

        initializeStrategies();
        createComponents();
        styleComponents();
        layoutComponents();
        addEventListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);  // center window
        setVisible(true);
    }

    private void initializeStrategies() {
        paymentContext = new PaymentContext();
        creditCardPayment = new CreditCardPayment();
        paypalPayment = new PayPalPayment();
        paymentContext.setPaymentStrategy(creditCardPayment); // default
    }

    private void createComponents() {
        nameField = new JTextField();
        emailField = new JTextField();
        cardNumberField = new JTextField();
        cvvField = new JTextField();

        creditCardRadio = new JRadioButton("Credit Card", true);
        paypalRadio = new JRadioButton("PayPal");
        paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(creditCardRadio);
        paymentMethodGroup.add(paypalRadio);

        payButton = new JButton("Pay");

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        cardNumberLabel = new JLabel("Card Number:");
        cvvLabel = new JLabel("CVV:");
        titleLabel = new JLabel("Payment Screen");
    }

    private void styleComponents() {
        getContentPane().setBackground(new Color(43, 45, 48));
        ((JComponent)getContentPane()).setBorder(new EmptyBorder(40, 40, 40, 40));

        styleTextField(nameField, "Enter your full name");
        styleTextField(emailField, "Enter your email address");
        styleTextField(cardNumberField, "1234 5678 9012 3456");
        styleTextField(cvvField, "123");

        styleRadioButton(creditCardRadio);
        styleRadioButton(paypalRadio);

        payButton.setBackground(new Color(0, 120, 215));
        payButton.setForeground(Color.WHITE);
        payButton.setFont(new Font("Arial", Font.BOLD, 16));
        payButton.setBorderPainted(false);
        payButton.setFocusPainted(false);
        payButton.setPreferredSize(new Dimension(200, 45));
        payButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        styleLabel(nameLabel);
        styleLabel(emailLabel);
        styleLabel(cardNumberLabel);
        styleLabel(cvvLabel);

        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        titleLabel.setForeground(new Color(223, 225, 229));
    }

    private void styleTextField(JTextField field, String placeholder) {
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 63, 65), 2),
                BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        field.setBackground(new Color(60, 63, 65));
        field.setForeground(Color.GRAY);
        field.setText(placeholder);
        field.setCaretColor(new Color(223, 225, 229));
        field.setPreferredSize(new Dimension(250, 40));

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(new Color(223, 225, 229));
                    field.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(new Color(0, 120, 215), 2),
                            BorderFactory.createEmptyBorder(12, 15, 12, 15)
                    ));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                    field.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(new Color(60, 63, 65), 2),
                            BorderFactory.createEmptyBorder(12, 15, 12, 15)
                    ));
                }
            }
        });
    }

    private void styleRadioButton(JRadioButton radio) {
        radio.setFont(new Font("Arial", Font.BOLD, 14));
        radio.setBackground(new Color(43, 45, 48));
        radio.setForeground(new Color(223, 225, 229));
        radio.setBorder(new EmptyBorder(10, 15, 10, 15));
        radio.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(223, 225, 229));
    }

    private void layoutComponents() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(titleLabel, gbc);

        gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.EAST;

        addLabeledField(nameLabel, nameField, gbc, 1, contentPane);
        addLabeledField(emailLabel, emailField, gbc, 2, contentPane);
        addLabeledField(cardNumberLabel, cardNumberField, gbc, 3, contentPane);
        addLabeledField(cvvLabel, cvvField, gbc, 4, contentPane);

        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setBackground(new Color(43, 45, 48));
        radioPanel.add(creditCardRadio);
        radioPanel.add(paypalRadio);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(radioPanel, gbc);

        gbc.gridy = 6;
        contentPane.add(payButton, gbc);
    }

    private void addLabeledField(JLabel label, JTextField field, GridBagConstraints gbc, int row, Container container) {
        gbc.gridx = 0; gbc.gridy = row; gbc.anchor = GridBagConstraints.EAST;
        container.add(label, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        container.add(field, gbc);
        gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0.0;
    }

    private void addEventListeners() {
        creditCardRadio.addActionListener(e -> {
            paymentContext.setPaymentStrategy(creditCardPayment);
            enableCardFields(true);
        });

        paypalRadio.addActionListener(e -> {
            paymentContext.setPaymentStrategy(paypalPayment);
            enableCardFields(false);
        });

        payButton.addActionListener(e -> processPayment());
    }

    private void enableCardFields(boolean enabled) {
        cardNumberField.setEnabled(enabled);
        cvvField.setEnabled(enabled);
        if (!enabled) {
            cardNumberField.setText("1234 5678 9012 3456");
            cardNumberField.setForeground(Color.GRAY);
            cvvField.setText("123");
            cvvField.setForeground(Color.GRAY);
        }
    }

    private void processPayment() {
        String name = getFieldText(nameField, "Enter your full name");
        String email = getFieldText(emailField, "Enter your email address");
        String cardNumber = getFieldText(cardNumberField, "1234 5678 9012 3456");
        String cvv = getFieldText(cvvField, "123");

        ValidationResult result = validateInput(name, email, cardNumber, cvv);
        if (!result.isValid()) {
            JOptionPane.showMessageDialog(this, result.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            paymentContext.pay(name, email, cardNumber, cvv);
            String method = creditCardRadio.isSelected() ? "Credit Card" : "PayPal";
            JOptionPane.showMessageDialog(this,
                    "Payment Successful!\nMethod: " + method + "\nName: " + name + "\nEmail: " + email,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Payment failed: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ValidationResult validateInput(String name, String email, String cardNumber, String cvv) {
        if (name.isEmpty()) return new ValidationResult(false, "Name is required.");
        if (email.isEmpty() || !email.contains("@")) return new ValidationResult(false, "Valid email is required.");
        if (creditCardRadio.isSelected()) {
            if (cardNumber.isEmpty() || !cardNumber.replaceAll("\\s", "").matches("\\d{16}"))
                return new ValidationResult(false, "Enter valid 16-digit card number.");
            if (cvv.isEmpty() || !cvv.matches("\\d{3,4}"))
                return new ValidationResult(false, "Enter valid 3-4 digit CVV.");
        }
        return new ValidationResult(true, "");
    }

    private String getFieldText(JTextField field, String placeholder) {
        String text = field.getText().trim();
        if (text.equals(placeholder)) return "";
        return text;
    }

    private void clearForm() {
        nameField.setText("Enter your full name");
        nameField.setForeground(Color.GRAY);
        emailField.setText("Enter your email address");
        emailField.setForeground(Color.GRAY);
        cardNumberField.setText("1234 5678 9012 3456");
        cardNumberField.setForeground(Color.GRAY);
        cvvField.setText("123");
        cvvField.setForeground(Color.GRAY);
        creditCardRadio.setSelected(true);
        enableCardFields(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ignored) {}

            new PaymentScreen(); // just create instance, constructor shows frame
        });
    }

    // Helper class for validation result
    private static class ValidationResult {
        private final boolean valid;
        private final String errorMessage;

        public ValidationResult(boolean valid, String errorMessage) {
            this.valid = valid;
            this.errorMessage = errorMessage;
        }

        public boolean isValid() {
            return valid;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}

