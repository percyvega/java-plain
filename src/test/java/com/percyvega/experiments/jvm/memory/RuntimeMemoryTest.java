package com.percyvega.experiments.jvm.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeMemoryTest {

    private static final Logger logger = LoggerFactory.getLogger(RuntimeMemoryTest.class);

    @SuppressWarnings("unused")
    public void myMethod() {
        final long sizeMax = Runtime.getRuntime().maxMemory();
        logger.debug("sizeMax: " + sizeMax);
//		byte[] dataSizeMax = new byte[(int) sizeMax]; // throws error

        final long sizeTotal = Runtime.getRuntime().totalMemory();
        logger.debug("sizeTotal: " + sizeTotal);
        byte[] dataSizeTotal = new byte[(int) sizeTotal];

        final long sizeFree = Runtime.getRuntime().freeMemory();
        logger.debug("sizeFree: " + sizeFree);
        byte[] dataSizeFree = new byte[(int) sizeFree];


        final long sizeMax2 = Runtime.getRuntime().maxMemory();
        logger.debug("sizeMax2: " + sizeMax2);

        final long sizeTotal2 = Runtime.getRuntime().totalMemory();
        logger.debug("sizeTotal2: " + sizeTotal2);

        final long sizeFree2 = Runtime.getRuntime().freeMemory();
        logger.debug("sizeFree2: " + sizeFree2);
    }

    public static void main(String[] args) {
        RuntimeMemoryTest rmt = new RuntimeMemoryTest();
        rmt.myMethod();
    }

}