package ecommerce.cielo;


import lombok.NonNull;

import java.net.http.HttpClient;

import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

import java.time.Duration;

import ecommerce.cielo.api.Query;
import ecommerce.cielo.api.Transactional;

import ecommerce.cielo.api.web.Network;


public class Client {

    public final Query query;
    public final Transactional transactional;

    public Client(@NonNull Credentials auth, @NonNull Environment env) {
        this(auth, env, null);
    }

    public Client(@NonNull Credentials auth, @NonNull Environment env, HttpClient client) {

        // Basic/standard HTTP client
        if (client == null) {
            client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        }

        // Universal HTTP header
        Builder request = HttpRequest.newBuilder()
            .headers(
                "Accept", "application/json",
                "Content-Type", "application/json",
                "MerchantId", auth.getMerchantId(),
                "MerchantKey", auth.getMerchantKey()
            );

        Network net = new Network(client, request);

        this.query = new Query(net, env.getUrlQuery());
        this.transactional = new Transactional(net, env.getUrlTransactional());

    }

}
