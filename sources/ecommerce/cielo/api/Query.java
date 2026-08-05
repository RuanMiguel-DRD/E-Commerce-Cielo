package ecommerce.cielo.api;


import ecommerce.cielo.api.web.Network;


public class Query {

    private final Network net;
    private final String url;

    public Query(Network net, String url) {
        this.net = net;
        this.url = url;
    }

}
