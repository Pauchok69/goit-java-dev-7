package org.andy;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker httpStatusChecker;

    public HttpStatusImageDownloader() {
        this.httpStatusChecker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws Exception {
        URI uri = URI.create(httpStatusChecker.getStatusImage(code));

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .timeout(Duration.ofSeconds(20L))
                .build();

        HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

        Files.copy(response.body(), Paths.get(code + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
    }
}
