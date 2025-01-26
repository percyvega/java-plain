package com.percyvega.experiments.operators.instanceof_app;

import lombok.extern.log4j.Log4j2;

@Log4j2
public
class AppInstanceof {

    public static void main(String[] args) throws InterruptedException {
        log.info("Starting main()");

        MyNumberRunnableClass myNumberRunnableClass = new MyNumberRunnableClass("3");
        Thread thread = new Thread(myNumberRunnableClass);
        thread.start();
        thread.join();

        MyNumberClass myNumberClass = new MyNumberClass("5");

        log.info("myNumberRunnableClass instanceof MyNumberClass: " + (myNumberRunnableClass instanceof MyNumberClass));
        log.info("myNumberRunnableClass instanceof MyRunnableInterface: " + (myNumberRunnableClass instanceof MyRunnableInterface));
        log.info("myNumberRunnableClass instanceof Number: " + (myNumberRunnableClass instanceof Number));
        log.info("myNumberRunnableClass instanceof Runnable: " + (myNumberRunnableClass instanceof Runnable));

        log.info("MyNumberClass instanceof Number: " + (myNumberClass instanceof Number));

        log.info("Finishing main()");
    }

}
