package ecommerce.cielo.api;


import ecommerce.cielo.api.web.Network;


public class Transactional {

    private final Network net;
    private final String url;

    public Transactional(Network net, String url) {
        this.net = net;
        this.url = url;
    }

}
