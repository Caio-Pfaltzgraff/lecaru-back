package com.caiopfaltzgraff.lecaru.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestApi {

    public <T> T send(String url, Class<T> responseType) {
        URI endpoint = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder().uri(endpoint).build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), responseType);
        } catch (IOException | InterruptedException e) {
            throw  new RuntimeException("Error api: " + e.getMessage());
        }
    }

}
