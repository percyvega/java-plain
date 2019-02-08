package com.percyvega.experiments.collections;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class ListTests {

    @Test
    public void useLists() {
        List<String> places1 = Arrays.asList("Buenos Aires", "Córdoba"); // unmutable list
        ArrayList<String> places2 = new ArrayList<>(Arrays.asList("Bariloche", "La Plata"));

        log.debug("********** Lists { **********");
        // places1.add("Mendoza"); throws exception for trying to add an item to an unmutable list
        for (String aPlaces1 : places1)
            log.debug(aPlaces1);

        places2.add("Mar de Plata");
        for (String place : places2)
            log.debug(place);
        log.debug("********** } Lists **********");
    }

}
