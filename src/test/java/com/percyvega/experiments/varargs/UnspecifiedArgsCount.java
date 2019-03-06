package com.percyvega.experiments.varargs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Date;

public class UnspecifiedArgsCount {

    private final static Logger logger = LoggerFactory.getLogger(UnspecifiedArgsCount.class);

    public static void main(String... args) {
        logger.debug("Starting main()");

        Integer planetNumber = 3;
        Date now = new Date();
        String eventDescription = new String("disturbance in the force");

        Object[] myStoryArgs = {planetNumber, now, eventDescription};

        String result1 = UnspecifiedArgsCount.getFullStory(myStoryArgs);
        String result2 = UnspecifiedArgsCount.getFullStory(planetNumber, now, eventDescription);

        logger.debug(result1);
        logger.debug(result2);

        logger.debug("Finishing main()");
    }

    private static String getFullStory(Object... myStoryArgs) {
        return MessageFormat.format("At {1, time, short} on {1, date, full}, there was a {2} on planet {0, number, integer} that cost {0, number, currency} ", myStoryArgs);
    }

}
