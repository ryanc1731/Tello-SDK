package tello;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

// Main class contains the method main(), which is what Java JRE 
// calls to begin execution when a Java program is run.
public class Main 
{
	// Get references to Java's built-in logging classes.
	private static final Logger 		logger = Logger.getGlobal();
	private static final ConsoleHandler handler = new ConsoleHandler();

	// Main always called to start a Java program.
	public static void main(String[] args) throws Exception 
	{
		// Configure global logger for console logging.
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
		
		// Set default logging level to a bit more detailed than INFO. Logging
		// statements at or above the set logging level will be output to
		// the console window. INFO level is typically used to show high
		// level informational messages. FINE is for logging of more detail, FINER
		// for logging a lot of detail. Due to a quirk in the design of the Java
		// logger, we have to set the desired log level in both the logger and 
		// handler instances. The logger is used by the calling program to create
		// log messages and the handler is used by the logger to send log messages
		// to a destination (like the console or a file).
		
	  	logger.setLevel(Level.FINE);
		handler.setLevel(Level.FINE);

	    logger.info("start");
	    
	    // Create an instance of the drone program (class) we want to run.
	    
	    Demo1 demo = new Demo1();


	    demo.execute();
	    
	    logger.info("end");
	}
}