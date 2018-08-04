package RestApi;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class CustomLogger {

    final Logger logger = Logger.getLogger(Main.class.getName());

    /** Set up a custom logger, with a custom formatter and rotating files
     *
     * @param logFile: the log file path
     * @param logLimit: specifies an approximate maximum amount to write (in bytes) to any one file
     * @param logCount:  specifies how many output files to cycle through
     */
    CustomLogger(String logFile, int logLimit, int logCount) {
        SimpleFormatter formatterTxt = new SimpleFormatter();
        try {
            FileHandler fileTxt = new FileHandler(logFile, logLimit, logCount);
            fileTxt.setFormatter(formatterTxt);
            logger.addHandler(fileTxt);
        } catch (IOException e) {
            logger.severe(String.format("Failed to define to custom logging tools \n Stacktrace: %s ", getStackTrace(e)));
        }

    }

    /** Function to call to get the stack trace of an exception in order to print it in a log file
     *
     * @param e: the exception
     * @return the stack trace of the exception
     */
    static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }


}
