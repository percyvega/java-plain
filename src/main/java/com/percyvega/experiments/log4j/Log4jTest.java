package com.percyvega.experiments.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {

    private static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        Log4jTest console = new Log4jTest();

        Thread thread = new Thread(() -> {
            while (true) {
                console.execute();
                try {
                    Thread.sleep(10_000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    private void execute() {
        LOGGER.log(Level.ALL, "A sample Level.ALL message.");
        LOGGER.trace("A sample Level.TRACE message.");
        LOGGER.debug("A sample Level.DEBUG message.");
        LOGGER.info("A sample Level.INFO message.");
        LOGGER.warn("A sample Level.WARN message.");
        LOGGER.error("A sample Level.ERROR message.");
        LOGGER.fatal("A sample Level.FATAL message.");
        LOGGER.log(Level.OFF, "A sample Level.OFF message.");

        LOGGER.log(Level.OFF, null);

        printLevelEnabled(Level.ALL);
        printLevelEnabled(Level.TRACE);
        printLevelEnabled(Level.DEBUG);
        printLevelEnabled(Level.INFO);
        printLevelEnabled(Level.WARN);
        printLevelEnabled(Level.ERROR);
        printLevelEnabled(Level.FATAL);
        printLevelEnabled(Level.OFF);

        assert (LOGGER.isTraceEnabled() == LOGGER.isEnabledFor(Level.TRACE));
        assert (LOGGER.isDebugEnabled() == LOGGER.isEnabledFor(Level.DEBUG));
        assert (LOGGER.isInfoEnabled() == LOGGER.isEnabledFor(Level.INFO));
    }

    private void printLevelEnabled(final Level level) {
        String LEVEL_NAME = "Level." + level;
        String IS_ENABLED = " is enabled.";
        String IS_NOT_ENABLED = " is not enabled.";

        String message = LEVEL_NAME;
        if (LOGGER.isEnabledFor(level)) {
            message += IS_ENABLED;
        } else {
            message += IS_NOT_ENABLED;
        }

        LOGGER.log(Level.OFF, message);
    }

}