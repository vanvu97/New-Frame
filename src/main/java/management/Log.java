package management;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log {

//    System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");
    private static final Logger log = LogManager.getLogger(Log.class);

    public static void info(String message) {
        log.info(message);
    }
    public static void warn(String message) {
        log.warn(message);
    }
    public static void error(String message) {
        log.error(message);
    }
    public static void fatal(String message) {
        log.fatal(message);
    }
    public static void debug(String message) {
        log.debug(message);
    }


}
