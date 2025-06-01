public class AddCommand implements Command {
    private DashBoard dashboard;

    public AddCommand(DashBoard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void execute() {
        dashboard.addMeal();
    }
}
