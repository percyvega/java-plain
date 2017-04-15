package com.percyvega.experiments.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {

    private static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        Log4jTest console = new Log4jTest();
        console.execute();
    }

    public Log4jTest() {
        LOGGER.log(Level.ALL, "ALL level message.");
        if (LOGGER.isEnabledFor(Level.ALL)) {
            LOGGER.log(Level.ALL, "ALL level is enabled.");
        }
        LOGGER.trace("TRACE level message.");
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("TRACE level is enabled.");
        }
        LOGGER.debug("DEBUG level message.");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("DEBUG level is enabled.");
        }
    }

    public void execute() {
        LOGGER.info("INFO level message.");
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("INFO level is enabled.");
        }
        LOGGER.warn("WARN level message.");
        if (LOGGER.isEnabledFor(Level.WARN)) {
            LOGGER.warn("WARN level is enabled.");
        }
        LOGGER.error("ERROR level message.");
        if (LOGGER.isEnabledFor(Level.ERROR)) {
            LOGGER.error("ERROR level is enabled.");
        }
        LOGGER.fatal("FATAL level message.");
        if (LOGGER.isEnabledFor(Level.FATAL)) {
            LOGGER.fatal("FATAL level is enabled.");
        }
        LOGGER.log(Level.OFF, "OFF level message.");
        if (LOGGER.isEnabledFor(Level.OFF)) {
            LOGGER.log(Level.OFF, "OFF level is enabled.");
        }
    }

}