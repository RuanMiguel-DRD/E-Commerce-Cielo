package ecommerce.cielo;


import lombok.Getter;


@Getter
public enum Environment {

    SANDBOX(
        "https://apisandbox.cieloecommerce.cielo.com.br/",
        "https://apiquerysandbox.cieloecommerce.cielo.com.br/"
    ),

    PRODUCTION(
        "https://api.cieloecommerce.cielo.com.br/",
        "https://apiquery.cieloecommerce.cielo.com.br/"
    );

    private final String urlTransactional;
    private final String urlQuery;

    private Environment(String transactional, String query) {
        this.urlTransactional = transactional;
        this.urlQuery = query;
    }

}
