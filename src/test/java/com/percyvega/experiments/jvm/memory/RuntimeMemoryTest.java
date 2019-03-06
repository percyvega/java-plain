package com.percyvega.experiments.jvm.memory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RuntimeMemoryTest {

    @SuppressWarnings("unused")
    public void myMethod() {
        final long sizeMax = Runtime.getRuntime().maxMemory();
        log.debug("sizeMax: " + sizeMax);
//		byte[] dataSizeMax = new byte[(int) sizeMax]; // throws error

        final long sizeTotal = Runtime.getRuntime().totalMemory();
        log.debug("sizeTotal: " + sizeTotal);
        byte[] dataSizeTotal = new byte[(int) sizeTotal];

        final long sizeFree = Runtime.getRuntime().freeMemory();
        log.debug("sizeFree: " + sizeFree);
        byte[] dataSizeFree = new byte[(int) sizeFree];


        final long sizeMax2 = Runtime.getRuntime().maxMemory();
        log.debug("sizeMax2: " + sizeMax2);

        final long sizeTotal2 = Runtime.getRuntime().totalMemory();
        log.debug("sizeTotal2: " + sizeTotal2);

        final long sizeFree2 = Runtime.getRuntime().freeMemory();
        log.debug("sizeFree2: " + sizeFree2);
    }

    public static void main(String[] args) {
        RuntimeMemoryTest rmt = new RuntimeMemoryTest();
        rmt.myMethod();
    }

}