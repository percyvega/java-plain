package com.percyvega.testing.integration;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class IntegrationTestExampleIT {

    @Test
    public void testInternetConnection() throws IOException {
        URL oracle = new URL("http://www.clocktab.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        boolean foundTimeTable = false;
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.contains("timeTable")) {
                foundTimeTable = true;
                break;
            }
        }

        assertTrue(foundTimeTable);

        in.close();
    }

}
