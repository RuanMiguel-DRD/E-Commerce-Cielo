package ecommerce.cielo.api;


import lombok.NonNull;

import java.net.URI;

import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

import ecommerce.cielo.api.web.Network;
import ecommerce.cielo.api.web.NetworkResponse;

import ecommerce.cielo.internal.RegexCode;


public class Query {

    private final Network net;
    private final String url;

    public Query(Network net, String url) {
        this.net = net;
        this.url = url;
    }

    public void getBin(@NonNull String bin) {

        if (!bin.matches(RegexCode.BIN)) {
            throw new IllegalArgumentException();
        }

        HttpRequest request = this.net.getBuilder()
            .uri(URI.create(this.url + "1/cardbin/" + bin))
            .GET()
            .build();

        NetworkResponse<String> response = this.net.send(request);

    }

}
