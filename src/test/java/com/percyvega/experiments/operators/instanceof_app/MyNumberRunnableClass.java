package com.percyvega.experiments.operators.instanceof_app;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyNumberRunnableClass extends MyNumberClass implements MyRunnableInterface {

    public MyNumberRunnableClass(String value) {
        super(value);
    }

    @Override
    public void run() {
        log.debug("Starting run()");

        int intValue = intValue();
        for (int i = 1; i <= intValue; i++) {
            log.debug("#{} of {}", i, intValue);
        }

        log.debug("Finishing run()");
    }
}
