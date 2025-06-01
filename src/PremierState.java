// PremierState.java
public class PremierState implements UserState {
    @Override
    public boolean canAccessAnalysis() {
        return true; // Premier users can access Analysis
    }

    @Override
    public String getStatusName() {
        return "Premier";
    }
}
