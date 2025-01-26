package com.percyvega.experiments.varargs;

import lombok.extern.log4j.Log4j2;

import java.text.MessageFormat;
import java.util.Date;

@Log4j2
public class UnspecifiedArgsCount {


    public static void main(String... args) {
        log.info("Starting main()");

        Integer planetNumber = 3;
        Date now = new Date();
        String eventDescription = "disturbance in the force";

        Object[] myStoryArgs = {planetNumber, now, eventDescription};

        String result1 = UnspecifiedArgsCount.getFullStory(myStoryArgs);
        String result2 = UnspecifiedArgsCount.getFullStory(planetNumber, now, eventDescription);

        log.info(result1);
        log.info(result2);

        log.info("Finishing main()");
    }

    private static String getFullStory(Object... myStoryArgs) {
        return MessageFormat.format("At {1, time, short} on {1, date, full}, there was a {2} on planet {0, number, integer} that cost {0, number, currency} ", myStoryArgs);
    }

}
