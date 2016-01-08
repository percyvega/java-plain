package com.percyvega.experiments.operators.instanceof_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyNumberRunnableClass extends MyNumberClass implements MyRunnableInterface {

    private final static Logger logger = LoggerFactory.getLogger(MyNumberRunnableClass.class);

    public MyNumberRunnableClass(String value) {
        super(value);
    }

    @Override
    public void run() {
        logger.debug("Starting run()");

        int intValue = intValue();
        for (int i = 1; i <= intValue; i++) {
            logger.debug("#{} of {}", i, intValue);
        }

        logger.debug("Finishing run()");
    }
}
