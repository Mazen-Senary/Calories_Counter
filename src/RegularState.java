// RegularState.java
public class RegularState implements UserState {
    @Override
    public boolean canAccessAnalysis() {
        return false; // Regular users cannot access Analysis
    }

    @Override
    public String getStatusName() {
        return "Regular";
    }
}
