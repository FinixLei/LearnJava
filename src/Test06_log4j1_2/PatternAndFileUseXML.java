package Test06_log4j1_2;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class PatternAndFileUseXML {
    static Logger logger = Logger.getLogger(PatternAndFileUseXML.class);
    public static void main(String args[]) {
        DOMConfigurator.configure("src/Test06_log4j1_2/xmllog4jconfig.xml");
        logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");
    }
}
