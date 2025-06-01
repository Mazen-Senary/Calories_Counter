package data;

public abstract class Command {
    public Command(DashBoard dashBoard) {
    }

    public Command() {

    }

    public abstract void execute();
}
