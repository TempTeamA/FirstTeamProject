package shared.logging.abstractions;

public enum Level {
	DEBUG, INFO, WARNING, FATAL;
	
	@Override
	public String toString() { return name(); }
}
