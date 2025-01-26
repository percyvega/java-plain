package com.percyvega.experiments.operators.instanceof_app;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyNumberRunnableClass extends MyNumberClass implements MyRunnableInterface {

    public MyNumberRunnableClass(String value) {
        super(value);
    }

    @Override
    public void run() {
        log.info("Starting run()");

        int intValue = intValue();
        for (int i = 1; i <= intValue; i++) {
            log.info("#{} of {}", i, intValue);
        }

        log.info("Finishing run()");
    }
}
