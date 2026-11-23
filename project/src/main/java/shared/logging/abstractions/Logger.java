package shared.logging.abstractions;

public interface Logger {
    public void logInfo(String log);
    public void logWarning(String log);
    public void logFatal(String log);
}
