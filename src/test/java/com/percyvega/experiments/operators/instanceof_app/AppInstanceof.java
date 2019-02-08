package com.percyvega.experiments.operators.instanceof_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppInstanceof {

    private final static Logger logger = LoggerFactory.getLogger(AppInstanceof.class);

    public static void main(String[] args) throws InterruptedException {
        logger.debug("Starting main()");

        MyNumberRunnableClass myNumberRunnableClass = new MyNumberRunnableClass("3");
        Thread thread = new Thread(myNumberRunnableClass);
        thread.start();
        thread.join();

        MyNumberClass myNumberClass = new MyNumberClass("5");

        logger.debug("myNumberRunnableClass instanceof MyNumberClass: " + (myNumberRunnableClass instanceof MyNumberClass));
        logger.debug("myNumberRunnableClass instanceof MyRunnableInterface: " + (myNumberRunnableClass instanceof MyRunnableInterface));
        logger.debug("myNumberRunnableClass instanceof Number: " + (myNumberRunnableClass instanceof Number));
        logger.debug("myNumberRunnableClass instanceof Runnable: " + (myNumberRunnableClass instanceof Runnable));

        logger.debug("MyNumberClass instanceof Number: " + (myNumberClass instanceof Number));

        logger.debug("Finishing main()");
    }

}
