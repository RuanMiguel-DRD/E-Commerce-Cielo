package ecommerce.cielo.api.web;


import lombok.NonNull;

import java.net.http.HttpClient;

import java.net.http.HttpRequest.Builder;


// A ideia é que a classe Network sirva para:
// Guardar o cliente HTTP que será usado nas requisições
// Guardar o cabeçalho padrão da API da Cielo para reutilização
// Tratamento de erros genéricos e comuns, como falta de acesso a internet, erro de timeout, entre outras coisas]
// Problemas específicos de conexão ou uso incorreto da API, serão tratadas nos métodos das devidas classes, Query e Transactional
public class Network {

    private final HttpClient client;
    private final Builder request;

    public Network(@NonNull HttpClient client, @NonNull Builder request) {
        this.request = request;
        this.client = client;
    }

}
