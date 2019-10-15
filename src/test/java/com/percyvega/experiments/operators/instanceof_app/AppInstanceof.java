package com.percyvega.experiments.operators.instanceof_app;

import lombok.extern.log4j.Log4j2;

@Log4j2
public
class AppInstanceof {


    public static void main(String[] args) throws InterruptedException {
        log.debug("Starting main()");

        MyNumberRunnableClass myNumberRunnableClass = new MyNumberRunnableClass("3");
        Thread thread = new Thread(myNumberRunnableClass);
        thread.start();
        thread.join();

        MyNumberClass myNumberClass = new MyNumberClass("5");

        log.debug("myNumberRunnableClass instanceof MyNumberClass: " + (myNumberRunnableClass instanceof MyNumberClass));
        log.debug("myNumberRunnableClass instanceof MyRunnableInterface: " + (myNumberRunnableClass instanceof MyRunnableInterface));
        log.debug("myNumberRunnableClass instanceof Number: " + (myNumberRunnableClass instanceof Number));
        log.debug("myNumberRunnableClass instanceof Runnable: " + (myNumberRunnableClass instanceof Runnable));

        log.debug("MyNumberClass instanceof Number: " + (myNumberClass instanceof Number));

        log.debug("Finishing main()");
    }

}
