package Test06_log4j1_2;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.FileAppender;

public class SimpleAndFile {
    static Logger logger = Logger.getLogger(SimpleAndFile.class);
    public static void main(String args[]) {
        SimpleLayout layout = new SimpleLayout();
        FileAppender appender = null;
        try {
            appender = new FileAppender(layout,"target/test_log4j_SimpleLayout_FileAppender.txt",false);
        } catch(Exception e) {
        }
        
        logger.addAppender(appender);
        logger.setLevel((Level) Level.DEBUG);
        logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");
    }
}