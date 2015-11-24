package Test06_log4j1_2;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

public class PatternAndConsole {
    static Logger logger = Logger.getLogger(PatternAndConsole.class);
    public static void main(String args[]) {
        // Note, %n is newline
        String pattern = "Milliseconds since program start: %r %n";
        pattern += "Classname of caller: %C %n";
        pattern += "Date in ISO8601 format: %d{ISO8601} %n";
        pattern += "Location of log event: %l %n";
        pattern += "Message: %m %n %n";
        PatternLayout layout = new PatternLayout(pattern);
        
        ConsoleAppender appender = new ConsoleAppender(layout);
        logger.addAppender(appender);
        logger.setLevel((Level) Level.DEBUG);
        logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");
    }
}

/*
 *  Milliseconds since program start: 0 
    Classname of caller: Test06_log4j.PatternAndConcole 
    Date in ISO8601 format: 2015-09-19 22:50:23,659 
    Location of log event: Test06_log4j.PatternAndConcole.main(PatternAndConcole.java:22) 
    Message: Here is some DEBUG 
     
    Milliseconds since program start: 11 
    Classname of caller: Test06_log4j.PatternAndConcole 
    Date in ISO8601 format: 2015-09-19 22:50:23,670 
    Location of log event: Test06_log4j.PatternAndConcole.main(PatternAndConcole.java:23) 
    Message: Here is some INFO 
     
    Milliseconds since program start: 11 
    Classname of caller: Test06_log4j.PatternAndConcole 
    Date in ISO8601 format: 2015-09-19 22:50:23,670 
    Location of log event: Test06_log4j.PatternAndConcole.main(PatternAndConcole.java:24) 
    Message: Here is some WARN 
     
    Milliseconds since program start: 11 
    Classname of caller: Test06_log4j.PatternAndConcole 
    Date in ISO8601 format: 2015-09-19 22:50:23,670 
    Location of log event: Test06_log4j.PatternAndConcole.main(PatternAndConcole.java:25) 
    Message: Here is some ERROR 
     
    Milliseconds since program start: 11 
    Classname of caller: Test06_log4j.PatternAndConcole 
    Date in ISO8601 format: 2015-09-19 22:50:23,670 
    Location of log event: Test06_log4j.PatternAndConcole.main(PatternAndConcole.java:26) 
    Message: Here is some FATAL 
*/
