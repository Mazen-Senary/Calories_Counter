package data;

// ViewHistoryScreen.java
// Ensure your package declaration is correct

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ViewHistoryScreen extends JFrame {
    private JTextArea logDisplayArea;
    private JButton refreshButton;

    // In a real application, these logs would come from a persistent log manager
    // or a database, not hardcoded. This is for demonstration.
    private List<LogEntry> mockLogEntries = new ArrayList<>();

    public ViewHistoryScreen() {
        super("View History Screen (Adapter Pattern Demo)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this window, not the whole app
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Mock some log entries for demonstration purposes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        mockLogEntries.add(new LogEntry(LocalDateTime.now().minusHours(2).format(formatter), "User 'JohnDoe' logged in.", "INFO"));
        mockLogEntries.add(new LogEntry(LocalDateTime.now().minusHours(1).format(formatter), "Meal 'Chicken Salad' added.", "INFO"));
        mockLogEntries.add(new LogEntry(LocalDateTime.now().minusMinutes(30).format(formatter), "Attempted access to analysis by 'RegularUser'.", "WARNING"));
        mockLogEntries.add(new LogEntry(LocalDateTime.now().format(formatter), "User 'JaneDoe' upgraded to Premier.", "INFO"));

        JPanel panel = new JPanel(new BorderLayout());
        logDisplayArea = new JTextArea();
        logDisplayArea.setEditable(false);
        logDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(logDisplayArea);

        refreshButton = new JButton("Refresh Logs");
        refreshButton.addActionListener(e -> displayLogs());

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(refreshButton, BorderLayout.SOUTH);

        add(panel);
        displayLogs(); // Display logs on initial load
        setVisible(true);
    }

    private void displayLogs() {
        logDisplayArea.setText(""); // Clear previous logs
        for (LogEntry entry : mockLogEntries) {
            // Use the LogEntryAdapter to get the formatted text for display
            Displayable adaptedLog = new LogEntryAdapter(entry);
            logDisplayArea.append(adaptedLog.getDisplayText() + "\n\n");
        }
    }

    // Main method for standalone testing of this screen
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewHistoryScreen::new);
    }
}