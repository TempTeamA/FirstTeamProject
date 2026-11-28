package shared.logging;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;

public class FileLogger implements Logger, AutoCloseable {
	private final BufferedWriter writer;
	private final Logger logger;	
	private Path file;

    public FileLogger(Path file) {
		this.logger = new TimestampDecorator(new ModuleDecorator(new ConsoleLogger(), "Shared"));
		
		BufferedWriter tmpWriter = null;
		
        try {
            Path parent = file.getParent();
            this.file = file;
            
            if (parent != null) { Files.createDirectories(parent); }
            
            tmpWriter = Files.newBufferedWriter(
        		this.file,
        		StandardCharsets.UTF_8,
        		StandardOpenOption.CREATE,
        		StandardOpenOption.WRITE,
        		StandardOpenOption.APPEND
            );
        } catch (IOException e) {
        	this.logger.log(Level.FATAL, String.format("Не удалось инициализировать лог-файл (%s)%n", file));
        } catch (NullPointerException e) {
        	this.logger.log(Level.FATAL, String.format("Не удалось инициализировать лог-файл: Путь до файла не может иметь значение null%n", file));
        }
        
        this.writer = tmpWriter;
    }
    
	@Override
	public synchronized void log(Level level, String message) {
		String line = String.format("[%s] %s%n", level.toString(), message);
        try {
        	writer.write(line);
            writer.flush();   
        } catch (IOException e) {
        	this.logger.log(Level.FATAL, String.format("Не удалось произвести запись в лог-файл (%s)", file));
        }
	}
	
	@Override
    public synchronized void close() {
        if (writer == null) return;
        try {
            writer.close();
        } catch (IOException e) {
            this.logger.log(Level.FATAL, String.format("Не удалось закрыть лог-файл (%s)", file));
        }
    }
}
