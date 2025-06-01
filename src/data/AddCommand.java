package data; // Corrected: Uses 'data' package

public class AddCommand extends Command {
    private DashBoard dashboard; // Ensure field is properly declared

    public AddCommand(DashBoard dashboard) {
        super();
        this.dashboard = dashboard;
    }

    @Override
    public void execute() {
        dashboard.addMeal();
    }
}