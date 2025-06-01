public class DeleteCommand implements Command {
    private DashBoard dashboard;

    public DeleteCommand(DashBoard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void execute() {
        dashboard.deleteMeal();
    }
}
