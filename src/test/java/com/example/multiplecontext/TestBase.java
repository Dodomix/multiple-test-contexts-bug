package com.example.multiplecontext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TestBase {

    @LocalServerPort
    protected Integer serverPort;

    @Test
    void callDummyController() throws IOException, InterruptedException {
        var requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:%d".formatted(serverPort)));
        var request = requestBuilder.GET().build();
        var httpClient = HttpClient.newHttpClient();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // then
        then(response.statusCode()).isEqualTo(200);
    }
}
