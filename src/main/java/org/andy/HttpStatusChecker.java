package org.andy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpStatusChecker {
    private static final int HTTP_STATUS_200 = 200;
    private static final String URI_PATTERN = "https://http.cat/%d.jpg";

    public String getStatusImage(int code) throws Exception {
        URI uri = URI.create(String.format(URI_PATTERN, code));

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .timeout(Duration.ofSeconds(20L))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != HTTP_STATUS_200) {
            throw new Exception("There is no image with current status: " + code);
        }

        return uri.toString();
    }
}
