public class ViewCommand implements Command {
    private DashBoard dashboard;

    public ViewCommand(DashBoard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void execute() {
        dashboard.viewMeal();
    }
}
