package com.percyvega.experiments.jvm.memory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RuntimeMemoryTest {

    public static void main(String[] args) {
        RuntimeMemoryTest rmt = new RuntimeMemoryTest();
        rmt.myMethod();
    }

    @SuppressWarnings("unused")
    public void myMethod() {
        final long sizeMax = Runtime.getRuntime().maxMemory();
        log.info("sizeMax: " + sizeMax);
//		byte[] dataSizeMax = new byte[(int) sizeMax]; // throws error

        final long sizeTotal = Runtime.getRuntime().totalMemory();
        log.info("sizeTotal: " + sizeTotal);
        byte[] dataSizeTotal = new byte[(int) sizeTotal];

        final long sizeFree = Runtime.getRuntime().freeMemory();
        log.info("sizeFree: " + sizeFree);
        byte[] dataSizeFree = new byte[(int) sizeFree];


        final long sizeMax2 = Runtime.getRuntime().maxMemory();
        log.info("sizeMax2: " + sizeMax2);

        final long sizeTotal2 = Runtime.getRuntime().totalMemory();
        log.info("sizeTotal2: " + sizeTotal2);

        final long sizeFree2 = Runtime.getRuntime().freeMemory();
        log.info("sizeFree2: " + sizeFree2);
    }

}
