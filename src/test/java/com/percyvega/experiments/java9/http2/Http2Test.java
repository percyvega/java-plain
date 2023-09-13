package com.percyvega.experiments.java9.http2;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Log4j2
public class Http2Test {

    String minimalHtmlPageUrl = "https://gist.githubusercontent.com/cmalven/1885287/raw/5da9cc0e23f287b86cc753beae1209dabccf5570/index.html";

    @Test
    void old_way_of_reading_from_a_website() throws IOException {
        URL url = new URL(minimalHtmlPageUrl);

        URLConnection urlConnection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(inputLine).append("\n");
        }
        bufferedReader.close();

        log.info(stringBuilder);
    }

    @Test
    void new_way_of_reading_from_a_website() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(minimalHtmlPageUrl);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).GET().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        log.info(httpResponse.body());
    }
}
