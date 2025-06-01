package data;
// LogEntry.java
 // Ensure your package declaration is correct

public class LogEntry {
    private String timestamp;
    private String message;
    private String level; // e.g., INFO, WARNING, ERROR

    public LogEntry(String timestamp, String message, String level) {
        this.timestamp = timestamp;
        this.message = message;
        this.level = level;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getLevel() {
        return level;
    }

    // This method represents the "incompatible interface" from the adaptee
    public void printToConsole() {
        System.out.println("[" + timestamp + "] " + level + ": " + message);
    }
}