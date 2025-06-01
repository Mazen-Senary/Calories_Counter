// AnalysisPage.java
import javax.swing.*;

public class AnalysisPage extends JFrame {
    public AnalysisPage() {
        super("Analysis Page");
        setSize(400, 300);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Welcome to the Analysis Page!", SwingConstants.CENTER);
        add(label);
        setVisible(true);
    }
}
