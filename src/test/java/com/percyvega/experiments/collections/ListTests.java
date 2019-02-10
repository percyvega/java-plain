package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ListTests {

    private static final BibleReference GENESIS_1_1 = new BibleReference("Genesis", 1, 1);
    private static final BibleReference EXODUS_1_1 = new BibleReference("Exodus", 1, 1);
    private static final BibleReference LEVITICUS_1_1 = new BibleReference("Leviticus", 1, 1);
    private static final BibleReference NUMBERS_1_1 = new BibleReference("Numbers", 1, 1);
    private static final BibleReference DEUTERONOMY_1_1 = new BibleReference("Deuteronomy", 1, 1);
    private static final BibleReference REVELATION_1_1 = new BibleReference("Revelation", 1, 1);
    private static final BibleReference REVELATION_22_21 = new BibleReference("Revelation", 22, 21);

}
