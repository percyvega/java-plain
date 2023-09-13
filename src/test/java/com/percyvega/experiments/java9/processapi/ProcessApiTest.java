package com.percyvega.experiments.java9.processapi;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class ProcessApiTest {

    @Test
    void test() {
        ProcessHandle processHandle = ProcessHandle.current();
        long pid = processHandle.pid();
        log.info(pid);
        ProcessHandle.Info info = processHandle.info();
        log.info(info.toString().replace(", ", ",\n"));
    }

}
