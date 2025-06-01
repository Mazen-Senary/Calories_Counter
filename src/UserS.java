public class UserS {
    private UserState state;

    public UserS() {
        this.state = new RegularState(); // default
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public UserState getState() {
        return this.state;
    }

    public boolean canAccessAnalysis() {
        return state.canAccessAnalysis();
    }

    public String getStatusName() {
        return state.getStatusName();
    }
}
