package shared.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;
import shared.logging.abstractions.LoggerDecorator;

public class TimestampDecorator extends LoggerDecorator {
	private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public TimestampDecorator(Logger wrapped) { super(wrapped); }

	@Override
	public void log(Level level, String message) { 
		this.wrapped.log(level, String.format("%s | %s", LocalDateTime.now().format(FMT), message));
	}
}
