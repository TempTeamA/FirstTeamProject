package shared.logging.abstractions;

public abstract class LoggerDecorator implements Logger {
	protected final Logger wrapped;
	
	public LoggerDecorator(Logger wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public abstract void log(Level level, String message);
}
