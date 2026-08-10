package io.github.ruanmiguel.drd.ecommerce.cielo.api.web;


import lombok.NonNull;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

import java.net.http.HttpRequest.Builder;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.io.IOException;


public class Network {

    private final HttpClient client;
    private final Builder request;

    public Network(@NonNull HttpClient client, @NonNull Builder request) {
        this.request = request;
        this.client = client;
    }

    public Builder getBuilder() {
        return this.request;
    }

    public NetworkResponse<String> send(HttpRequest request) {

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return NetworkResponse.success(response);

        } catch (ConnectException e) {
            return NetworkResponse.error(NetworkError.CONNECTION_FAILED, e);

        } catch (UnknownHostException e) {
            return NetworkResponse.error(NetworkError.NO_INTERNET, e);

        } catch (IOException e) {
            return NetworkResponse.error(NetworkError.IO_ERROR, e);

        // ? ? ?
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return NetworkResponse.error(NetworkError.INTERRUPTED, e);

        }

    }

}
