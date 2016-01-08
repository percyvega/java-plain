package com.percyvega.experiments.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Log4jTest console = new Log4jTest();
        console.execute();
    }

    public Log4jTest() {
        logger.log(Level.ALL, "ALL level message.");
        if (logger.isEnabledFor(Level.ALL)) {
            logger.trace("ALL level enabled.");
        }
        logger.trace("TRACE level message.");
        if (logger.isTraceEnabled()) {
            logger.trace("TRACE level enabled.");
        }
        logger.debug("DEBUG level message.");
        if (logger.isDebugEnabled()) {
            logger.debug("DEBUG level enabled.");
        }
    }

    public void execute() {
        logger.info("INFO level message.");
        if (logger.isInfoEnabled()) {
            logger.info("INFO level enabled.");
        }
        logger.warn("WARN level message.");
        if (logger.isEnabledFor(Level.WARN)) {
            logger.warn("WARN level enabled.");
        }
        logger.error("ERROR level message.");
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.error("ERROR level enabled.");
        }
        logger.fatal("FATAL level message.");
        if (logger.isEnabledFor(Level.FATAL)) {
            logger.fatal("FATAL level enabled.");
        }
    }

}