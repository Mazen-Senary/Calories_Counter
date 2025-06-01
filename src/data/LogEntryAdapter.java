package data;

// LogEntryAdapter.java
// Ensure your package declaration is correct

public class LogEntryAdapter implements Displayable {
    private LogEntry logEntry;

    public LogEntryAdapter(LogEntry logEntry) {
        this.logEntry = logEntry;
    }

    @Override
    public String getDisplayText() {
        // Adapt the LogEntry's data to the Displayable interface's format
        return "Time: " + logEntry.getTimestamp() +
                "\nLevel: " + logEntry.getLevel() +
                "\nMessage: " + logEntry.getMessage() + "\n---";
    }
}