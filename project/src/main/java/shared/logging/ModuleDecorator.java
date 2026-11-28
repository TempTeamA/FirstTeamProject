package shared.logging;

import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;
import shared.logging.abstractions.LoggerDecorator;

public class ModuleDecorator extends LoggerDecorator {
	private final String module;
	
	public ModuleDecorator(Logger wrapped, String module) { 
		super(wrapped); 
		this.module = module;
	}

	@Override
	public void log(Level level, String message) {
		this.wrapped.log(level, String.format("[%s] %s", module, message));
	}

}
