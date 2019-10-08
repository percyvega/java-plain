package com.percyvega.experiments.log4j;


import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;

@Log4j2
public class Log4jTest {

    private static final long SLEEP_FOR = 5_000L;

    public static void main(String[] args) {
        Log4jTest console = new Log4jTest();

        Thread thread = new Thread(() -> {
            while (true) {
                console.execute();
                try {
                    Thread.sleep(SLEEP_FOR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    private void execute() {
        log.log(Level.ALL, "A sample Level.ALL message.");
        log.trace("A sample Level.TRACE message.");
        log.debug("A sample Level.DEBUG message.");
        log.info("A sample Level.INFO message.");
        log.warn("A sample Level.WARN message.");
        log.error("A sample Level.ERROR message.");
        log.fatal("A sample Level.FATAL message.");
        log.log(Level.OFF, "A sample Level.OFF message.");

        printLevelEnabled(Level.ALL);
        printLevelEnabled(Level.TRACE);
        printLevelEnabled(Level.DEBUG);
        printLevelEnabled(Level.INFO);
        printLevelEnabled(Level.WARN);
        printLevelEnabled(Level.ERROR);
        printLevelEnabled(Level.FATAL);
        printLevelEnabled(Level.OFF);

        assert (log.isTraceEnabled() == log.isEnabled(Level.TRACE));
        assert (log.isDebugEnabled() == log.isEnabled(Level.DEBUG));
        assert (log.isInfoEnabled() == log.isEnabled(Level.INFO));
    }

    private void printLevelEnabled(final Level level) {
        String LEVEL_NAME = "Level." + level;
        String IS_ENABLED = " is enabled.";
        String IS_NOT_ENABLED = " is not enabled.";

        String message = LEVEL_NAME;
        if (log.isEnabled(level)) {
            message += IS_ENABLED;
        } else {
            message += IS_NOT_ENABLED;
        }

        log.log(Level.OFF, message);
    }

}