package com.percyvega.testing.integration;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTestExampleIT {

    @Test
    public void testInternetConnection() throws IOException {
        URL url = new URL("https://www.google.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        boolean bodyFound = false;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("body")) {
                bodyFound = true;
                break;
            }
        }

        assertTrue(bodyFound);

        in.close();
    }

}
