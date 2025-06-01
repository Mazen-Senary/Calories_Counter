import javax.swing.*;

public class AnalysisAccessProxy {
    private UserS user;

    public AnalysisAccessProxy(UserS user) {
        this.user = user;
    }

    public void accessAnalysis(JFrame parentFrame) {
        if (user.canAccessAnalysis()) {
            new AnalysisPage();
        } else {
            int option = JOptionPane.showConfirmDialog(parentFrame,
                    "Access Denied. You must be a Premier user to view the Analysis.\n" +
                            "Would you like to upgrade to Premier?",
                    "Access Denied",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                new PaymentScreen(user, parentFrame);

            } else {
                JOptionPane.showMessageDialog(parentFrame,
                        "You need Premier status to access Analysis.",
                        "Access Denied",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
