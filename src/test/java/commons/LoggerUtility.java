package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger = LogManager.getLogger();


    public static void infoTest(String message) {
        logger.info(message);
    }

}
