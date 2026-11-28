package shared.logging;

import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;

public class ConsoleLogger implements Logger {
	@Override
	public void log(Level level, String message) {
		System.out.printf("[%s] %s %n", level.toString(), message);
	}
}
